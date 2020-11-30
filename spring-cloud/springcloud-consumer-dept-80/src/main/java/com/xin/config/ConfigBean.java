package com.xin.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author com.xin
 * @create 2020-11-27 00:43:16
 */
@Configuration
public class ConfigBean {

    //IRule
    //AvailabilityFilteringRule : 会先过滤崩溃的，访问故障的服务。对剩下的进行轮询~
    //RandomRule随机
    //RetryRule ： 会先按照轮询获得服务~ 如果服务获取失败，则会在指定的时间内进行重试
    //RoundRobinRule轮询
    //配置负载均衡实现RestTemplate
    //因为RestTemplate没有Bean,所以需要手动配置
    @Bean
    @LoadBalanced  //Ribbon
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }

}
