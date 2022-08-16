package com.example.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.bulk.*;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.ByteSizeUnit;
import org.elasticsearch.common.unit.ByteSizeValue;
import org.elasticsearch.common.unit.TimeValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

@Slf4j
@Configuration
public class EsConfig {

    @Value("${spring.elasticsearch.rest.uris}")
    private String hostList;

    @Bean
    public RestHighLevelClient client(){
        String[] split = hostList.split(",");
        HttpHost[] httpHosts = new HttpHost[split.length];
        for (int i=0;i<split.length;i++) {
            String item = split[i];
            httpHosts[i] = new HttpHost(item.split(":")[0],Integer.parseInt(item.split(":")[1]), "http");
        }
        return new RestHighLevelClient(RestClient.builder(httpHosts));
    }


    public BulkProcessor getBulkProcessor(RestHighLevelClient client) {
        BulkProcessor bulkProcessor = null;
        try {
            BulkProcessor.Listener listener = new BulkProcessor.Listener() {
                @Override
                public void beforeBulk(long executionId, BulkRequest request) {
                    log.info("Try to insert data number : "
                            + request.numberOfActions());
                }
                @Override
                public void afterBulk(long executionId, BulkRequest request,
                                      BulkResponse response) {
                    log.info("************** Success insert data number : "
                            + request.numberOfActions() + " , id: " +
                            executionId);
                }
                @Override
                public void afterBulk(long executionId, BulkRequest request,
                                      Throwable failure) {
                    log.error("Bulk is unsuccess : " + failure + ",executionId: " + executionId);
                }
            };
            BiConsumer<BulkRequest, ActionListener<BulkResponse>> bulkConsumer =
                    (request, bulkListener) -> client
                            .bulkAsync(request, RequestOptions.DEFAULT, bulkListener);

            BulkProcessor.Builder builder = BulkProcessor.builder(bulkConsumer,
                    listener);
            builder.setBulkActions(5000);
            builder.setBulkSize(new ByteSizeValue(100L, ByteSizeUnit.MB));
            builder.setConcurrentRequests(10);
            builder.setFlushInterval(TimeValue.timeValueSeconds(100L));

            builder.setBackoffPolicy(BackoffPolicy.constantBackoff(TimeValue.timeValueSeconds(1L), 3));

            bulkProcessor = builder.build();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                bulkProcessor.awaitClose(100L, TimeUnit.SECONDS);
            } catch (Exception e1) {
                log.error(e1.getMessage());
            }
        }
        return bulkProcessor;
    }

    @Bean(name = "bulkProcessor") // 可以封装为一个bean，非常方便其余地方来进行 写入 操作
    public BulkProcessor bulkProcessor(RestHighLevelClient client){

        BiConsumer<BulkRequest, ActionListener<BulkResponse>> bulkConsumer =
                (request, bulkListener) -> client.bulkAsync(request, RequestOptions.DEFAULT, bulkListener);

        return BulkProcessor.builder(bulkConsumer, new BulkProcessor.Listener() {
                    @Override
                    public void beforeBulk(long executionId, BulkRequest request) {
                        // todo do something
                        int i = request.numberOfActions();
                        log.info("ES 同步数量{}",i);
                    }

                    @Override
                    public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
                        // todo do something
                        Iterator<BulkItemResponse> iterator = response.iterator();
                        while (iterator.hasNext()){
                            System.out.println(JSON.toJSONString(iterator.next()));
                        }
                    }

                    @Override
                    public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
                        // todo do something
                        log.info("写入ES 重新消费");
                    }
                }).setBulkActions(1000) //  达到刷新的条数
                .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.MB)) // 达到 刷新的大小
                .setFlushInterval(TimeValue.timeValueSeconds(5)) // 固定刷新的时间频率
                .setConcurrentRequests(1) //并发线程数
                .setBackoffPolicy(BackoffPolicy.exponentialBackoff(TimeValue.timeValueMillis(100), 3)) // 重试补偿策略
                .build();

    }
}
