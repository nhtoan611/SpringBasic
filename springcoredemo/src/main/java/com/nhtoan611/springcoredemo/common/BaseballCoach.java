package com.nhtoan611.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach  implements  Coach{
    @Override
    public String getDailyWorkout() {
        return "Baseball coach here";
    }
}
