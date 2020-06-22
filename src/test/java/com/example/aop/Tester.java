package com.example.aop;

/**
 * @author: yangj
 * @date: Created in 2020/6/22
 */
public class Tester {

    public static void main(String[] args) {
        // jdk
        JDKProxy proxy = new JDKProxy(new TestServiceImpl());
        TestService service = (TestService) proxy.getInstance();
        service.say("李刚");
        //cglib
        TestService cgService  = (TestService) new CGLibProxy().getTarget(new TestServiceImpl());
        cgService.say("王刚");

    }
}
