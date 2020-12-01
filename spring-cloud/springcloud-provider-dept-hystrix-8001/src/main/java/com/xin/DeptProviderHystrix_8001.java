package com.xin;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableMBeanExport;

/**
 * @author com.xin
 * @create 2020-11-26 18:54:28
 */
@SpringBootApplication
@EnableEurekaClient //服务启动后自动注册到Eureka中
@EnableDiscoveryClient //服务发现
@EnableCircuitBreaker //开启对熔断的支持
public class DeptProviderHystrix_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix_8001.class,args);
    }
    //增加Servlet
    @Bean
    public ServletRegistrationBean hystrixMetricsStream(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        bean.addUrlMappings("/actuator/hystrix.stream");
        return bean;
    }
}
