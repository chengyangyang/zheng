package com.zhnari.common.constant;

/**
 * Description:
 *
 * @author cy
 * @date 2018年12月22日 16:15
 * version 1.0
 */
public class CodeEnumUtil {


    public static <E extends Enum<?> & BaseCodeEnum> E codeOf(Class<E> enumClass, int code) {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (e.getCode() == code)
                return e;
        }
        return null;
    }
}
