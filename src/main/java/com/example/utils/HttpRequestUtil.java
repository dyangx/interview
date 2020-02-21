package com.example.utils;


import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


/**
 * @ClassName: HttpRequestUtil
 * @Description: http请求工具类
 * @author 000001
 * @date 2017年4月14日 上午11:34:30
 */
public class HttpRequestUtil {

    private final static String ENCODED = "UTF-8";

    static boolean proxySet = false;

    /**
     * 发起http请求获取返回结果
     * 
     * @param reqUrl
     *            请求地址
     * @return
     */
    public static String httpRequestGet(String reqUrl)
    {
        StringBuffer buffer = new StringBuffer();
        try
        {
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
            while ((str = bufferedReader.readLine()) != null)
            {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    /**
     * 发送http请求取得返回的输入流
     * 
     * @param requestUrl
     *            请求地址
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
     * 
     * @param url
     *            发送请求的 URL json数据
     * @param
     *            param，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param jsonFlag
     *            是否使用代理模式
     * @return 所代表远程资源的响应结果
     */
    public static String sendPostReturnJsonStr(String url, String param,String jsonFlag)
    {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";
        try
        {
            URL realUrl = new URL(url);
            HttpURLConnection conn = null;
            conn = (HttpURLConnection)realUrl.openConnection();
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
    		
           // out.write(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null)
            {
                result += line;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally
        {
            try
            {
                if (out != null)
                {
                    out.close();
                }
                if (in != null)
                {
                    in.close();
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static void outputZipFile(HttpServletResponse response, String fileName, String srcPath)
        throws IOException
    {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try
        {
            outputStream = response.getOutputStream();
            inputStream = new FileInputStream(new File(srcPath + fileName));

            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0)
            {
                outputStream.write(b, 0, length);
            }
        }
        finally
        {
            if (null != outputStream)
            {
                outputStream.close();
            }
            if (null != inputStream)
            {
                inputStream.close();
            }
        }

    }

    /**
     * @throws UnsupportedEncodingException  
     * @Title: spliceParam 
     * @Description: 拼接url参数
     * @paramMap
     * @param @return  参数说明 
     * @return StringBuffer    返回类型 
     * @throws 
     */
    public static String spliceParam(Map<String, Object> paramMap) throws UnsupportedEncodingException
    {
        Set<String> keySet = paramMap.keySet();

        Iterator<String> iterator = keySet.iterator();
        StringBuffer paramBuffer = new StringBuffer();
        while (iterator.hasNext())
        {
            String key = iterator.next();
            String value = paramMap.get(key)+"";
            paramBuffer.append(key + "=" + URLEncoder.encode(value+"", "UTF-8"));
            paramBuffer.append("&");

        }
        paramBuffer = paramBuffer.deleteCharAt(paramBuffer.lastIndexOf("&"));
        return paramBuffer.toString();
    }

    /** 
     *  
     * 方法用途: 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序），并且生成url参数串<br> 
     * 实现步骤: <br> 
     *  
     * @paramap   要排序的Map对象 
     * @param urlEncode   是否需要URLENCODE 
     * @param keyToLower    是否需要将Key转换为全小写 
     *            true:key转化成小写，false:不转化 
     * @return 
     */
    public static String formatUrlMap(Map<String, String> paraMap, boolean urlEncode, boolean keyToLower)
    {
        String buff = null;
        Map<String, String> tmpMap = paraMap;
        try
        {
            List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(tmpMap.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>()
            {

                @Override
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2)
                {
                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });
            // 构造URL 键值对的格式
            StringBuilder buf = new StringBuilder();
            for (Map.Entry<String, String> item : infoIds)
            {
                if (null != item.getKey())
                {
                    String key = item.getKey();
                    String val = item.getValue();
                    if (urlEncode)
                    {
                        val = URLEncoder.encode(val, CommonConstants.UTF_8);
                    }
                    if (keyToLower)
                    {
                        buf.append(key.toLowerCase() + CommonConstants.EQUELS_MARK + val);
                    }
                    else
                    {
                        buf.append(key + CommonConstants.EQUELS_MARK + val);
                    }
                    buf.append(CommonConstants.AND_MARK);
                }

            }
            buff = buf.toString();
            if (buff.isEmpty() == false)
            {
                buff = buff.substring(0, buff.length() - 1);
            }
        }
        catch (Exception e)
        {
            return null;
        }
        return buff;
    }

    /** 
     * @Title: md5 
     * @Description: md5加密 
     * @param b
     * @param @return  参数说明 
     * @return String    返回类型 
     * @throws 
     */
    public static String md5(byte[] b)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance(CommonConstants.MD5);
            md.reset();
            md.update(b);
            byte[] hash = md.digest();
            StringBuffer outStrBuf = new StringBuffer(32);
            for (int i = 0; i < hash.length; i++ )
            {
                int v = hash[i] & 0xFF;
                if (v < 16)
                {
                    outStrBuf.append('0');
                }
                outStrBuf.append(Integer.toString(v, 16).toLowerCase());
            }
            return outStrBuf.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
            return new String(b);
        }
    }

}
