
package com.mycompany.domain;

import java.util.ArrayList;
import java.util.List;

public class WorkoutBase {
    
    private List<ExerciseBase> exercises;

    public WorkoutBase() {
        this.exercises = new ArrayList<>();
    }
    
    public void addExercise(ExerciseBase exercise) {
        this.exercises.add(exercise);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (ExerciseBase exerciseBase : this.exercises) {
            sb.append(exerciseBase);
        }
        
        return sb.toString();
    }
}
