package com.xin.service;

import com.xin.pojo.Dept;

import java.util.List;

/**
 * @author xin
 * @create 2020-11-26 18:40:58
 */
public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept queryById(long id);

    public List<Dept> queryAll();
}
