package com.example.handler;

import com.example.annotation.SimpleCacheEvict;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Collection;
import java.util.Set;

@Slf4j
@Aspect
@Component
public class SimpleCacheEvictHandler {

    @Autowired
    StringRedisTemplate redisService;


    @Pointcut(value = "@annotation(com.example.annotation.SimpleCacheEvict)")
    private void aroundMethodAspect(){
    }

    @Around(value = "aroundMethodAspect()")
    public Object aroundMethod(ProceedingJoinPoint point) throws Throwable{
        Object proceed = point.proceed();
        // 方法签名
        MethodSignature ms = (MethodSignature) point.getSignature();
        Method method = ms.getMethod();
        SimpleCacheEvict simpleCache = method.getDeclaredAnnotation(SimpleCacheEvict.class);
        String key = getCachedName(simpleCache.name(),simpleCache.key(),method,point.getArgs());
        Set<String> keys = redisService.keys(key);
        if(!CollectionUtils.isEmpty(keys)) {
            redisService.delete(keys);
        }
        return proceed;
    }

    /**
     * 生成存放redis的key
     */
    public String getCachedName(String name,String key, Method method, Object[] args){
        if(StringUtils.isEmpty(key)) {
            return name + "*";
        }
        // spel 解析
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();
        Expression expression = parser.parseExpression(key,new TemplateParserContext());
        Parameter[] parameters = method.getParameters();
        for(int i=0;i<parameters.length;i++){
            context.setVariable(parameters[i].getName(),args[i]);
        }
        String key_ = expression.getValue(context, String.class);
        if(!StringUtils.isEmpty(key_)){
            return name + ":" +key_;
        }
        return name;
    }
}
