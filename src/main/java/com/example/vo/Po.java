package com.example.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: yangjie
 * @date: Created in 2019/12/19 9:12
 */
@Data
public class Po implements Serializable {
    private static final long serialVersionUID=1L;
    private String id;
    private String name;
    private String url;

}
