package com.example.handler;

import com.alibaba.fastjson.JSON;
import com.example.annotation.SimpleCache;
import com.example.utils.StringUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Slf4j
@Aspect
@Component
public class SimpleCacheHandler {

    @Autowired
    StringRedisTemplate redisService;


    @Pointcut(value = "@annotation(com.example.annotation.SimpleCache)")
    private void aroundMethodAspect(){
    }

    @Around(value = "aroundMethodAspect()")
    public Object aroundMethod(ProceedingJoinPoint point) throws Throwable{
        // 方法签名
        MethodSignature ms = (MethodSignature) point.getSignature();
        Method method = ms.getMethod();
        SimpleCache simpleCache = method.getDeclaredAnnotation(SimpleCache.class);
        String key = getCachedName(simpleCache.name(),simpleCache.key(),method,point.getArgs());
        String json = redisService.opsForValue().get(key);
        if(StringUtil.isNotEmpty(json)) {
            return deSerialize(method,json);
        }
        Object proceed = point.proceed();
        if(proceed != null) {
            redisService.opsForValue().set(key,JSON.toJSONString(proceed),simpleCache.timeout(),simpleCache.unit());
        }
        return proceed;
    }

    private Object deSerialize(Method method,String value) throws JsonProcessingException {
        Type returnType = method.getGenericReturnType();
        Object object;
        if (returnType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) returnType;
            object = JSON.parseObject(value, type);
        } else {
            Class<?> returnTypeClass = method.getReturnType();
            object = JSON.parseObject(value, returnTypeClass);
        }
        return object;
    }

    /**
     * 生成存放redis的key
     */
    public static String getCachedName(String name,String key, Method method, Object[] args){
        // spel 解析
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(key,new TemplateParserContext());
        Parameter[] parameters = method.getParameters();
        EvaluationContext context = new StandardEvaluationContext();
        for(int i=0;i<parameters.length;i++){
            context.setVariable(parameters[i].getName(),args[i]);
        }
        String key_ = expression.getValue(context, String.class);
        if(StringUtil.isNotEmpty(key_)){
            return name + ":" +key_;
        }
        return name;
    }
}
