
package com.mycompany.domain.bases;

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
        return "\t" + this.workingSets + "*" + this.repetitions + " @" + this.workingWeight;
    }
}