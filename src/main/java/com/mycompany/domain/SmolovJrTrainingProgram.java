
package com.mycompany.domain;

import com.mycompany.logic.PropertyManager;
import com.mycompany.logic.Utilities;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SmolovJrTrainingProgram {
    
    private String exerciseName;
    private List<WorkoutBase> workouts;
    
    public SmolovJrTrainingProgram(String exerciseName, double oneRepMax, double increment) {
        this.exerciseName = exerciseName;
        this.workouts = new ArrayList<>();
        
        try {
            Properties props = new PropertyManager().loadProperties();
            double accuracy = Double.valueOf(props.getProperty("weightAccuracy"));
            
            for (int week = 1; week <= 3; ++week) {
                for (int day = 1; day <= 4; ++day) {
                    createPrimaryWorkoutBase(week, day, oneRepMax, increment, accuracy);
                }
            }
            
        } catch (Exception ex) {
            System.out.println("Error in creating 'Smolov Jr' training program: " + ex.getMessage());
        }
    }
    
    // day      1       2       3       4
    // week 1:  70%,    75%,    80%,    85% of one rep max
    // week 2: week 1 + increment
    // week 3: week 1 + 2 * increment
    private void createPrimaryWorkoutBase(int week, int day, double oneRepMax, double increment, double accuracy) {
        int workingSets = calculateNumberOfWorkingSets(day);
        int workingRepetitions = calculateNumberOfWorkingRepetitions(day);
        
        double percentage = 70 + 5 * (day - 1);
        double extra = (week - 1) * increment;
        double workingWeight = calculateWorkingWeight(percentage, oneRepMax, extra, accuracy);
        
        SetBase setBase = new SetBase(workingSets, workingRepetitions, workingWeight);
        ExerciseBase exerciseBase = new ExerciseBase(this.exerciseName, setBase);
        
        WorkoutBase workoutBase = new WorkoutBase();
        workoutBase.addExercise(exerciseBase);
        
        this.workouts.add(workoutBase);
    }
    
    // day:          1, 2, 3, 4,  5, 6, 7, 8,...
    // working sets: 6, 7, 8, 10, 6, 7, 8, 10,...
    private int calculateNumberOfWorkingSets(int day) {
        return 6 + ((day - 1) % 4) + ((day % 4 == 0) ? 1 : 0);
    }
    
    // day:         1, 2, 3, 4, 5, 6, 7, 8,...
    // repetitions: 6, 5, 4, 3, 6, 5, 4, 3,...
    private int calculateNumberOfWorkingRepetitions(int day) {
        return 6 - ((day - 1) % 4);
    }
    
    private double calculateWorkingWeight(double percentage, double oneRepMax, double extra, double accuracy) {
        return Utilities.getRounded(percentage/100.0 * oneRepMax + extra, accuracy);
    }

    @Override
    public String toString() {
        StringBuilder sb =  new StringBuilder("Smolov Jr program:\n");
        
        for (int i = 0; i < this.workouts.size(); ++i) {
            sb.append("Workout #");
            sb.append(i + 1);
            sb.append(":\n");
            sb.append(this.workouts.get(i));
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
}
