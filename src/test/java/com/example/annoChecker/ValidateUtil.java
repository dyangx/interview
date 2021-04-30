package com.example.annoChecker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能描述:
 *
 * @Author: yang jie
 * @Date: 2021/4/30 13:54
 */
public final class ValidateUtil {

    /** 字母或者数字正则 */
    private static final String NUMBER_LETTER_REG = "^[a-z0-9A-Z]+$";
    /** 数字 */
    private static final String NUMBER_REG = "^[0-9]+$";
    /** 特殊字符 */
    private static final String SPECIAL_CHARACTER = ".*[`~!@#$^&*=|{}':;',\\[\\].<>/?~！@#￥……&*——|{_+}【】‘；：”“'。，、？]+.*";
    /** 电话号码正则  */
    private static final String REGEX_TEL = "^0\\d{2,3}[- ]?\\d{7,8}";
    /** 正则：身份证号码18位 */
    private static final String REGEX_ID_CARD18 = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9Xx])$";
    /**  正则：邮箱 */
    private static final String REGEX_EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    /**  正则：手机号（简单）  */
    private static final String REGEX_MOBILE_SIMPLE = "^[1]\\d{10}$";

    /**
     *  只包含字母或者数字
     */
    public static boolean onlyContainNumberOrLetter(String str){
        if(str == null){
            return true;
        }
        return str.matches(NUMBER_LETTER_REG);
    }

    /**
     *  只包含数字
     */
    public static boolean onlyContainNumber(String str){
        if(str == null){
            return true;
        }
        return str.matches(NUMBER_REG);
    }

    /**
     *  电话正则
     */
    public static boolean isPhoneNumer(String str){
        if(str == null){
            return true;
        }
        return Pattern.matches(REGEX_TEL, str) || Pattern.matches(REGEX_MOBILE_SIMPLE, str);
    }

    /**
     *  不包换特殊字符
     */
    public static boolean notContainSpecialCharacter(String str){
        if(str == null){
            return true;
        }
        Pattern p = Pattern.compile(SPECIAL_CHARACTER);
        Matcher m = p.matcher(str);
        return !m.matches();
    }

    public static boolean isEmail(String str){
        if(str == null){
            return true;
        }
        return Pattern.matches(REGEX_EMAIL, str);
    }

    public enum RegValidationEnum{
        NUMBER_OR_LETTER(ValidateUtil::onlyContainNumberOrLetter),
        NUMBER(ValidateUtil::onlyContainNumber),
        PHONE(ValidateUtil::isPhoneNumer),
        NOT_SPECIAL_CHARACTER(ValidateUtil::notContainSpecialCharacter),
        EMAIL(ValidateUtil::isEmail);

        private Function<String,Boolean> function;

        RegValidationEnum(Function<String, Boolean> function) {
            this.function = function;
        }
        public Function<String, Boolean> getFunction() {
            return function;
        }
    }

    public enum SelfValidationEnum{
        EMAIL(ValidateUtil::isEmail);

        private Function<String, Boolean> function;

        SelfValidationEnum(Function<String, Boolean> function) {
            this.function = function;
        }
        public Function<String, Boolean> getFunction() {
            return function;
        }
    }

    public static boolean pass(String value,RegValidationEnum validation){
        return validation.function.apply(value);
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {



        System.out.println(pass("asdfa``sdf234",RegValidationEnum.NUMBER_OR_LETTER));
    }
}
