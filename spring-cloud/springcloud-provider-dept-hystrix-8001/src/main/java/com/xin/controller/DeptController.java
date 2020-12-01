package com.xin.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xin.pojo.Dept;
import com.xin.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.MediaType;
/**
 * @author com.xin
 * @create 2020-11-26 18:43:20
 */

//提供restful服务
@RestController
public class DeptController {

    @Autowired
    private DeptServiceImpl service;


    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id")long id){
        Dept dept=service.queryById(id);
        if (dept==null){
            throw new RuntimeException("id=>"+id+",不存在该用户");
        }
        return dept;
    }

    public Dept hystrixGet(@PathVariable("id")long id){
        return new Dept().setDeptNo(id)
                .setDName("id=>"+id+",没有相关信息,null,@Hystrix")
                .setDb_source("no this database in Mysql");
    }

}
