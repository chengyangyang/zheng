package com.zhnari.entity;

import com.zhnari.common.constant.MyTestToType;
import com.zhnari.common.constant.SysConstant;
import com.zhnari.common.enumbean.EnumStatus;

/**
 * Description:
 *
 * @author cy
 * @date 2018年12月22日 15:00
 * version 1.0
 */
public class MyTest {

    private Integer id;
    private String type;
    private String name;

    private SysConstant.SysUserStatus statusCustom; // 枚举属性，自定义枚举转换类

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SysConstant.SysUserStatus getStatusCustom() {
        return statusCustom;
    }

    public void setStatusCustom(SysConstant.SysUserStatus statusCustom) {
        this.statusCustom = statusCustom;
    }
}
