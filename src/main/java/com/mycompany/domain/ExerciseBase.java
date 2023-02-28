
package com.mycompany.domain;

import java.util.ArrayList;
import java.util.List;

public class ExerciseBase {
    
    private String exerciseName;
    private List<SetBase> sets;

    public ExerciseBase(String exerciseName) {
        this.exerciseName = exerciseName;
        this.sets = new ArrayList<>();
    }
    
    public ExerciseBase(String exerciseName, SetBase set) {
        this(exerciseName);
        addSet(set);
    }
    
    public void addSet(SetBase set) {
        this.sets.add(set);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.exerciseName);
        
        for (int i = 0; i < this.sets.size(); ++i) {
            sb.append("\n");
            sb.append(this.sets.get(i));
        }
        
        sb.append("\n");
        return sb.toString();
    }
    
    
}
