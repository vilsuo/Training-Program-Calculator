
package com.mycompany.domain.bases;

import com.mycompany.domain.types.Exercise;
import java.util.ArrayList;
import java.util.List;

public class ExerciseBase {
    
    private Exercise exerciseName;
    private List<SetBase> sets;

    public ExerciseBase(Exercise exerciseName) {
        this.exerciseName = exerciseName;
        this.sets = new ArrayList<>();
    }
    
    public ExerciseBase(Exercise exerciseName, SetBase set) {
        this(exerciseName);
        addSet(set);
    }
    
    public void addSet(SetBase set) {
        this.sets.add(set);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.exerciseName.label);
        
        for (SetBase setBase : this.sets) {
            sb.append("\n");
            sb.append(setBase);
        }
        
        sb.append("\n");
        return sb.toString();
    }
    
    
}
