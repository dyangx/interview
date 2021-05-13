package com.example.annoChecker;

import java.lang.annotation.Annotation;

/**
 * 功能描述:
 *
 * @Author: yang jie
 * @Date: 2021/5/7 10:08
 */
public @interface Check {

    LengthChecker lengthChecker() default @LengthChecker(msg = "zz");
    NotNullChecker notNull();

}
