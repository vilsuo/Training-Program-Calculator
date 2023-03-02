
package com.mycompany.domain.bases;

import com.mycompany.domain.types.TrainingProgram;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TrainingProgramBase implements Iterable {
    
    private TrainingProgram trainingProgramName;
    private List<WorkoutWeekBase> workouts;
    
    public TrainingProgramBase(TrainingProgram programName) {
        this.workouts = new ArrayList<>();
        this.trainingProgramName = programName;
    }
    
    public WorkoutWeekBase getWorkoutWeek(int index) {
        return this.workouts.get(index);
    }
    
    public void addWorkoutWeek(WorkoutWeekBase workoutWeek) {
        this.workouts.add(workoutWeek);
    }
    
    public int getNumberOfWeeks() {
        return this.workouts.size();
    }
    
    @Override
    public Iterator iterator() {
        return this.workouts.iterator();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.trainingProgramName.label);
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
