package com.example.annotationProcess;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 *  实体类getter检查
 */
@SupportedAnnotationTypes("CheckGetter")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class CheckGetterProcessor extends AbstractProcessor {
    /**
     *
     * @param annotations 处理的注解类型
     * @param roundEnv 当前生成的语法抽象树
     * @return
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement typeElement : ElementFilter.typesIn(roundEnv.getElementsAnnotatedWith(CheckGetter.class))){
            for (VariableElement field : ElementFilter.fieldsIn(typeElement.getEnclosedElements())){
                if(!containsGetter(typeElement,field.getSimpleName().toString())){
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                            String.format("getter not found for '%s.%s'",typeElement.getSimpleName(),field.getSimpleName()));
                }
            }
        }
        return true;
    }

    private static boolean containsGetter(TypeElement typeElement,String name){
        String getter = "get" + name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        for(ExecutableElement executableElement : ElementFilter.methodsIn(typeElement.getEnclosedElements())){
            if(!executableElement.getModifiers().contains(Modifier.STATIC) &&
                    executableElement.getSimpleName().toString().equals(getter) &&
                    executableElement.getParameters().isEmpty()){
                return true;
            }
        }
        return false;
    }

    /**
     * 用来存放注解处理器的初始化代码。之所以不用构造器，是因为在 Java 编译器中，注解处理器的实例是通过反射 API 生成的。
     * 也正是因为使用反射 API，每个注解处理器类都需要定义一个无参数构造器。
     * @param processingEnv
     */
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }
}
