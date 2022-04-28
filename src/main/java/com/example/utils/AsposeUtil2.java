package com.example.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.aspose.pdf.*;
import com.aspose.pdf.Color;
import com.aspose.pdf.Font;
import com.aspose.pdf.facades.PdfContentEditor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.awt.*;
import java.io.*;

@Slf4j
public class AsposeUtil2 {


    public static FileInputStream fileInputStream;

    public static Font font;

    static {
        try {
            fileInputStream = new FileInputStream("C:\\Windows\\Fonts\\simsun.ttc");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    /**
     *
     * @param templateUrl
     * @param vo
     * @return
     */
    public static byte[] generatePDFRegex(String templateUrl,Object vo) {
        // 验证License 若不验证则转化出的文档会有水印产生
//        Aspose
        Assert.isTrue(AsposeLicense.getPdfLicense(),"pdf工具授权失败 ！");
        InputStream ins = null;
        byte[] bytes = null;
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            ins = WebUtil.download(templateUrl);
            Document pdfDocument = new Document(ins);
            JSONObject json = JSON.parseObject(JSON.toJSONString(vo, SerializerFeature.WriteNullStringAsEmpty));
            replaceText(pdfDocument,json);
            pdfDocument.save(os);
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

    public static void replaceText(Document pdfDocument,JSONObject json){

//        FontMetrics

        TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("\\$\\{(.*?)\\}");
        TextSearchOptions textSearchOptions = new TextSearchOptions(true);
        textFragmentAbsorber.setTextSearchOptions(textSearchOptions);
        pdfDocument.getPages().accept(textFragmentAbsorber);
        TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
        for (TextFragment textFragment : (Iterable<TextFragment>) textFragmentCollection) {
            String key = textFragment.getText();
            key = key.substring(2,key.length()-1);
            String value = getValue(key,json.getString(key));
            textFragment.setText(value);
            font  = FontRepository.openFont(fileInputStream,0);
            textFragment.getTextState().setFont(font);
            textFragment.getTextState().setFontSize(12);
            textFragment.getTextState().setForegroundColor(Color.getBlack());
            textFragment.getTextState().setBackgroundColor(Color.getWhite());
        }
    }

    public static String getValue(String key,String value){
        if(value == null){
            return "";
        }
        if(key.length()+3 > value.length()) {
            StringBuilder sb = new StringBuilder(value);
            for(int i=0;i< key.length()+3 - value.length();i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        return value;
    }
}
