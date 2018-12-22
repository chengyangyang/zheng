package com.zhnari.common.enumbean;

import com.zhnari.common.constant.BaseCodeEnum;

/**
 * Description:
 *
 * @author cy
 * @date 2018年12月22日 16:12
 * version 1.0
 */
public enum ComputerState implements BaseCodeEnum {

    OPEN(10),         //开启
    CLOSE(11),         //关闭
    OFF_LINE(12),     //离线
    FAULT(200),     //故障
    UNKNOWN(255);     //未知

    private int code;
    ComputerState(int code) { this.code = code; }

    @Override
    public int getCode() { return this.code; }
}
