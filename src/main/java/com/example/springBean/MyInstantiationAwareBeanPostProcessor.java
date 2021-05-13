package com.example.springBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    public MyInstantiationAwareBeanPostProcessor(){
        super();
        System.out.println("MyInstantiationAwareBeanPostProcessor 实例化 ");
    }

    /**
     * 接口方法、实例化Bean之前调用
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("接口方法、实例化Bean之前调用");
        return super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    /**
     * 接口方法、实例化Bean之后调用
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("接口方法、实例化Bean之后调用");
        return super.postProcessAfterInstantiation(bean, beanName);
    }

    /**
     *  接口方法、设置某个属性时调用
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        System.out.println("接口方法、设置某个属性时调用");
        return super.postProcessProperties(pvs, bean, beanName);
    }


}
