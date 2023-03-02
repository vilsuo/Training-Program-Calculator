
package com.mycompany.domain.bases;

import com.mycompany.domain.types.Day;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WorkoutWeekBase {
    
    private List<WorkoutDayBase> workouts;

    public WorkoutWeekBase() {
        this.workouts = new ArrayList<>();
    }
    
    public void addWorkout(Day day, WorkoutBase workoutBase) {
        // see if workout week already contains workout with given day
        Optional<WorkoutDayBase> workoutDayWithGivenDay = this.workouts.stream()
                .filter(workoutDay -> {
                    return workoutDay.getDay() == day;
                })
                .findFirst();
        
        if (workoutDayWithGivenDay.isPresent()) {
            workoutDayWithGivenDay.get().addWorkout(workoutBase);
            
        } else {
            this.workouts.add(new WorkoutDayBase(day, workoutBase));
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (WorkoutDayBase workoutDay : this.workouts) {
            sb.append(workoutDay);
        }
        
        return sb.toString();
    }
}
