package com.example.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SimpleCache {

    /**
     * 缓存的名字
     */
    String name();

    /**
     * 缓存 key
     * spEL 表达式 eg: Hello, #{ #name },#{#user.name}
     */
    String key() default "";

    /**
     * 失效时间，
     */
    long timeout() default 5*60;

    /**
     * 单位
     * @return
     */
    TimeUnit unit() default TimeUnit.SECONDS;

    /**
     * db
     * @return
     */
    int db() default 0;

}
