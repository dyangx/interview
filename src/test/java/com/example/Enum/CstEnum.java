package com.example.Enum;

import com.example.vo.User;

/**
 * @author: yangj
 * @date: Created in 2020/8/10
 */
public enum CstEnum {

    AA(1,CstInterface.sayHell()),
    BB(2,CstInterface.sayHellB());

    private Integer a;
    private CstInterface cstInterface;

    CstEnum(Integer a,CstInterface cstInterface) {
        this.a = a;
        this.cstInterface = cstInterface;
    }

    public static CstEnum getCstEnum(Integer integer){
        for (CstEnum cstEnum : CstEnum.values()){
            if(cstEnum.a.equals(integer)){
                return cstEnum;
            }
        }
        return null;
    }

    public CstInterface getCstInterface() {
        return cstInterface;
    }

    public static void main(String[] args) {
        System.out.println(CstEnum.AA.name());
        CstEnum cstEnum = CstEnum.getCstEnum(1);
        assert cstEnum != null;
        cstEnum.getCstInterface().say();
    }
}
