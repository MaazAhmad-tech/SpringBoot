package com.springcourse.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{
    private FootballCoach() {
        System.out.println("In Constructor: "+ FootballCoach.class.getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Dribble for 30 mins!";
    }
}
