package com.springcourse.springcoredemo.config;

import com.springcourse.springcoredemo.common.Coach;
import com.springcourse.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Custom Bean defined in this class.
 * It is used when we cant edit the source code for a class that we want to inject as a bean.
 * In real world app, it's generally the third party classes which are imported through packages.
 * */
@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
