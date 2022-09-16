package com.example.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.FlatMapOperator;
import org.apache.flink.api.java.operators.UnsortedGrouping;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

public class WordCountBatch {

    public static void main(String[] args) throws Exception {
        // 1.获取flink 运行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        String input = "B:\\project\\interview\\src\\main\\resources\\file\\test.txt";
        String output = "C:\\Users\\ll18\\Desktop\\data";
        // 2.获取待分析的数据
        DataSource<String> lines = env.readTextFile(input);
        // 3.处理数据
        FlatMapOperator<String, Tuple2<String,Integer>> wordOne = lines.flatMap(new SplitFun());
        // 相同单词聚合在一起
        UnsortedGrouping<Tuple2<String,Integer>> grouping = wordOne.groupBy(0);
        // 将聚合在一起的数据累加处理
        DataSet<Tuple2<String,Integer>> dataSet = grouping.sum(1);
        dataSet.writeAsText(output);
        env.execute("program batch process");
    }

    static class SplitFun implements FlatMapFunction<String,Tuple2<String,Integer>> {
        @Override
        public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
            // 将文本拆散成单词
            String[] words = value.split(" ");
            for (String word: words) {
                Tuple2<String, Integer> tuple2 = new Tuple2<>(word,1);
                out.collect(tuple2);
            }
        }
    }
}
