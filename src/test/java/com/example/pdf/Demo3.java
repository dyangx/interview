package com.example.pdf;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.*;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class Demo3 {

    public static final String DEST = "C:\\Users\\ll18\\Desktop\\CRM\\temp\\1\\temp7.pdf";
    public static final String SRC = "C:\\Users\\ll18\\Desktop\\CRM\\temp\\合营入驻合同模板.pdf";

    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new Demo3().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(SRC), new PdfWriter(dest));
        PdfPage page = pdfDoc.getFirstPage();
        PdfDictionary dict = page.getPdfObject();

        PdfObject object = dict.get(PdfName.Contents);
        if (object instanceof PdfStream) {
            PdfStream stream = (PdfStream) object;
            byte[] data = stream.getBytes();
            String replacedData = new String(data).replace("ssss", "wwwxxx");
            stream.setData(replacedData.getBytes(StandardCharsets.UTF_8));
        }

        pdfDoc.close();
    }
}
