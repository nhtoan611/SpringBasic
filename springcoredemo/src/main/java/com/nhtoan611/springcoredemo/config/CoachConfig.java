package com.nhtoan611.springcoredemo.config;

import com.nhtoan611.springcoredemo.common.Coach;
import com.nhtoan611.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoachConfig {
    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
