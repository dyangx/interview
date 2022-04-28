package com.example.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aspose.pdf.*;
import com.aspose.pdf.facades.PdfContentEditor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class AsposeUtil {

    public AsposeUtil() {
        font = FontRepository.openFont("C:\\Windows\\Fonts\\simsun.ttc");
    }

    public static Font font = null;
    /**
     *
     * @param templateUrl
     * @param vo
     * @return
     */
    public static byte[] generatePDFRegex(String templateUrl,Object vo) {
        // 验证License 若不验证则转化出的文档会有水印产生
        Assert.isTrue(AsposeLicense.getPdfLicense(),"pdf工具授权失败 ！");
        InputStream ins = null;
        byte[] bytes = null;
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            ins = WebUtil.download(templateUrl);
            JSONObject json = JSON.parseObject("{\"account\": \"115866896353\",\"accountBankName\": \"12121212\",\"accountName\": \"1212\",\"accountNumber\": \"12121212\",\"agentName\": \"联联周边游003\",\"assessmentD\": \"15\",\"assessmentM\": \"4\",\"assessmentY\": \"2022\",\"authPersonName\": \"唐超\",\"authPersonPhone\": \"17628353916\",\"bankOfDeposit\": \"中国银行成都鹭洲里支行\",\"bondMoney\": \"1100\",\"companyAddress\": \"成都市武侯区\",\"endD\": \"18\",\"endM\": \"5\",\"endY\": \"2022\",\"expire\": \"0.10\",\"firstPartyAddress\": \"中国(四川)自由贸易试验区成都高新区吉泰路20号1栋14楼\",\"firstPartyContactName\": \"未知1\",\"firstPartyContactPhone\": \"028-67378280\",\"firstPartyName\": \"联联永昌科技(成都)有限公司\",\"firstPartyPhone\": \"028-67378280\",\"firstPartySocialCredit\": \"91510100MA69RMER3R\",\"grossProfitStandard\": \"100\",\"handlerEmail\": \"121212\",\"handlerPhone\": \"212121\",\"handlerWechant\": \"121112\",\"nowDate\": \"2022年04月07日\",\"operationD\": \"5\",\"operationM\": \"4\",\"operationY\": \"2022\",\"partyAContactEmail\": \"111111\",\"partyAContactWechant\": \"12121\",\"partyBSocialCredit\": \"911000000000000371\",\"paymentMethod\": \"\",\"paymentMethod1\": \"\",\"paymentMethod2\": \"\",\"paymentMethod3\": \"\",\"paymentPeriod\": \"11\",\"regionalCooperation\": \"1121121111111111111111111111111111\",\"serviceCharge\": \"1200\",\"serviceD\": \"28\",\"serviceFee\": \"1100\",\"serviceFeeCn\": \"壹仟壹佰元整\",\"serviceHalfD\": \"30\",\"serviceHalfM\": \"4\",\"serviceHalfY\": \"2022\",\"serviceM\": \"4\",\"serviceY\": \"2022\",\"startD\": \"13\",\"startM\": \"4\",\"startY\": \"2022\"}");
            PdfContentEditor editor = replaceText(ins ,json);
            editor.save(os);
            bytes = os.toByteArray();
        } catch (Exception e) {
            log.error("pdf渲染失败,templateUrl:{} ,参数：{}",templateUrl,JSON.toJSONString(vo),e);
            throw new RuntimeException("pdf渲染失败");
        } finally {
            if(ins != null) {
                try {
                    ins.close();
                } catch (IOException ignored) {
                }
            }
        }
        return bytes;
    }

    public static PdfContentEditor replaceText(InputStream ins,JSONObject json){
        Document pdfDocument = new Document(ins);
        PdfContentEditor editor = new PdfContentEditor(pdfDocument);
        TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("\\$\\{(.*?)\\}");
        TextSearchOptions textSearchOptions = new TextSearchOptions(true);
        textFragmentAbsorber.setTextSearchOptions(textSearchOptions);
        pdfDocument.getPages().accept(textFragmentAbsorber);
        TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
        for (TextFragment textFragment : (Iterable<TextFragment>) textFragmentCollection) {
            String keyStr = textFragment.getText();
            String key =  keyStr.substring(2,keyStr.length()-1);
            String value = getValue(keyStr,json.getString(key));
            while (editor.replaceText(keyStr,value));
        }
        return editor;
    }

    public static String getValue(String key,String value){
        if(value == null){
            return "";
        }
        int keyLength = key.length();
        if(keyLength > value.length()) {
            StringBuilder sb = new StringBuilder("");
            while (sb.length() < keyLength){
                sb.append(" ");
            }
            int start = (keyLength -value.length())/2;
            sb.replace(start,start+value.length(),value);
            return sb.toString();
        }
        return value;
    }
}
