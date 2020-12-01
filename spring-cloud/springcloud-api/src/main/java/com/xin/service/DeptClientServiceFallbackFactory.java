package com.xin.service;

import com.xin.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xin
 * @create 2020-12-01 16:15:35
 */

//降级
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public Dept queryId(long id) {
                return new Dept()
                        .setDeptNo(id)
                        .setDName("id=>"+id+"没有对应的信息，客户端提供了降级的信息，这个服务已经被关闭")
                        .setDb_source("这个服务已经被关闭");
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
