package com.example.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

@Slf4j
public class HttpUtil {
    private static CloseableHttpClient getHttpClient() {
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(200000)
                .setConnectTimeout(200000)
                .setConnectionRequestTimeout(200000)
                .build();
        return HttpClientBuilder
                .create()
                .setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE)
                .setDefaultRequestConfig(defaultRequestConfig)
                .build();
    }

    private static CloseableHttpClient getHttpClient(int timeout) {
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(timeout)
                .setConnectTimeout(timeout)
                .setConnectionRequestTimeout(timeout)
                .build();

        return HttpClientBuilder
                .create()
                .setDefaultRequestConfig(defaultRequestConfig)
                .build();
    }

    public static String ReturnPostObj(String url, String body) {
        String str = ReturnPostBody(url, body, "application/json");
        return str;
    }

    public static String ReturnPostBody(String url, String body) {
        return ReturnPostBody(url, body, "application/json");
    }

    public static String ReturnPostBody(String url, String body, String contentType) {
        StringEntity entity = null;

        if (body != null && !body.equals("")) {
            entity = new StringEntity(body, "UTF-8");
            entity.setContentEncoding("UTF-8");
            entity.setContentType(contentType);
        }

        return ReturnPostBody(url, entity, "UTF-8");
    }

    public static String ReturnPostBody(String url, HttpEntity entity) {
        return ReturnPostBody(url, entity, "UTF-8");
    }

    private static String ReturnPostBody(String url, HttpEntity entity, String responseCharset) {
        return ReturnPostBody(url, entity, responseCharset, null);
    }

    private static String ReturnPostBody(String url, HttpEntity entity, String responseCharset, Map<String, String> headers) {
        try {
            HttpPost post = new HttpPost(url);
            if (entity != null) {
                post.setEntity(entity);
            }
            if (headers != null && headers.size() > 0) {
                headers.keySet().forEach(key -> post.setHeader(key, headers.get(key)));
            }
            HttpResponse response = getHttpClient().execute(post);
            HttpEntity responseEntity = response.getEntity();
            return EntityUtils.toString(responseEntity, responseCharset);
        } catch (Exception ex) {
            log.info("ReturnPostBody:url=" + url, ex);
        }
        return "";
    }

    public static BufferedImage ReturnPostBodyTemp(String url, String body) {
        StringEntity entity = null;
//        LogUtils.Error("请求参数:" + body);
        if (StringUtil.isNotEmpty(body)) {
            entity = new StringEntity(body, "UTF-8");
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json; charset=UTF-8");
        }

        try {
            HttpPost post = new HttpPost(url);
            if (entity != null) {
                post.setEntity(entity);
            }
            HttpResponse response = getHttpClient().execute(post);
            HttpEntity responseEntity = response.getEntity();
            byte[] data = EntityUtils.toByteArray(responseEntity);
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            return ImageIO.read(bais);
        } catch (Exception ex) {
            log.info("ReturnPostBody:url=" + url, ex);
        }
        return null;
    }

    public static BufferedImage ReturnPostBufferedImage(String url, String body) {
        StringEntity entity = null;
        if (StringUtil.isNotEmpty(body)) {
            entity = new StringEntity(body, "UTF-8");
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json; charset=UTF-8");
        }

        try {
            HttpPost post = new HttpPost(url);
            if (entity != null) {
                post.setEntity(entity);
            }
            HttpResponse response = getHttpClient().execute(post);
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity.getContentType().getValue().startsWith("application/json")){
                log.error(EntityUtils.toString(responseEntity, "UTF-8"));
            } else {
                byte[] data = EntityUtils.toByteArray(responseEntity);
                return ImageIO.read(new ByteArrayInputStream(data));
            }
        } catch (Exception ex) {
            log.error("ReturnPostBufferedImage:url=" + url, ex);
        }
        return null;
    }

    public static String ReturnPostBody(String url, HttpEntity entity, Map<String, String> headers) {
        return ReturnPostBody(url, entity, "UTF-8", headers);
    }

    public static String ReturnPostBody(String url, HttpEntity entity, Map<String, String> headers, int timeout) throws IOException {
        HttpPost post = new HttpPost(url);
        if (entity != null) {
            post.setEntity(entity);
        }

        if (headers != null && headers.size() > 0) {
            headers.keySet().forEach(key -> post.setHeader(key, headers.get(key)));
        }

        HttpResponse response = getHttpClient(timeout).execute(post);
        HttpEntity responseEntity = response.getEntity();
        return EntityUtils.toString(responseEntity, "UTF-8");
    }

    public static String ReturnGetBody(String url) {
        try {
            HttpGet httpGet = new HttpGet(url);
            BasicHeader[] x = new BasicHeader[1];
            x[0] = new BasicHeader("xx","ee");
            httpGet.setHeaders(x);
            HttpResponse httpresponse = getHttpClient().execute(httpGet);
            HttpEntity entity = httpresponse.getEntity();
            return EntityUtils.toString(entity, "GBK");
        } catch (Exception ex) {
            log.info("ReturnGetBody:url=" + url, ex);
        }

        return "";
    }


    public static void main(String[] args) {
        String url = "https://cms-api.csdn.net/v1/web_home/select_content?componentIds=www-blog-recommend";
        System.out.println(ReturnGetBody(url));
    }
    
}
