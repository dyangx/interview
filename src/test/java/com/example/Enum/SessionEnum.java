package com.example.Enum;

public enum SessionEnum {

    SPRING(1),SUMMER(2),FALL(3),WINTER(4);

    SessionEnum(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;///////////
    }

    public void setValue(int value) {
        this.value = value;
    }
}
class Test {
    public static void main(String[] args) {
        System.out.println(SessionEnum.SPRING.getValue());
        SessionEnum s = SessionEnum.valueOf("SPRING");
        System.out.println(s.getValue());
    }
}