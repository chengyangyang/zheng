package com.zhnari.common.enumbean;

/**
 * Description:
 *
 * @author cy
 * @date 2018年12月22日 16:20
 * version 1.0
 */
public interface BaseEnum<E extends Enum<?>, T> {
    /**
     * 获取枚举的值
     * @return 枚举的值
     */
    T getValue();
}
