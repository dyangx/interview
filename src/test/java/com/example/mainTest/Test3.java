package com.example.mainTest;

public class Test3 {

    public static void main(String[] args) {
        //反射方式执行
        /*Object object = SpringContextUtil.getBean(beanName);

        Method method = ReflectionUtils.findMethod(object.getClass(), methodName, argsClass);

        Object o = ReflectionUtils.invokeMethod(method, object, args);*/

        System.out.println(Test3.class.getName());

    }
}
