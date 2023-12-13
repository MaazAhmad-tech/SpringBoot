package com.springcourse.springcoredemo.common;


public class SwimCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Swim 1000m as a warmup!";
    }
}
