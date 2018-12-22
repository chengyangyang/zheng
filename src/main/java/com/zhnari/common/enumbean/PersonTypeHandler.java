package com.zhnari.common.enumbean;

import com.zhnari.common.constant.Constant;
import com.zhnari.common.constant.MyTestToType;
import com.zhnari.entity.MyTest;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Description:枚举转化处理类
 *
 * @author cy
 * @date 2018年12月22日 15:34
 * version 1.0
 */
public class PersonTypeHandler extends BaseTypeHandler<MyTestToType> {

    private Class<MyTestToType> type;

    private  MyTestToType[] enums;





    /**
     * 设置配置文件设置的转换类以及枚举类内容，供其他方法更便捷高效的实现
     * @param type 配置文件中设置的转换类
     */
    public PersonTypeHandler(Class<MyTestToType> type) {
        if (type == null)
            throw new IllegalArgumentException("Type argument cannot be null");
        this.type = type;
        this.enums = type.getEnumConstants();
        if (this.enums == null)
            throw new IllegalArgumentException(type.getSimpleName()
                    + " does not represent an enum type.");
    }

    @Override
    public MyTestToType getNullableResult(ResultSet rs, String columnName) throws SQLException {
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型
        String i = rs.getString(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的value值，定位PersonType子类
            return MyTestToType.getEnum(i);
        }
    }

    @Override
    public MyTestToType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型
        String i = rs.getString(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的value值，定位PersonType子类
            return MyTestToType.getEnum(i);
        }
    }

    @Override
    public MyTestToType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型
        String i = cs.getString(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的value值，定位PersonType子类
            return MyTestToType.getEnum(i);
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, MyTestToType parameter, JdbcType jdbcType)
            throws SQLException {
        // baseTypeHandler已经帮我们做了parameter的null判断
        ps.setString(i, parameter.getValue());

    }


}
