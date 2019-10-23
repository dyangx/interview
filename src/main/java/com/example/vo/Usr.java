package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author: yangjie
 * @date: Created in 2019/10/18 14:55
 */
@Data
@AllArgsConstructor
public class Usr {

    private String id;

    private String name;

    private Integer age;

    private Integer oder;
    private Date birth;
    private Date tbirth;
    private String phone;

}
