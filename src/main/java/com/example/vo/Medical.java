package com.example.vo;

import com.example.annotationProcess.CheckGetter;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: yangjie
 * @date: Created in 2019/11/1 9:44
 */
@CheckGetter
public class Medical implements Serializable {

    private String suiteId;

    private Date updateTime;

    private Date createTime;

}
