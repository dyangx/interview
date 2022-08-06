package com.example;

//import com.example.annotationProcess.FeignCC;
import feign.RequestLine;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@MapperScan("com.example.mapper")
@SpringBootApplication
@EnableAsync
//@FeignCC
//@EnableFeignClients

public class InterviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterviewApplication.class, args);
    }
}

