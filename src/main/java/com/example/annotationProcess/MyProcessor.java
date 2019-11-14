package com.example.annotationProcess;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Completion;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @author: yangjie
 * @date: Created in 2019/11/11 9:40
 */
public class MyProcessor extends AbstractProcessor {

    /**
     * 类似于处理器的main方法，可以用来实现扫描、处理注解、生成java文件
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return false;
    }

    @Override
    public Set<String> getSupportedOptions() {
        return super.getSupportedOptions();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return super.getSupportedAnnotationTypes();
    }

    /**  所有的注解处理器类都必须有一个无参构造函数,它会被注解处理工具调用
     */
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }

    @Override
    public Iterable<? extends Completion> getCompletions(Element element, AnnotationMirror annotation, ExecutableElement member, String userText) {
        return super.getCompletions(element, annotation, member, userText);
    }

    @Override
    protected synchronized boolean isInitialized() {
        return super.isInitialized();
    }
}
