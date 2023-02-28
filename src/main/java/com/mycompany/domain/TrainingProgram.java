
package com.mycompany.domain;

import java.util.ArrayList;
import java.util.List;

public class TrainingProgram {
    
    private String programName;
    private List<WorkoutWeek> workouts;
    
    public TrainingProgram(String programName) {
        this.workouts = new ArrayList<>();
        this.programName = programName;
    }
    
    private WorkoutWeek getWorkoutWeek(int index) {
        return this.workouts.get(index);
    }
    
    public void addWorkoutWeek(WorkoutWeek workoutWeek) {
        this.workouts.add(workoutWeek);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.programName);
        sb.append(" program:\n");
        
        for (int i = 0; i < this.workouts.size(); ++i) {
            if (this.workouts.size() > 1) {
                sb.append("Week #");
                sb.append((i + 1));
                sb.append("\n");
            }
            sb.append(this.workouts.get(i));
            sb.append("\n");
        }
        
        return sb.toString();
    }
}
