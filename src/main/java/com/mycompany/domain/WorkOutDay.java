
package com.mycompany.domain;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class WorkOutDay {
    
    private final SimpleIntegerProperty workingSets;
    private final SimpleIntegerProperty repetitions;
    private final SimpleDoubleProperty workingWeight;

    public WorkOutDay(int workingSets, int repetitions, double workingWeight) {
        this.workingSets = new SimpleIntegerProperty(workingSets);
        this.repetitions = new SimpleIntegerProperty(repetitions);
        this.workingWeight = new SimpleDoubleProperty(workingWeight);
    }
    
    public int getWorkingSets() {
        return this.workingSets.get();
    }

    public int getRepetitions() {
        return this.repetitions.get();
    }

    public double getWorkingWeight() {
        return this.workingWeight.get();
    }
    
    @Override
    public String toString() {
        return this.workingSets + " * " + this.repetitions + " @" + this.workingWeight;
    }
}