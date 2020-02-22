package com.example.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * @ClassName: HttpRequestUtil
 * @Description: http请求工具类
 */
public class HttpRequestUtil {

    private final static String ENCODED = "UTF-8";

    /**
     * 发起http请求获取返回结果
     * @param reqUrl 请求地址
     * @return
     */
    public static String httpRequestGet(String reqUrl)
    {
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL(reqUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection)url.openConnection();
            httpUrlConn.setDoOutput(false);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();
            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, ENCODED);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
        }
        catch (Exception e)  {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    /**
     * 发送http请求取得返回的输入流
     * @param requestUrl 请求地址
     * @return InputStream
     * @throws MalformedURLException 
     */
    public static InputStream requestGetIo(String requestUrl)
        throws Exception
    {
        InputStream inputStream = null;
        URL url = new URL(requestUrl);
        HttpURLConnection httpUrlConn = (HttpURLConnection)url.openConnection();
        httpUrlConn.setDoInput(true);
        httpUrlConn.setRequestMethod("GET");
        httpUrlConn.connect();
        // 获得返回的输入流
        inputStream = httpUrlConn.getInputStream();
        return inputStream;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * @param url 发送请求的 URL json数据
     * @param param，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param jsonFlag 是否使用代理模式
     * @return 所代表远程资源的响应结果
     */
    public static String sendPostReturnJsonStr(String url, String param,String jsonFlag)
    {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection)realUrl.openConnection();
            // 打开和URL之间的连接
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // POST方法
            conn.setRequestMethod("POST");
            // 设置通用的请求属性
            conn.setRequestProperty(CommonConstants.ACCEPT, CommonConstants.ACCEPT_VALUE_SPLIT);
            conn.setRequestProperty(CommonConstants.CONNECTION, CommonConstants.CONNECTION_KEEP_ALIVE);
            conn.setRequestProperty(CommonConstants.USER_AGENT, CommonConstants.USER_AGENT_VALUE_WINDOW);
            if("stringFormate".equals(jsonFlag)) {
            	conn.setRequestProperty(CommonConstants.CONTENT_TYPE, CommonConstants.BUSINESS_URLENCODED);	
            }else if("jsonFormate".equals(jsonFlag)) {
            	conn.setRequestProperty(CommonConstants.CONTENT_TYPE, CommonConstants.CONTENT_TYPE_VALUE_JSON);
            }
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            // 不用缓存
            conn.setUseCaches(false);
            conn.connect();
            // 获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
    		out.write(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
