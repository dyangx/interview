/*
package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.utils.AsposeUtil;
import com.example.utils.AsposeUtil2;
import com.example.utils.WebUtil;
import com.example.vo.Po;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import java.io.OutputStream;
import java.net.URLEncoder;

@RestController
@RequestMapping("/pdf")
public class PdfController {

    @RequestMapping("/get")
    public void get(HttpServletResponse response, Po po) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/pdf");
        response.setHeader("Content-Disposition",
                "attachment;filename=" + URLEncoder.encode("zzz.pdf", "UTF-8"));
        String url = po.getUrl();
        byte[] b = AsposeUtil.generatePDFRegex(url,new Object());
        OutputStream baseOs = response.getOutputStream();
        baseOs.write(b);
    }

    @RequestMapping("/get2")
    public void get2(HttpServletResponse response, Po po) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/pdf");
        response.setHeader("Content-Disposition",
                "attachment;filename=" + URLEncoder.encode("zzz.pdf", "UTF-8"));
        String url = po.getUrl();
        byte[] b = AsposeUtil2.generatePDFRegex(url,new Object());
        OutputStream baseOs = response.getOutputStream();
        baseOs.write(b);
    }






















}
*/
