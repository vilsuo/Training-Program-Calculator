
package com.mycompany.domain;

public class SetBase {
    
    private int workingSets;
    private int repetitions;
    private double workingWeight;

    public SetBase(int workingSets, int repetitions, double workingWeight) {
        this.workingSets = workingSets;
        this.repetitions = repetitions;
        this.workingWeight = workingWeight;
    }
    
    public SetBase() {
        this(0, 0, 0.0);
    }
    
    @Override
    public String toString() {
        return this.workingSets + "*" + this.repetitions + " @" + this.workingWeight;
    }
}