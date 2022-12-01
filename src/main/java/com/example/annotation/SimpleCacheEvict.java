package com.example.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SimpleCacheEvict {

    String name();

    String key() default "";

    /**
     * db
     * @return
     */
    int db() default 0;
}
