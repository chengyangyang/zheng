package com.zhnari.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.zhnari.bean.Role;
import com.zhnari.bean.User;
import com.zhnari.bean.UserExample;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer uId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
 
    List<User> selectRoleByUserName(String name);
    List<User> selectUserPage(Integer pagestart,Integer rows);
    
}