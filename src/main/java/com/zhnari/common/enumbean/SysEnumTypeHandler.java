package com.zhnari.common.enumbean;

import com.zhnari.common.constant.SysConstant;
import org.apache.ibatis.type.MappedTypes;

/**
 * Description:
 *
 * @author cy
 * @date 2018年12月22日 16:53
 * version 1.0
 */
@MappedTypes(value = {SysConstant.SysUserStatus.class, SysConstant.SysUserType.class})
public class SysEnumTypeHandler<E extends Enum<E> & BaseEnum> extends BaseEnumTypeHandler<E> {
    /**
     * 设置配置文件设置的转换类以及枚举类内容，供其他方法更便捷高效的实现
     *
     * @param type 配置文件中设置的转换类
     */
    public SysEnumTypeHandler(Class<E> type) {
        super(type);
    }
}
