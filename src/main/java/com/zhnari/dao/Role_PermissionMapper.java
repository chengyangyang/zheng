package com.zhnari.dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.zhnari.bean.Role_Permission;
import com.zhnari.bean.Role_PermissionExample;

public interface Role_PermissionMapper {
    long countByExample(Role_PermissionExample example);

    int deleteByExample(Role_PermissionExample example);

    int deleteByPrimaryKey(Integer rPId);

    int insert(Role_Permission record);

    int insertSelective(Role_Permission record);

    List<Role_Permission> selectByExample(Role_PermissionExample example);

    Role_Permission selectByPrimaryKey(Integer rPId);

    int updateByExampleSelective(@Param("record") Role_Permission record, @Param("example") Role_PermissionExample example);

    int updateByExample(@Param("record") Role_Permission record, @Param("example") Role_PermissionExample example);

    int updateByPrimaryKeySelective(Role_Permission record);

    int updateByPrimaryKey(Role_Permission record);
}