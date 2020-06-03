package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fo implements Comparable<Fo>{

    private String name;
    private Integer age;

    public int compareTo() {
        return age;
    }

    @Override
    public int compareTo(Fo o) {
        return age;
    }
}
