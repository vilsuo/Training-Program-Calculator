
package com.mycompany.domain.types;

public enum TrainingProgram {
    WENDLER_531("Wendler 5/3/1"),
    SMOLOV_JR("Smolov Jr");
    
    public final String label;
    
    private TrainingProgram(String label) {
        this.label = label;
    }
}