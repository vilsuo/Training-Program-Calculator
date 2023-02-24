
package com.mycompany.domain;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

public class ExerciseBase {
    
    private SimpleStringProperty exerciseName;
    private List<SetBase> sets;

    public ExerciseBase(String exerciseName) {
        this.exerciseName = new SimpleStringProperty(exerciseName);
        this.sets = new ArrayList<>();
    }
    
    public ExerciseBase(String exerciseName, SetBase setBase) {
        this(exerciseName);
        addSet(setBase);
    }
    
    public void addSet(SetBase setBase) {
        this.sets.add(setBase);
    }

    public String getExerciseName() {
        return exerciseName.get();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.exerciseName.get());
        
        for (int i = 0; i < this.sets.size(); ++i) {
            sb.append("\n");
            sb.append(this.sets.get(i));
        }
        
        sb.append("\n");
        return sb.toString();
    }
    
    
}
