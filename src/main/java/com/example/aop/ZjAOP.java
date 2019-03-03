package com.example.aop;

import com.example.vo.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ZjAOP {

    /**
     *  Pointcut 定义切点
     *  execution 表示执行这个方法触发
     */
    @Pointcut("execution(* com.example.aop.service.impl.SuperMan.saveUser(..)) && args(user)")
    public void print(User user){
    }

    @Before("print(user)")
    public void before(User user){
        System.out.println("before ...");
    }

    @After("print(user)")
    public void after(User user){
        System.out.println("after ...");
    }

    @AfterReturning("print(user)")
    public void afterRuterning(User user){
        System.out.println("afterRuterning ...");
    }

    @AfterThrowing("print(user)")
    public void afterThrowing(User user){
        "123".substring(7);
        System.out.println("afterThrowing ...");

    }

//    @Around("(* com.example.aop.service.impl.SuperMan.saveUser(..)")
    public void around(ProceedingJoinPoint joinPoint){
        System.out.println("around before");
        System.out.println(joinPoint.getArgs());
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around after");
    }
}
