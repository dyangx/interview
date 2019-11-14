package com.example.vo;

import lombok.*;

import java.util.Date;

/**
 * @author: yangjie
 * @date: Created in 2019/10/18 14:55
 */
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
public class Usr {
    private Usr usr;

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
        Usr usr = new Usr(null,"111111","name_name",100,10,new Date(),new Date(),"123456789");
        return usr;
    }

}
