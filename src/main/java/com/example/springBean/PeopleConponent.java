package com.example.springBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PeopleConponent {

    @Autowired()
    private People people;

    @PostConstruct
    public void init(){
        System.out.println("PeopleConponent init.........");
        System.out.println(people);
    }

    public void getPeople(People people){
        System.out.println();
    }
}
