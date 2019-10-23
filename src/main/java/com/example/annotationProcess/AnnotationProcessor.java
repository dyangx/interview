package com.example.annotationProcess;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @author: yangjie
 * @date: Created in 2019/10/23 14:35
 */
@SupportedAnnotationTypes(value = {"com.example.annotationProcess.Test"})
@SupportedSourceVersion(value = SourceVersion.RELEASE_8)
public class AnnotationProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("--------------- > Log in AnnotationProcessor.process <-------------------");
        for(TypeElement e : annotations){
            System.out.println(e);
            String annotation = null;
        }
        System.out.println(roundEnv);
        return true;
    }

}
