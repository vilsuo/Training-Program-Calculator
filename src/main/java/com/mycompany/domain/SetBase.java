
package com.mycompany.domain;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class SetBase {
    
    private SimpleIntegerProperty workingSets;
    private SimpleIntegerProperty repetitions;
    private SimpleDoubleProperty workingWeight;

    public SetBase(int workingSets, int repetitions, double workingWeight) {
        this.workingSets = new SimpleIntegerProperty(workingSets);
        this.repetitions = new SimpleIntegerProperty(repetitions);
        this.workingWeight = new SimpleDoubleProperty(workingWeight);
    }
    
    // remove this constructor?
    public SetBase() {
        this(0, 0, 0.0);
    }

    public int getWorkingSets() {
        return workingSets.get();
    }

    public int getRepetitions() {
        return this.repetitions.get();
    }

    public double getWorkingWeight() {
        return this.workingWeight.get();
    }
    
    @Override
    public String toString() {
        return this.workingSets.get() + "*" + this.repetitions.get() + " @" + this.workingWeight.get();
    }
    /*
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExerciseBase)) {
            return false;
        }
        ExerciseBase otherExerciseBase = (ExerciseBase) other;
        
        
        return (this.getWorkingSets() == otherExerciseBase.getWorkingSets())
            && (this.getRepetitions() == otherExerciseBase.getRepetitions())
            && (this.getWorkingWeight() == otherExerciseBase.getWorkingWeight());
    }
    */
}