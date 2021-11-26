package com.example.utils;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.vo.Contract;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * 功能描述:
 *
 * @Author: yang jie
 * @Date: 2021/11/20 15:46
 */
public class EimpUtil {

    public static final String token = "HhZBq2WNaEM7raQCmdt70ZBA8GGSEKG2++Ss1H+YtQtTiqMQLfofXd1Wuk0R6RyXnG+Fwl0MzY071shNVEqzn2f28br9Lasr/VicUfn5YuotsV1BDTBjEZG1dc8lwJHA/P/PJy2uzwgofutXebjVIbFWVoT98Iz+0VdaNqeNM6rlym0GfTK8mool2VFfLmgs";
    public static final String detailUrl = "https://eimp-gateway.sinoiov.com/newapi/contract/getContractDetails?contractId=";
    public static final String Url = "https://eimp-gateway.sinoiov.com/newapi/contract/list";

    public static final RestTemplate restTemplate = new RestTemplate();

    public static final String contracts = "ZJCL-2021-QT-安全服务合作协议-01-GT[1123],CLW-XS-202111-GT[01656],ZJCL-2020-QT-安全服务合作协议-01-GT[3263],ZJCL-2019-FW-中国平安保险风控业务合作协议-29-GT[6598],ZJCL-2020-QT-安全服务合作协议-01-GT[4354],ZJCL-2019-FW-安全服务合作协议-48-GT[7061],ZJCL-2021-QT-安全服务合作协议-01-GT[1124],ZJCL-2021-QT-安全服务合作协议-01-GT[1120],ZJCL-2021-QT-安全服务合作协议-01-GT[1122],ZJCL-2021-QT-安全服务合作协议-01-GT[1121],ZBCA-FW-202110-GT[01013],ZBCA-FW-202110-GT[01130],ZBCA-FW-202110-GT[01012],CLW-XS-202110-GT[0542],ZBCA-XS-202109-GT[0189],ZJCL-2021-QT-安全服务合作协议-01-GT[4165],ZJCL-2021-QT-安全服务合作协议-01-GT[2597],ZJCL-2021-QT-安全服务合作协议-01-GT[4309],ZJCL-2021-QT-安全服务合作协议-01-GT[3765],ZJCL-2021-QT-安全服务合作协议-01-GT[4111],ZJCL-2021-QT-安全服务合作协议-01-GT[4309],ZJCL-2021-QT-安全服务合作协议-01-GT[3807],CLW-XS-202110-GT[01033],ZJCL-2021-QT-安全服务合作协议-01-GT[3339],CLW-XS-202109-GT[0212],ZBCA-FW-202109-GT[0163],ZJCL-2021-QT-安全服务合作协议-01-GT[2499],CLW-FW-202109-GT[0271],ZBCA-2021-QT-安全服务合作协议-01-GT[1910],ZJCL-2021-QT-安全服务合作协议-01-GT[1428],ZJCL-2021-QT-安全服务合作协议-01-GT[4308],ZBCA-2021-QT-安全服务合作协议-01-GT[4201],ZJCL-2021-QT-安全服务合作协议-01-GT[2496],ZJCL-2021-QT-安全服务合作协议-01-GT[2534],ZJCL-2021-QT-安全服务合作协议-01-GT[2482],ZJCL-2021-QT-安全服务合作协议-01-GT[4001],ZJCL-2021-QT-安全服务合作协议-01-GT[4072],ZJCL-2021-QT-安全服务合作协议-01-GT[4109],CLW-XS-202111-GT[01292],ZJCL-2021-QT-安全服务合作协议-01-GT[3949],ZJCL-2021-QT-安全服务合作协议-01-GT[3865],ZJCL-2021-QT-安全服务合作协议-01-GT[3766],ZJCL-2021-QT-安全服务合作协议-01-GT[3707],ZJCL-2021-QT-安全服务合作协议-01-GT[3620],ZJCL-2021-QT-安全服务合作协议-01-GT[3621],ZJCL-2021-QT-安全服务合作协议-01-GT[3619],ZJCL-2021-QT-安全服务合作协议-01-GT[3625],ZJCL-2021-QT-安全服务合作协议-01-GT[3617],ZJCL-2021-QT-安全服务合作协议-01-GT[3624],ZBCA-2021-QT-安全服务合作协议-01-GT[2835],ZJCL-2021-QT-安全服务合作协议-01-GT[3710],ZJCL-2021-QT-安全服务合作协议-01-GT[3338],ZJCL-2021-QT-安全服务合作协议-01-GT[2601],ZJCL-2020-QT-安全服务托管协议-01-GT-[4114],ZJCL-2021-QT-安全服务合作协议-01-GT[2342],ZJCL-2021-QT-安全服务合作协议-01-GT[3532],ZJCL-2021-QT-安全服务合作协议-01-GT[2735],ZJCL-2021-QT-安全服务合作协议-01-GT[1796],ZJCL-2021-QT-安全服务合作协议-01-GT[2607],ZJCL-2018-ZL-大地保险风控业务合作协议-01-GT[127],ZJCL-2021-QT-项目合作协议-01-GT[2339],ZJCL-2021-QT-安全服务合作协议-01-GT[2669],ZJCL-2021-QT-安全服务合作协议-01-GT[1424],ZJCL-2020-QT-项目合作协议-01-GT[6875],ZJCL-2021-QT-安全服务合作协议-01-GT[1983],ZJCL-2020-FW-安全服务协议-46-GT[1791],ZBCA-2021-QT-安全服务合作协议-01-GT[4201],ZJCL-2020-QT-安全服务合作协议-01-GT[4235],ZJCL-2021-QT-安全服务合作协议-01-GT[1124],ZJCL-2021-QT-安全服务合作协议-01-GT[1123],ZJCL-2021-QT-安全服务合作协议-01-GT[1122],ZJCL-2021-QT-安全服务合作协议-01-GT[1121],ZJCL-2021-QT-安全服务合作协议-01-GT[1120],ZJCL-2021-QT-安全服务合作协议-01-GT[1506],ZJCL-2021-QT-安全服务合作协议-01-GT[1740],ZJCL-2021-QT-安全合作服务协议-01-GT[1225],ZJCL-2018-ZL-大地保险风控业务合作协议-01-GT[127],ZJCL-2018-ZL-大地保险风控业务合作协议-01-GT[127],ZJCL-2021-QT-安全服务合作协议-01-GT[1522],ZJCL-2021-QT-安全服务合作协议-01-GT[1816],ZJCL-2021-QT-安全服务合作协议-01-GT[1559],ZJCL-2020-FW-安全服务合作协议-25-GT[1034],ZJCL-2020-FW-安全服务合作协议-4-GT[399],ZJCL-2020-QT-安全服务合作协议-01-GT[3063],ZJCL-2020-FW-安全服务协议-47-GT[1904],ZJCL-2020-FW-安全服务合作协议-26-GT[1036],ZJCL-2020-QT-安全服务合作协议-01-GT[3049],ZJCL-2020-FW-安全服务合作协议-14-GT[1005],ZJCL-2020-QT-安全服务合作协议-01-GT[3310],ZJCL-2020-FW-安全服务合作协议-12-GT[1002],ZJCL-2020-FW-安全服务合作协议-43-GT[1457],ZJCL-2020-FW-安全服务合作协议-24-GT[1028],ZJCL-2020-FW-安全服务合作协议-13-GT[1004],ZJCL-2019-QT-战略合作框架协议-86-GT[6884],ZBCA-2021-QT-安全服务合作协议-01-GT[1910],ZJCL-2019-QT-陕西平安合作协议-80-GT[6743],ZBCA-2021-QT-安全服务合作协议-01-GT[1793],ZJCL-2021-QT-合作协议-01-GT[952],ZJCL-2021-QT-安全服务合作协议-01-GT[1427],ZJCL-2021-QT-安全服务合作协议-01-GT[1102],ZJCL-2020-QT-安全服务合作协议-01-GT[6872],ZJXL-2021-QT-安全服务合作协议-01-GT[1024],ZJCL-2021-QT-安全服务协议-01-GT[784],ZJCL-2020-FW-安全服务合作协议-40-GT[1224],ZJCL-2020-FW-安全服务合作协议-38-GT[1222],ZJCL-2020-FW-安全服务合作协议-32-GT[1049],ZJCL-2019-FW-安全服务合作协议-32-GT[6606],ZJCL-2019-ZL-天安财险安全服务合作协议-06-GT[1735],ZJCL-2021-QT-安全服务合作协议-01-GT[1521],ZJCL-2020-QT-安全服务合作协议-01-GT[4028],ZJCL-2020-QT-安全服务合作协议-01-GT[3101],ZJCL-2020-QT-安全服务合作协议-01-GT[4354],ZJCL-2021-QT-安全服务合作协议-01-GT[297],ZJCL-2019-QT-战略合作框架协议-86-GT[6884],ZJCL-2020-FW-安全服务合作协议-24-GT[1028],ZJCL-2020-FW-安全服务合作协议-43-GT[1457],ZJCL-2019-FW-中国平安保险风控业务合作协议-29-GT[6598],ZJCL-2020-QT-安全服务合作协议-01-GT[4190],ZJCL-2020-FW-安全服务合作协议-41-GT[1373],ZJCL-2021-QT-安全服务合作协议-01-GT[529],ZJCL-2020-FW-安全服务协议-45-GT[1476],ZJCL-2021-QT-安全服务合作协议-01-GT[301],ZJCL-2021-QT-安全服务合作协议-01-GT[490],ZJCL-2020-FW-安全服务合作协议-6-GT644],ZJCL-2020-QT-安全服务合作协议-01-GT[6461],ZJCL-2020-QT-安全服务托管协议-01-GT-[4114],ZJCL-2020-FW-安全服务合作协议-9-GT[877],ZJCL-2020-QT-安全服务合作协议-01-GT[3921],ZJCL-2019-ZL-中国人民保险风控业务合作协议-7-GT[1106],ZJCL-2020-QT-安全服务合作协议-01-GT[3463],ZJCL-2019-ZL-天安保险风控业务合作协议-01-GT[5],ZJCL-2018-ZL-卡车犇犇风控业务合作协议-01-GT[901],ZJCL-2021-QT-安全服务合作协议-01-GT[1680],ZJCL-2018-ZL-大地保险风控业务合作协议-01-GT[127],ZJCL-2019-ZL-渤海保险风控业务合作协议-01-GT[381],ZJCL-2020-FW-安全服务合作协议-12-GT[1002],ZJCL-2020-QT-安全服务合作协议-01-GT[3310],ZJCL-2020-FW-安全服务合作协议-14-GT[1005],ZJCL-2020-QT-安全服务合作协议-01-GT[3049],ZJCL-2020-FW-安全服务合作协议-26-GT[1036],ZJCL-2020-QT-安全服务合作协议-01-GT[6416],ZJCL-2020-QT-安全服务合作协议-01-GT[6867],ZJCL-2021-QT-安全服务合作协议-01-GT[401],ZJCL-2020-QT-安全服务合作协议-01-GT[3248],ZJCL-2018-ZL-大地保险风控业务合作协议-01-GT[127],ZJCL-2021-QT-项目合作协议-01-GT[2339],ZJCL-2020-FW-安全服务协议-47-GT[1904],ZJCL-2020-QT-安全服务合作协议-01-GT[3063],ZJCL-2020-FW-安全服务合作协议-4-GT[399],ZJCL-2020-FW-安全服务合作协议-11-GT-[1001],ZJCJ-2019-ZL-鼎和财产保险风控协议-11-GT[1787],ZJCL-2020-FW-安全服务合作协议-35-GT[1219],ZJCL-2020-FW-安全服务合作协议-37-GT[1221],ZJCL-2020-FW-安全服务合作协议-33-GT[1050],ZJCL-2020-FW-安全服务合作协议-31-GT[1048],ZJCL-2020-FW-安全服务合作协议-30-GT[1047],ZJCL-2020-QT-安全服务合作协议-01-GT[4833],ZJCL-2019-FW-车辆安全服务协议-65-GT[4774],ZJCL-2021-QT-安全服务合作协议-01-GT[326],ZJCL-2020-QT-安全服务合作协议-01-GT[6868],ZJCL-2020-FW-安全服务合作协议-34-GT[1218],ZJCL-2020-QT-安全服务合作协议-01-GT[6648],ZJCL-2018-ZL-平安保险风控业务合作协议-08-GT[389],ZJCL-2021-QT-安全服务合作协议-01-GT[527],ZJCL-2020-FW-安全服务协议-46-GT[1791],ZJCL-2018-ZL-大地保险风控业务合作协议-01-GT[127],ZJCL-2021-QT-安全服务合作协议-01-GT[741],ZJCL-2020-QT-河南都邦风控合作协议-01-GT[2842],ZJCL-2020-QT-安全服务合作协议-01-GT[4488],ZJCL-2020-QT-安全服务合作协议-01-GT[3037],ZJCL-2019-ZL-紫金财产安全服务合作协议-03-GT[1131],ZJCL-2020-FW-安全服务合作协议-13-GT[1004],ZJCL-2020-QT-安全服务合作协议-01-GT[2802],ZJCL-2020-FW-安全服务协议-51-GT[2082],ZJCL-2020-QT-安全服务合作协议-01-GT[5926],ZJCL-2020-FW-安全服务合作协议-28-GT[1045],ZJCL-2020-QT-安全服务合作协议-01-GT[4711],ZJCL-2020-QT-安全服务合作协议-01-GT[2836],ZJCL-2018-ZL-大地保险风控业务合作协议-01-GT[127],ZJCL-2020-FW-安全服务合作协议-02-GT[2],ZJCL-2019-QT-陕西平安合作协议-80-GT[6743],ZJCL-2021-QT-安全服务合作协议-01-GT[547],ZJCL-2020-QT-安全服务合作协议01-GT[5924],ZJCL-2020-FW-青岛国寿财风控业务合作协议-05-GT[406],ZJCL-2020-QT-安全服务合作协议-01-GT[6872],ZJCL-2020-FW-安全服务合作协议-28-GT[1045],ZJCL-2020-FW-安全服务合作协议-36-GT[1220],ZJCL-2020-FW-安全服务合作协议-39-GT[1223],ZJCL-2020-QT-安全服务合作协议-01-GT[6886],ZBCA-2021-QT-安全服务合作协议-01-GT[956],ZJCL-2018-ZL-大地保险风控业务合作协议-01-GT[127],ZJCL-2019-FW-车辆安全服务协议-134-GT[5463],ZJCL-2020-QT-安全服务合作协议-01-GT[4719],ZJCL-2020-FW-安全服务合作协议-52-GT[2172],ZJCL-2020-QT-安全服务合作协议-01-GT[3269],ZJXL-2021-QT-安全服务合作协议-01-GT[920],ZJCL-2018-ZL-大地保险风控业务合作协议-01-GT[127],ZJCL-2020-QT-安全服务合作协议-01-GT[5724],ZJCL-2019-FW-安全服务合作协议-48-GT[7061],ZJCL-2020-FW-安全服务合作协议-42-GT[1376],ZJCL-2019-ZL-天安保险风控业务合作协议-01-GT[5],ZJCL-2020-QT-安全服务合作协议-01-GT[5319],ZJCL-2019-ZL-鼎和财产安全服务合作协议-39-GT[3390],ZJCL-2020-FW-安全服务合作协议-7-GT[800],ZJCL-2021-QT-安全服务合作协议-01-GT[2667],ZJCL-2021-QT-安全服务合作协议-01-GT[905],ZJCL-2020-FW-安全服务合作协议-25-GT[1034],ZJCL-2020-QT-安全服务合作协议-01-GT[4109],ZJCL-2020-QT-安全服务合作协议-01-GT[3855],ZJCL-2020-QT-安全服务合作协议-01-GT[3246],ZJCL-2020-QT-项目合作协议-01-GT[6875],ZJCL-2020-QT-安全服务合作协议-01-GT[4602],ZJCL-2019-ZL-甘肃人民财产保险风控协议-33-GT[2824],";

