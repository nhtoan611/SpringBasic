package com.nhtoan611.springcoredemo.rest;

import com.nhtoan611.springcoredemo.common.Car;
import com.nhtoan611.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    private Car myFavCar;

    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach myCoach, Car myFavCar) {
        this.myCoach = myCoach;
        this.myFavCar = myFavCar;
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        myFavCar.control();
        return myCoach.getDailyWorkout();
    }
}
