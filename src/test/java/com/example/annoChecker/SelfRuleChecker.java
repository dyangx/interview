package com.example.annoChecker;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 功能描述:  自定义规则校验
 *
 * @Author: yang jie
 * @Date: 2021/4/30 16:12
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SelfRuleChecker {

    /**
     *  错误提示
     */
    String msg();

    /**
     *  校验类型
     */
    ValidateUtil.SelfValidationEnum type();
}
