package com.xin.controller;

import com.xin.pojo.Dept;
import com.xin.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xin
 * @create 2020-11-26 18:43:20
 */

//提供restful服务
@RestController
public class DeptController {

    @Autowired
    private DeptServiceImpl service;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return service.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") long id){
        return service.queryById(id);
    }
    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return service.queryAll();
    }
}
