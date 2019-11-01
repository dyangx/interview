package com.example.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: yangjie
 * @date: Created in 2019/11/1 9:44
 */
@Data
public class Medical implements Serializable {

    private String suiteId;

    private Date updateTime;

    private Date createTime;

}
