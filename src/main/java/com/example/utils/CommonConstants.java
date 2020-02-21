
package com.example.utils;

/** 
* @ClassName: CommonConstants 
* @Description: 常量类
* @author 000001
* @date 2017年6月6日 上午9:11:21 
*  
*/
public class CommonConstants
{

    public static final String UTF8 = "UTF-8";

    public static final String GBK = "GBK";
    
    public static String ISO_8859_1 = "ISO-8859-1";

    public static final String PUSHQUEUE = "push_queue";

    /** 鍒嗛〉琛屾暟 */
    public static final int LIMIT = 20;

    public static final int DAYOFSEC = 86400;

    /** 缓存生存周期为1当天的key分隔符 */
    public static final String DAYSPLIT = "&&";

    /** 详细到分钟的正则表达式 */
    public static final String MINREGX = "^[1-2][0-9][0-9][0-9]-([1][0-2]|0?[1-9])-([12][0-9]|3[01]|0?[1-9]) ([01][0-9]|[2][0-3]):[0-5][0-9]$";

    /** 详细到日期的正则表达式 */
    public static final String DATEREGX = "^[1-2][0-9][0-9][0-9]-([1][0-2]|0?[1-9])-([12][0-9]|3[01]|0?[1-9])$";

    public static final String EQUELS_MARK = "=";

    public static final String AND_MARK = "&";

    public static final String UTF_8 = "utf-8";

    public static final String MD5 = "MD5";

    public static final String JPUSH = "jpush";

    public static final String BUSINESS = "business";

    public static final String CONTENT_TYPE = "Content-type";

    public static final String CONTENT_TYPE_VALUE_JSON = "application/json;charset=UTF-8";
    
    public static final String ACCEPT = "accept";
    
    public static final String ACCEPT_VALUE_SPLIT = "*/*";
    
    public static final String CONNECTION = "connection";
    
    public static final String CONNECTION_KEEP_ALIVE = "Keep-Alive";
    
    public static final String USER_AGENT = "user-agent";
    
    public static final String USER_AGENT_VALUE_WINDOW = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)";
    
    public static final String BUSINESS_URLENCODED = "application/x-www-form-urlencoded; charset=UTF-8";
    
    /** 微信鼓励金相关字段 */
    public static final String NONE_STR = "nonce_str";

    public static final String MCH_BILLNO = "mch_billno";

    public static final String MCH_ID = "mch_id";

    public static final String WXAPPID = "wxappid";

    public static final String SEND_NAME = "send_name";

    public static final String RE_OPENID = "re_openid";

    public static final String TOTAL_NUM = "total_num";

    public static final String WISHING = "wishing";

    public static final String CLIENT_IP = "client_ip";

    public static final String ACT_NAME = "act_name";

    public static final String REMARK = "remark";

    public static final String SIGN = "sign";


    public static final String ISO8859_1 = "ISO8859-1";


    public static final String PKCS12 = "PKCS12";

    public static final String TLSV1 = "TLSv1";

    public static final String START_TIME = "start_time";

    public static final String OPENID = "openid";

    public static final String ORDER_ID = "order_id";

    public static final String REDPACK_TYPE = "redpack_type";

    public static final String BUSINESS_NAME = "business_name";

    public static final String CASH_COUPON_TYPE = "cash_coupon_type";

    public static final String IS_PAY = "is_pay";
    
    public static final String TOTAL_AMOUNT = "total_amount";
    
    public static final String RESULT_CODE = "result_code";

    public static final String RETURN_MSG = "return_msg";

    public static final String PAIED_NUM = "paied_num";

    public static final String COUPON_NUM = "coupon_num";

    public static final String FAIL = "FAIL";

    public static final String SUCCESS = "SUCCESS";

    public static final Integer FAIL_CODE= -1;

    public static final Integer SUCCESS_CODE = 0;
    
    public static final String SCENE_ID = "scene_id";
    
    public static final String MASTER_DATA_SOURCE = "masterDataSource";
    
    public static final String SLAVE_DATA_SOURCE = "slaveDataSource";
    
    //调用rest opFlg字段 禁用0 && 可用1

    public static final  String OPFLG_SUCESS = "1";

    public static final  String OPFLG_FAIL = "0";

    //代表入库耗材 减少 0 或者 增加 1

    public static final  String ADD_STATUE = "1";

    public static final  String REDUCE_STATUE  = "0";



}
