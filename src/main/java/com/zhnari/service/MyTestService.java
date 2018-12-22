package com.zhnari.service;

import com.zhnari.bean.Permission;
import com.zhnari.dao.MyTestMapper;
import com.zhnari.dao.PermissionMapper;
import com.zhnari.entity.MyTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author cy
 * @date 2018年12月21日 16:54
 * version 1.0
 */
@Service
public class MyTestService {

    @Autowired
    MyTestMapper myTestMapper;


    /*查询所有的权限*/
    public List<MyTest> selectAllPermission(){
        return myTestMapper.query();
    }

}
