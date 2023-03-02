
package com.mycompany.domain.bases;

import com.mycompany.domain.types.Day;
import java.util.ArrayList;
import java.util.List;

public class WorkoutDayBase {
    
    private Day day;
    private List<WorkoutBase> workouts;
    
    public WorkoutDayBase(Day day) {
        this.day = day;
        this.workouts = new ArrayList<>();
    }

    public WorkoutDayBase(Day day, WorkoutBase workout) {
        this(day);
        addWorkout(workout);
    }
    
    public void addWorkout(WorkoutBase workout) {
        this.workouts.add(workout);
    }

    public Day getDay() {
        return this.day;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.day.label);
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
