package com.springcourse.springcoredemo.rest;

import com.springcourse.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;
    @Autowired
    private DemoController(@Qualifier("tennisCoach") Coach myCoach,
                           @Qualifier("tennisCoach") Coach anotherCoach) {

        System.out.println("In Constructor: " +DemoController.class.getSimpleName());
        this.myCoach = myCoach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout()
    {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String checkBean()
    {
        return "Comparing beans: anotherCoach == myCoach: " + (myCoach == anotherCoach);
    }
}
