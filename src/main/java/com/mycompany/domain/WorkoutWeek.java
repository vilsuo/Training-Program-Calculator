
package com.mycompany.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WorkoutWeek {
    
    private List<WorkoutDay> workouts;

    public WorkoutWeek() {
        this.workouts = new ArrayList<>();
    }
    
    public void addWorkout(String day, WorkoutBase workoutBase) {
        // see if workout week already contains workout with given day
        Optional<WorkoutDay> workoutDayWithGivenDay = this.workouts.stream()
                .filter(workoutDay -> workoutDay.getDay().equals(day))
                .findFirst();
        
        if (workoutDayWithGivenDay.isPresent()) {
            workoutDayWithGivenDay.get().addWorkout(workoutBase);
            
        } else {
            this.workouts.add(new WorkoutDay(day, workoutBase));
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (WorkoutDay workoutDay : this.workouts) {
            sb.append(workoutDay);
        }
        
        return sb.toString();
    }
}
