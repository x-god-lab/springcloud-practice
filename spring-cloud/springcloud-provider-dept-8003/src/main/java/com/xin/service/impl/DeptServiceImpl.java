package com.xin.service.impl;

import com.xin.dao.DeptDao;
import com.xin.pojo.Dept;
import com.xin.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author com.xin
 * @create 2020-11-26 18:41:29
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao dao;
    @Override
    public boolean addDept(Dept dept) {
        return dao.addDept(dept);
    }

    @Override
    public Dept queryById(long id) {
        return dao.queryById(id);
    }

    @Override
    public List<Dept> queryAll() {
        return dao.queryAll();
    }
}
