package com.nhtoan611.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Sedan implements Car{
    @Override
    public void control() {
        System.out.println("Control a sedan");
    }
}
