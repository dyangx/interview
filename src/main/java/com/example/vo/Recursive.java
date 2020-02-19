package com.example.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: yangjie
 * @date: Created in 2019/12/5 16:07
 */
@Data
public class Recursive implements Serializable{

    private Integer id;
    private Integer pId;
    private Integer sId;
    private String name;

    List<Recursive> list;
}
