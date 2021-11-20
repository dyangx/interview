package com.example.util;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.resource.StringTemplateResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class BeetlUtil {
    private static Logger logger = LoggerFactory.getLogger(BeetlUtil.class);
    private static String templatePath = "templates/";
    private static GroupTemplate gt;

    private static void init() {
        try {
            ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader(templatePath);
            Configuration cfg = Configuration.defaultConfiguration();
            gt = new GroupTemplate(resourceLoader, cfg);
        } catch (IOException e) {
            logger.error("加载beetl模板失败，请检查模板路径是否正确：" + templatePath, e);
        }
    }

    public static Template template(String name) {
        if (gt == null) {
            init();
        }
        return gt.getTemplate(name);
    }

    public static void main(String[] args) throws IOException {
        StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("hello,${name}");
        t.binding("name", "dyangxxxxx");
        String str = t.render();
        System.out.println(str);
    }
}
