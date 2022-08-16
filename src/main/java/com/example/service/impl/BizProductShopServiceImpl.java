package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.BizProductShop;
import com.example.service.BizProductShopService;
import com.example.mapper.BizProductShopMapper;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
* @author dyang
* @description 针对表【biz_product_shop】的数据库操作Service实现
* @createDate 2022-08-16 15:30:24
*/
@Service
public class BizProductShopServiceImpl extends ServiceImpl<BizProductShopMapper, BizProductShop>
    implements BizProductShopService{


    @Autowired
    private BulkProcessor bulkProcessor;

    @Autowired
    private RestHighLevelClient client;

    @PostConstruct
    public void test() throws IOException {
        List<BizProductShop> list = this.list();
        for(BizProductShop shop : list) {
            IndexRequest indexRequest = new IndexRequest("biz_product_shop");
            indexRequest.id(shop.getId().toString());
            bulkProcessor.add(indexRequest.source(JSON.parseObject(JSON.toJSONString(shop))));
        }
        bulkProcessor.flush();
        DeleteRequest deleteRequest = new DeleteRequest("biz_product_shop");
        DeleteByQueryRequest delete = new DeleteByQueryRequest("biz_product_shop");
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("id", "2");
        queryBuilder.mustNot(termQueryBuilder);
        delete.setQuery(queryBuilder);

//         client.deleteByQuery(delete,RequestOptions.DEFAULT);
//         client.delete(new DeleteRequest("biz_product_shop"),RequestOptions.DEFAULT);
    }

    @Override
    public Object search(String keyword, int pageNum, int PageSize) throws IOException {

        SearchRequest searchRequest = new SearchRequest("biz_product_shop");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //分页 index = (当前页-1)*一页显示条数
        searchSourceBuilder.from((pageNum - 1) * PageSize);
        searchSourceBuilder.size(PageSize);

        //精准匹配
        //TermQueryBuilder termQueryBuilder =
        // QueryBuilders.termQuery("positionName",keyword);
        //searchSourceBuilder.query(termQueryBuilder);
        QueryBuilder builder = QueryBuilders.matchQuery("address",keyword);
        searchSourceBuilder.query(builder);

        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        //执行搜索
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = client.search(searchRequest,
                RequestOptions.DEFAULT);
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        SearchHit[] hits = searchResponse.getHits().getHits();
        System.out.println(hits.length);
        for (SearchHit hit : hits) {
            list.add(hit.getSourceAsMap());
        }
        return list;
    }
}