    public static void main(String[] args) {
        handleUlr("https://eimp-s3.sinoiov.com/api/urlDownload/contract/20211115/2c026181-3fb6-4e7c-8694-b72b84a74136/苏州大地.pdf?authKey=1637402869-2b1c59b01508429db546f99266e7d93b-0-8f37dc46ba3c99f34b6f37a0675adcae");
    }

    public static List<Contract> getList(){
        List<Contract> list = new ArrayList<>();
        List<String> contractList = new ArrayList<>(Arrays.asList(contracts.split(",")));
        for(String str : contractList) {
            Contract vo = getContract(str);
            list.add(vo);
        }
        return list;
    }

    public static List<Contract> getList2(){
        List<Contract> list = new ArrayList<>();
        String s = "851,8805,9041,10485,10507,10527,10529,10531,10533,10535,10537,10539,10541,10611,10649,10691,10699,10773,10807,10835,10837,10839,10841,10843,10857";
        List<String> ids = new ArrayList<>(Arrays.asList(s.split(",")));
        for(String str : ids) {
            Contract vo = new Contract();
            JSONObject jsonObject = getDetail(Long.parseLong(str));
            build(vo,jsonObject);
            list.add(vo);
        }
        return list;
    }

    private static JSONObject getDetail(Long id) {
        JSONObject data = null;
        try {
            String baseUrl = detailUrl + id;
            HttpHeaders headers = new HttpHeaders();
            headers.add("token", token);
            headers.add("Content-Type", "application/json");
            Map<String, Object> map = new HashMap<>(8);
            ResponseEntity<JSONObject> response = restTemplate.exchange(baseUrl, HttpMethod.GET, new HttpEntity<>(map, headers), JSONObject.class, new HashMap<>());
            data = response.getBody().getJSONObject("data");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    private static Long getIdByContractNo(String contractNo){
        Long id = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("token", token);
            headers.add("Content-Type", "application/json");
            Map<String, Object> map = new HashMap<>(8);
            map.put("serialNumber", contractNo);
            Map<String,Object> page = new HashMap<>();
            page.put("current",1);
            page.put("size",10);
            map.put("page",page);
            JSONObject result = restTemplate.postForObject(Url, new HttpEntity<>(map, headers), JSONObject.class);
            id = result.getJSONObject("data").getJSONArray("records").getJSONObject(0).getLong("id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    private static Contract getContract(String contractNo){
        Contract vo = new Contract();
        vo.setContractNo(contractNo);

        Long id = getIdByContractNo(contractNo);
        if(id == null) {
            return vo;
        }
        JSONObject jsonObject = getDetail(id);
        build(vo,jsonObject);
        return vo;
    }

    private static void build(Contract vo,JSONObject data){
        String serialNumber = data.getString("serialNumber");
        vo.setContractNo(serialNumber);

        String contractName = data.getString("name");
        vo.setContractName(contractName);

        String customerName = data.getString("opposingCompany");
        vo.setCustomerName(customerName);

        String customerSign = data.getString("mainCompanyName");
        vo.setCustomerSign(customerSign);

        JSONArray jsonArray = data.getJSONArray("annexeList");

        String contractFileName = "";

        String contractFilePath = "";
        if(jsonArray == null) {
            return;
        }
        for(int i=0;i<jsonArray.size();i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            contractFileName = contractFileName + json.getString("fileName") + ",";
            contractFilePath = contractFilePath + handleUlr(json.getString("filePath")) + ",";
        }
        if (contractFileName.length() > 0){
            contractFileName = contractFileName.substring(0,contractFileName.length() - 1);
        }
        if (contractFilePath.length() > 0){
            contractFilePath = contractFilePath.substring(0,contractFilePath.length() - 1);
        }

        vo.setContractFileName(contractFileName);
        vo.setContractFilePath(contractFilePath);

    }

    private static String handleUlr(String path){
        if(path == null){
            return null;
        }
        int s = 27;
        int e = path.indexOf("?authKey");
        String str = path.substring(s,e);
        return str;
    }
}
