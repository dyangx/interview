package com.example.annoChecker;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

/**
 * 功能描述:
 *
 * @Author: yang jie
 * @Date: 2021/4/30 10:40
 */
public class CheckHandler {

    public static <T> String check(T t){
        StringBuffer sb = new StringBuffer();
        Field[] fields = t.getClass().getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            String value = null;
            try {
                value = (String)field.get(t);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if(field.getDeclaredAnnotation(NotNullChecker.class) != null){
                NotNullChecker notNullChecker = field.getDeclaredAnnotation(NotNullChecker.class);
                if(StringUtils.isBlank(value)){
                    sb.append(notNullChecker.msg()).append("，");
                    continue;
                }
            }
            if(field.getDeclaredAnnotation(LengthChecker.class) != null){
                LengthChecker lengthChecker = field.getDeclaredAnnotation(LengthChecker.class);
                if(value != null){
                    if(lengthChecker.maxLength() != -1 && value.length() > lengthChecker.maxLength()){
                        sb.append(lengthChecker.msg()).append("长度不能超过").append(lengthChecker.maxLength()).append("，");
                        continue;
                    }else if(lengthChecker.minLength() != -1 && value.length() < lengthChecker.minLength()){
                        sb.append(lengthChecker.msg()).append("长度不能小于").append(lengthChecker.minLength()).append("，");
                        continue;
                    }
                }
            }
            if(field.getDeclaredAnnotation(RegExChecker.class) != null){
                RegExChecker regExChecker = field.getDeclaredAnnotation(RegExChecker.class);
                boolean b = regExChecker.type().getFunction().apply(value);
                if(!b){
                    sb.append(regExChecker.msg()).append("，");
                    continue;
                }
            }
            if(field.getDeclaredAnnotation(SelfRuleChecker.class) != null){
                SelfRuleChecker selfRuleChecker = field.getDeclaredAnnotation(SelfRuleChecker.class);
                boolean b = selfRuleChecker.type().getFunction().apply(value);
                if(!b){
                    sb.append(selfRuleChecker.msg()).append("，");
                }
            }
        }
        if(sb.length() != 0){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    public static <T> void replaceBlank(T t){
        Field[] fields = t.getClass().getDeclaredFields();
        try {
            for(Field field : fields){
                field.setAccessible(true);
                Object o = field.get(t);
                if(o instanceof String){
                    String value = o.toString().replaceAll(" ","");
                    value = value.length()==0?null:value;
                    field.set(t,value);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        VO vo = new VO();
        vo.setId("    ");
        vo.setName("1213");
        vo.setAddress("121j  ");
        vo.setPhone("  18080808l ");
        vo.setEmail("  18080808l@163.com ");
        replaceBlank(vo);
        String s = CheckHandler.check(vo);
        System.out.println(vo);
        System.out.println(s);
        boolean b = ValidateUtil.SelfValidationEnum.EMAIL.getFunction().apply("1832@163.com");
        System.out.println(b);
    }
}
