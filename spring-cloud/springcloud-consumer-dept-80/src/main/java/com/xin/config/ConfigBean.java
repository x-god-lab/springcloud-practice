package com.xin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author xin
 * @create 2020-11-27 00:43:16
 */
@Configuration
public class ConfigBean {

    //因为RestTemplate没有Bean,所以需要手动配置
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
