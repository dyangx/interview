package com.example.mybatis.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldVO {

    private String column;

    private String desc;

    private String type;

}
