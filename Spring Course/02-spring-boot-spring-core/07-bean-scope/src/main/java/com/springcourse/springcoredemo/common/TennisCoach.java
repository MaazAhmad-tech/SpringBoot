package com.springcourse.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //by default the scope is Singleton which means same instance and prototype means different instance for each bean
public class TennisCoach implements Coach{
    private TennisCoach() {
        System.out.println("In Constructor: "+ TennisCoach.class.getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice tennis for 30 mins!";
    }
}
