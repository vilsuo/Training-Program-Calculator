
package com.mycompany.domain;

import com.mycompany.logic.Utilities;
import java.util.ArrayList;
import java.util.List;

public class SmolovJrTrainingProgram {
    
    private final String exerciseName = "Squat";
    private List<WorkoutBase> workouts;
    
    public SmolovJrTrainingProgram(double oneRepMax, double increment) {
        this.workouts = new ArrayList<>();
        for (int week = 1; week <= 3; ++week) {
            for (int day = 1; day <= 4; ++day) {
                addWorkoutDay(week, day, oneRepMax, increment);
            }
        }
    }
    
    // day      1       2       3       4
    // week 1:  70%,    75%,    80%,    85% of one rep max
    // week 2: week 1 + increment
    // week 3: week 1 + 2 * increment
    private void addWorkoutDay(int week, int day, double oneRepMax, double increment) {
        double percentage = 0.70 + 0.05 * (day - 1);
        double extra = (week - 1) * increment;
        double workingWeight = Utilities.getRounded(percentage * oneRepMax + extra, increment);
        
        SetBase setBase = new SetBase(getNumberOfWorkingSets(day), getNumberOfRepetitions(day), workingWeight);
        ExerciseBase exerciseBase = new ExerciseBase(this.exerciseName, setBase);
        
        WorkoutBase workoutBase = new WorkoutBase();
        workoutBase.addExercise(exerciseBase);
        
        this.workouts.add(workoutBase);
    }
    
    // day:          1, 2, 3, 4,  5, 6, 7, 8,...
    // working sets: 6, 7, 8, 10, 6, 7, 8, 10,...
    private int getNumberOfWorkingSets(int day) {
        return 6 + ((day - 1) % 4) + ((day % 4 == 0) ? 1 : 0);
    }
    
    // day:         1, 2, 3, 4, 5, 6, 7, 8,...
    // repetitions: 6, 5, 4, 3, 6, 5, 4, 3,...
    private int getNumberOfRepetitions(int day) {
        return 6 - ((day - 1) % 4);
    }
    
    public List<WorkoutBase> getTrainingPlan() {
        return this.workouts;
    }

    @Override
    public String toString() {
        StringBuilder sb =  new StringBuilder("Smolov Jr program:\n");
        
        for (int i = 0; i < this.workouts.size(); ++i) {
            sb.append("Workout #" + (i + 1) + ":\n");
            sb.append(this.workouts.get(i));
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
}
