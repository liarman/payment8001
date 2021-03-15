package com.qfant.myrule;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: chenghui
 * @Date: 2021/3/14 18:47
 */
@Configuration
public class MyRule {
    @Bean
    public RandomRule getRandomRule(){
        return new RandomRule();
    }
}
