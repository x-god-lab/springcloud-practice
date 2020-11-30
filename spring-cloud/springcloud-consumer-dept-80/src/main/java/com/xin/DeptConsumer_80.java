package com.xin;

import com.myrule.Myrule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author xin
 * @create 2020-11-27 00:58:58
 */

//Ribbon和Eureka整合后客户端可以直接调用，不不用关心IP地址和端口号
@SpringBootApplication
@EnableEurekaClient
//在微服务自己启动的时候就能去加载我们自定义的Ribbon类
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = Myrule.class)
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class,args);
    }
}
