package com.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author com.xin
 * @create 2020-11-30 17:59:33
 */
@Configuration
public class Myrule {

    @Bean
    public IRule myRule(){
        return new MyRandomRule();
    }
}
