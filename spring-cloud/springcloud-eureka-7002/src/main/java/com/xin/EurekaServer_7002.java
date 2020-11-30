package com.xin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author com.xin
 * @create 2020-11-27 18:02:16
 */
//启动之后访问 http://localhost:7002/
@SpringBootApplication
@EnableEurekaServer  //EnableEurekaServer服务端的启动刘，可以接受别人注册进来
public class EurekaServer_7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7002.class,args);
    }
}
