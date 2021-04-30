package com.example.mainTest;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Test8 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.forEach(vo ->{});
        Func.action(Man::say);
        Func.action(vo ->{
            System.out.println("zzzzzzz");
        });
//        Func.supp(Man::run);
        ;
        System.out.println(Func.operator(Man::say));
    }
}

@SpringBootApplication
class Man{

    public static String say(String s){
        System.out.println(s);
        return s+s;
    }

    public static String run(){
        System.out.println("run ....");
        return "run";
    }
}

class Func{
    public static void action(Consumer<String> consumer){
        consumer.accept("sss");
    }

    public static void supp(Supplier<String> stringSupplier){
        String s = stringSupplier.get();
        System.out.println(s);
    }

    public static String operator(UnaryOperator<String> unaryOperator){
        return unaryOperator.apply("zz");
    }

//    public static String function(Function<>)
}
