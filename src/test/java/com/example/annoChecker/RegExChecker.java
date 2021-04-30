package com.example.annoChecker;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 功能描述: 正则校验
 *
 * @Author: yang jie
 * @Date: 2021/4/30 14:39
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RegExChecker {

    String msg();

    ValidateUtil.RegValidationEnum type();
}
