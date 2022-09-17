package com.example.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordCountStream {

    static List<String> element = new ArrayList<>(Arrays.asList("xx10","xx10","xx11"));

    public static void main(String[] args) throws Exception {
        addData();
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStreamSource<String> source = env.fromCollection(element);
//        SingleOutputStreamOperator<Tuple2<String, Integer>> data = source.flatMap((FlatMapFunction<String, Tuple2<String, Integer>>) (value, out) -> {
//            out.collect(Tuple2.of(value,1));
//        });
        SingleOutputStreamOperator<Tuple2<String, Integer>> data = source.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
                out.collect(Tuple2.of(value,1));
            }
        });
        SingleOutputStreamOperator<Tuple2<String, Integer>> result = data.keyBy(0).sum(1);
        result.print();
        env.execute("process going on");

    }

    public static void addData(){
        new Thread(() -> {
            int x = new Random().nextInt(9);
            element.add("xxx"+x+x);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
