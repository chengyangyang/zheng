package com.zhnari.common.enumbean;

/**
 * Description:
 *
 * @author cy
 * @date 2018年12月22日 15:52
 * version 1.0
 */
public enum EnumStatus {
    NORMAL(1, "正常"),
    DELETE(0, "删除"),
    CANCEL(2, "注销");

    private EnumStatus(int code, String description) {
        this.code = new Integer(code);
        this.description = description;
    }
    private Integer code;

    private String description;


    public Integer getCode() {

        return code;
    }


    public String getDescription() {

        return description;
    }
}