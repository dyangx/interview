package com.example.annoChecker;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 功能描述:  长度检查
 *
 * @Author: yang jie
 * @Date: 2021/4/30 11:12
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LengthChecker {
    String msg();
    int maxLength() default -1;
    int minLength() default -1;

}
