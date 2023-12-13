package com.springcourse.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class TennisCoach implements Coach{
    private TennisCoach() {
        System.out.println("In Constructor: " + TennisCoach.class.getSimpleName());
    }

    @PostConstruct
    private void doMyStartupStuff()
    {
        System.out.println("In doMyStartupStuff(): " + TennisCoach.class.getSimpleName());
    }

    @PreDestroy
    private void doMyCleanupStuff()
    {
        System.out.println("In doMyCleanupStuff(): " + TennisCoach.class.getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice tennis for 30 mins!";
    }
}
