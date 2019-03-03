package com.example.test;

import javax.servlet.http.HttpServletResponse;

public class AA extends BB{

    AA(int i) {
        super(i);
    }
}

class BB{
    BB(int i){
        System.out.println(1);
    }
    private BB(){
        System.out.println(3);
    }

    public void test(HttpServletResponse r){
        String s = r.encodeURL("");
        try {
            System.out.println(2);
        }finally {

        }

    }

    public static void main(String[] args) {
        BB b = new BB();
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
