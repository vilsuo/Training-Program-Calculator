
package com.mycompany.domain;

import java.util.ArrayList;
import java.util.List;

public class Wendler531TrainingProgram {
    
    private List<WorkoutBase> workouts;
    /*
    training one rep max (TR) = ~90% actual one rep max.
    the following are calculated from TR:
            week1   week2   week3   week4
    set1    65%x5   70%x3   75%x5   40%x5
    set2    75%x5   80%x3   85%x3   50%x5
    set3    85%x5+  90%x3+  95%x1+  60%x5
    
    week5 is week1, but with new TR:
        upper body TR += 2.5
        lower body TR += 5.0
    
    public Wendler531TrainingProgram(double oneRepMax, double increment) {
        this.workouts = new ArrayList<>();
        for (int week = 1; week <= 4; ++week) {
            for (int day = 1; day <= 4; ++day) {
                addWorkoutDay(week, day, oneRepMax, increment);
            }
        }
    }
    */
}
