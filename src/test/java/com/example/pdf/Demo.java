/*
package com.example.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Demo {

    public static void fillTemplate(Map<String, Object> dataMap) {// 利用模板生成pdf
        // 模板路径
        String templatePath = dataMap.get("templatePath").toString();
        // 生成的新文件路径
        String newPDFPath = dataMap.get("newPDFPath").toString();
        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        try {
            out = new FileOutputStream(newPDFPath);// 输出流
            reader = new PdfReader(templatePath);// 读取pdf模板
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);

            // 创建字体显示中文
            BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            //查询出模板文件的表单域
            AcroFields form = stamper.getAcroFields();
            Iterator<String> it = form.getFields().keySet().iterator();
            while (it.hasNext()) {
                String name = it.next().toString();
                if(!"signature_confirm".equals(name)){
                    form.setFieldProperty("name","textfont",bfChinese,null);
                    form.setField(name, dataMap.get(name).toString());
                }else{

                }
            }
            // 如果为false那么生成的PDF文件还能编辑，一定要设为true
            stamper.setFormFlattening(true);
            stamper.close();
            // 1.创建一个ducument
            Document document = new Document();

            // 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中
            // 创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径
            */
/*PdfWriter writer = PdfWriter.getInstance(document, out);
            //PDF版本(默认1.4)
            writer.setPdfVersion(PdfWriter.PDF_VERSION_1_6);*//*


            // 3.打开文档-->写入数据之前要打开文档
            PdfCopy copy = new PdfCopy(document, out);
            document.open();
            // 设置属性
            // 标题
//            document.addTitle(dataMap.get("title").toString());
//            // 作者
//            document.addAuthor(dataMap.get("author").toString());
//            // 主题
//            document.addSubject(dataMap.get("subject").toString());
//            // 关键字
//            document.addKeywords(dataMap.get("keywords").toString());
            // 创建时间
            document.addCreationDate();
            // 应用程序
//            document.addCreator(dataMap.get("creator").toString());

            // 4.添加内容段落
            //获取pdf页数
            int pageNum = reader.getNumberOfPages();
            for (int i = 0; i < pageNum; i++) {
                PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), i+1);
                copy.addPage(importPage);
            }
            // 5.关闭文档
            document.close();

            bos.close();
            reader.close();
            reader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Map<String, Object> dataMap = new HashMap<>();
        //模板的地址和新pdf的存储地址
        dataMap.put("templatePath", "C:\\Users\\ll18\\Desktop\\CRM\\temp\\合营入驻合同模板.pdf");
        dataMap.put("newPDFPath", "C:\\Users\\ll18\\Desktop\\CRM\\temp\\合营入驻合同模板zz.pdf");
        dataMap.put("wwwxxx", "分期付款");
        //pdf文件属性
//        dataMap.put("title", "***分期付款");
//        dataMap.put("author", "*****网络科技有限公司");
//        dataMap.put("subject", "分期付款");
//        dataMap.put("keywords", "installment");
//        dataMap.put("creator", "*****网络科技有限公司");
//        //分期合同信息
//        dataMap.put("contract_number", "20170808162930123456");//合同编号
//        dataMap.put("order_number", "20170808120001520");//订单编号
//        dataMap.put("payer_name", "袁凌可");//分期支付人
//        dataMap.put("id_number", "460106198809126392");//身份证号
//        dataMap.put("contact_number", "18888888888");//联系电话
//        dataMap.put("merchant_name", "精品商店");//特约商户
//        dataMap.put("goods_type", "全世界独一无二iphone20");//商品种类
//        dataMap.put("installment_amount", "24000元");//分期总金额
//        dataMap.put("installment_number", "12");//分期期数
//        dataMap.put("installment_first_amount", "2000元");//首期支付金额
//        dataMap.put("installment_service charge", "1000元");//手续费
//        dataMap.put("installment_average_amount", "2000元");//剩余每期支付金额
//        dataMap.put("signature_confirm", true);//同意条款-该值已被忽略
//        dataMap.put("signature_time_year", "2017");//签名年
//        dataMap.put("signature_time_month", "8");//签名月
//        dataMap.put("signature_time_day", "8");//签名日
        fillTemplate(dataMap);
    }
}
*/
