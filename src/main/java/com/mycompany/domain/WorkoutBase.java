
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
        for (int i = 0; i < this.exercises.size(); ++i) {
            if (this.exercises.size() > 1) {
                sb.append("Exercise #");
                sb.append(i + 1);
                sb.append(": ");
            }
            sb.append(this.exercises.get(i));
        }
        
        return sb.toString();
    }
}
