
package com.mycompany.domain;

import java.util.ArrayList;
import java.util.List;

public class WorkoutBase {
    
    private List<ExerciseBase> exercises;

    public WorkoutBase() {
        this.exercises = new ArrayList<>();
    }
    
    public void addExercise(ExerciseBase exerciseBase) {
        this.exercises.add(exerciseBase);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < this.exercises.size(); ++i) {
            sb.append("Exercise #" + (i + 1) + ": ");
            sb.append(this.exercises.get(i));
        }
        
        return sb.toString();
    }
}
