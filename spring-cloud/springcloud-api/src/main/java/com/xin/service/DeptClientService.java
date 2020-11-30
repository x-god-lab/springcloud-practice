package com.xin.service;

import com.xin.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author com.xin
 * @create 2020-11-30 18:48:30
 */
@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")
public interface DeptClientService {

    @GetMapping("dept/list")
    public List<Dept> queryAll();
    @GetMapping("dept/get/{id}")
    public Dept queryId(long id);
    @GetMapping("dept/add")
    public boolean addDept(Dept dept);
}
