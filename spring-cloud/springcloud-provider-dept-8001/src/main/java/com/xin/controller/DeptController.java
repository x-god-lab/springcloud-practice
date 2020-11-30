package com.xin.controller;

import com.xin.pojo.Dept;
import com.xin.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author com.xin
 * @create 2020-11-26 18:43:20
 */

//提供restful服务
@RestController
public class DeptController {

    @Autowired
    private DeptServiceImpl service;

    @Autowired
    private DiscoveryClient client;


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

    //注册进来的微服务~获取一些信息
    @GetMapping("/dept/discovery")
    public Object disCover(){
        //获取微服务的清单
        List<String> services = client.getServices();
        System.out.println("discover=>service"+services);
        //得到一个具体的微服务信息,通过具体微服务id:applicationName
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance:instances){
            System.out.println(instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getServiceId()+"\t"+
                    instance.getUri());
        }
        return this.client;
    }
}
