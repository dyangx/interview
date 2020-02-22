package com.example.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class TestYouVO implements Serializable {

    private static final long serialVersionUID=1L;

    private String serviceName;
    private String methodName;

    private List<Object> args;

    private List<String> argsType;
    
    public TestYouVO( String serviceName, String methodName) {
        this.serviceName = serviceName;
        this.methodName = methodName;
    }
}
