package com.example.annoChecker;

import lombok.Data;

@Data
public class VO {

    @NotNullChecker(msg = "名字不能为空")
    private String name;

    private String id;

    @LengthChecker(msg = "desc",maxLength = 10,minLength = 5)
    private String desc;

    @RegExChecker(msg = "地址不能有特殊字符",type = ValidateUtil.RegValidationEnum.NOT_SPECIAL_CHARACTER)
    private String address;

    @NotNullChecker(msg = "电话不能空")
    @LengthChecker(msg = "电话",maxLength = 11,minLength = 5)
    @RegExChecker(msg = "电话格式不对啊啊啊啊啊啊",type = ValidateUtil.RegValidationEnum.PHONE)
    private String phone;

    @SelfRuleChecker(msg = "邮箱格式不对",type = ValidateUtil.SelfValidationEnum.EMAIL)
    private String email;

}
