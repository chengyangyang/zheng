package com.zhnari.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author cy
 * @date 2018年12月22日 15:47
 * version 1.0
 */
public enum MyTestToType {
    nan("1","男"),
    nv("2","女");

    private String value;
    private String displayName;


    static Map<String,MyTestToType> enumMap=new HashMap<String, MyTestToType>();
    static{
        for(MyTestToType type:MyTestToType.values()){
            enumMap.put(type.getValue(), type);
        }
    }

    private MyTestToType(String value,String displayName) {
        this.value=value;
        this.displayName=displayName;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public static MyTestToType getEnum(String value) {
        return enumMap.get(value);
    }

}
