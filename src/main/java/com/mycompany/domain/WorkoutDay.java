
package com.mycompany.domain;

import java.util.ArrayList;
import java.util.List;

public class WorkoutDay {
    
    private String day;
    private List<WorkoutBase> workouts;
    
    public WorkoutDay(String day) {
        this.day = day;
        this.workouts = new ArrayList<>();
    }

    public WorkoutDay(String day, WorkoutBase workout) {
        this(day);
        addWorkout(workout);
    }
    
    public void addWorkout(WorkoutBase workout) {
        this.workouts.add(workout);
    }

    public String getDay() {
        return this.day;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.day);
        sb.append(":\n");
        for (int i = 0; i < this.workouts.size(); ++i) {
            if (this.workouts.size() > 1) {
                sb.append("Workout #");
                sb.append(i + 1);
                sb.append(":\n");
            }
            sb.append(this.workouts.get(i));
        }
        
        return sb.toString();
    }
    
    
}
