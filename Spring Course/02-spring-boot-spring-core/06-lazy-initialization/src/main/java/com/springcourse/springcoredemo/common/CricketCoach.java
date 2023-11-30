package com.springcourse.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//@Component marks the class as a Spring bean and it is ready to be injected
@Component
public class CricketCoach implements Coach{

    private CricketCoach() {
        System.out.println("In Constructor: "+ CricketCoach.class.getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 mins :)";
    }
}
