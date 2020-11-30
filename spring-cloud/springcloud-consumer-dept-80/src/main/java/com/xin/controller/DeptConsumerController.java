package com.xin.controller;

import com.xin.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author com.xin
 * @create 2020-11-27 00:33:59
 */
@RestController
public class DeptConsumerController {
    // 理解，消费者没有Services层
    //RestTemplate模板。。。。供我们直接调用！注册到spring中
    //(uri,实体：Map,Class<T> responseType)
    @Autowired
    private RestTemplate template;  //通过多种便携访问远程http服务的方法，简单的Restful服务模板

    //我们这里的地址应该是一个变量，通过服务名来访问
    //private static final String REST_URL_PREFIX="http://localhost:8001";
    private static final String REST_URL_PREFIX="http://SPRINGCLOUD-PROVIDER-DEPT";


    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return template.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> queryAll(){
        return template.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        return template.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

}
