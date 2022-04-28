package com.example.util;

import lombok.Data;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FuncUtil {


    public static <T,K> void fillLabel1(T t, Function<T,K> supplier, Consumer<DataVO> consumer){
        DataVO v = new DataVO();
//        Optional<DataVO> dataVOOptional = Optional.of(v);
//        dataVOOptional.ifPresent(consumer);
        consumer.accept(v);
        consumer.accept(v);
        supplier.apply(t);
    }

    public static <T> void fillLabel2(T t, Consumer<T> set,Function<String,String> get ){
        set.accept(t);
        String s = get.apply("sssss");
    }

    public static <T> void ff(Function<DataVO,String> function) throws NoSuchMethodException {

        DataVO vo = new DataVO();
        vo.setCode("1");
        System.out.println(function.apply(vo));

//        Method method = function.getClass().getDeclaredMethod("writeReplace");

        System.out.println(function instanceof Proxy);
//        function.
    }



    public static void main(String[] args) throws NoSuchMethodException {
        ff(DataVO::getCode);





//        UpdateWrapper<DataVO> s = new UpdateWrapper<>();
//        Function<DataVO,?> consumer = p -> {
//            return null;
//        };
//        s.lambda().set(DataVO::getCode,"1");
//        s.gt()

    }

    @Data
    private static class DataVO {
        String code;
        String desc;
    }

}
