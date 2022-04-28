//package com.example.pdf;
//
//import com.deepoove.poi.XWPFTemplate;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.util.HashMap;
//
//public class Demo2 {
//
//    public static void main(String[] args) throws Exception {
//        XWPFTemplate template = XWPFTemplate.compile(new FileInputStream("C:\\Users\\ll18\\Desktop\\CRM\\temp\\合营入驻合同模板-demo.docx"));
//        template.render(
//                new HashMap<String, Object>(){{
//                    put("xx", "Hi, poi-tl Word模板引擎");
//                }});
//        template.writeAndClose(new FileOutputStream("C:\\Users\\ll18\\Desktop\\CRM\\temp\\合营入驻合同模板-demo2.docx"));
//    }
//}
