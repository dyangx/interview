package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: yangjie
 * @date: Created in 2019/10/18 14:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usr {

    private String id;

    private String name;

    private Integer age;

    private Integer oder;
    private Date birth;
    private Date tbirth;
    private String phone;

    public Usr(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Usr crate(){
        Usr usr = new Usr("111111","name_name",100,10,new Date(),new Date(),"123456789");
        return usr;
    }

}
