package com.zhnari.controller;

import com.zhnari.entity.MyTest;
import com.zhnari.service.MyTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 *
 * @author cy
 * @date 2018年12月21日 16:53
 * version 1.0
 */
@RestController
@RequestMapping("/mytest")
public class MyTestController {

    @Autowired
    MyTestService myTestService;


    @GetMapping("/findMyTest")
    public List<MyTest> findMyTest(){
        return myTestService.selectAllPermission();
    }


}
