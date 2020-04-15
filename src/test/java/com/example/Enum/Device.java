package com.example.Enum;

/**
 * @author: yangjie
 * @date: Created in 2020/3/11 16:03
 */
public enum Device {
    CST_CABINET("001","耗材柜"),
    VERIFICATION_AREA("005","核验区"),
    PASSAGEWAY_DOOR("008","通道门");

    private final String code;
    private final String name;

    Device(String code,String name){
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static Device getDevice(String name){
        if (name == null){
            return null;
        }
        if(name.contains(CST_CABINET.name)){
            return CST_CABINET;
        }else if (name.contains(VERIFICATION_AREA.name)){
            return VERIFICATION_AREA;
        }else if (name.contains(PASSAGEWAY_DOOR.name)){
            return PASSAGEWAY_DOOR;
        }else {
            return null;
        }
    }

}
class Test2{
    public static void main(String[] args) {
        System.out.println(Device.getDevice("通道门").getName());
    }
}
