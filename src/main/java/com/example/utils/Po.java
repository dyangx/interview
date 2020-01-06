package com.example.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: yangjie
 * @date: Created in 2019/12/19 9:13
 */
@Data
public class Po implements Serializable {
    private static final long serialVersionUID=2L;
    private String id;
    private String name;
}
