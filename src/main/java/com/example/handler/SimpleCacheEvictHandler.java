//package com.example.handler;
//
//import com.lianlian.common.redis.service.RedisService;
//import com.lianlian.talent.tools.annotation.SimpleCacheEvict;
//import com.lianlian.talent.tools.utils.DynamicRedisUtil;
//import com.lianlian.talent.tools.utils.StringUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.expression.EvaluationContext;
//import org.springframework.expression.Expression;
//import org.springframework.expression.ExpressionParser;
//import org.springframework.expression.common.TemplateParserContext;
//import org.springframework.expression.spel.standard.SpelExpressionParser;
//import org.springframework.expression.spel.support.StandardEvaluationContext;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Method;
//import java.lang.reflect.Parameter;
//import java.util.Set;
//
//@Slf4j
//@Aspect
//@Component
//public class SimpleCacheEvictHandler {
//
//
//    @Pointcut(value = "@annotation(com.lianlian.talent.tools.annotation.SimpleCacheEvict)")
//    private void aroundMethodAspect(){
//    }
//
//    @Around(value = "aroundMethodAspect()")
//    public Object aroundMethod(ProceedingJoinPoint point) throws Throwable{
//        Object proceed = point.proceed();
//        // 方法签名
//        MethodSignature ms = (MethodSignature) point.getSignature();
//        Method method = ms.getMethod();
//        SimpleCacheEvict simpleCache = method.getDeclaredAnnotation(SimpleCacheEvict.class);
//        RedisService redisService = DynamicRedisUtil.getRedisService(simpleCache.redis(),simpleCache.db());
//        String key = getCachedName(simpleCache.name(),simpleCache.key(),method,point.getArgs());
//        Set<String> keys = redisService.keys(key + "*");
//        redisService.delete(keys);
//        return proceed;
//    }
//
//    /**
//     * 生成存放redis的key
//     */
//    public String getCachedName(String name,String key, Method method, Object[] args){
//        // spel 解析
//        ExpressionParser parser = new SpelExpressionParser();
//        EvaluationContext context = new StandardEvaluationContext();
//        Expression expression = parser.parseExpression(key,new TemplateParserContext());
//        Parameter[] parameters = method.getParameters();
//        for(int i=0;i<parameters.length;i++){
//            context.setVariable(parameters[i].getName(),args[i]);
//        }
//        String key_ = expression.getValue(context, String.class);
//        if(StringUtils.isNotEmptyAll(key_)){
//            return name + ":" +key_;
//        }
//        return name;
//    }
//}
