package com.springcourse.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component

public class TennisCoach implements Coach{
    private TennisCoach() {
        System.out.println("In Constructor: " + TennisCoach.class.getSimpleName());
    }


    @Override
    public String getDailyWorkout() {
        return "Practice tennis for 30 mins!";
    }
}
