package com.example.springBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class PeopleConfiguration {

    @Bean("myPeople")
    public People getPeople(){
        return new People("1","张飞");
    }

}
