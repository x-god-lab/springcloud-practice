package com.xin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author com.xin
 * @create 2020-11-27 00:58:58
 */

//Ribbon和Eureka整合后客户端可以直接调用，不不用关心IP地址和端口号
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.xin"})
public class DeptConsumer_Feign {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_Feign.class,args);
    }
}
