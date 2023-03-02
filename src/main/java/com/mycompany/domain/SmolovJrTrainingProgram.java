
package com.mycompany.domain;

import com.mycompany.domain.bases.TrainingProgramBase;
import com.mycompany.domain.bases.WorkoutWeekBase;
import com.mycompany.domain.bases.WorkoutBase;
import com.mycompany.domain.bases.ExerciseBase;
import com.mycompany.domain.bases.SetBase;
import com.mycompany.domain.types.Day;
import com.mycompany.domain.types.TrainingProgram;
import com.mycompany.domain.types.Exercise;
import com.mycompany.logic.PropertyManager;
import com.mycompany.logic.Utilities;
import java.util.Properties;

public class SmolovJrTrainingProgram extends TrainingProgramBase {
    
    private Exercise exerciseName;
    
    public SmolovJrTrainingProgram(Exercise exerciseName, double oneRepMax, double increment) {
        super(TrainingProgram.SMOLOV_JR);
        this.exerciseName = exerciseName;
        
        final Day[] days = {Day.MONDAY, Day.WEDNESDAY, Day.FRIDAY, Day.SATURDAY};
        
        try {
            Properties props = new PropertyManager().loadProperties();
            double accuracy = Double.valueOf(props.getProperty("weightAccuracy"));
            
            for (int weekNumber = 1; weekNumber <= 3; ++weekNumber) {
                WorkoutWeekBase workoutWeek = new WorkoutWeekBase();
                 
                for (int dayNumber = 1; dayNumber <= 4; ++dayNumber) {
                    WorkoutBase workoutBase = createPrimaryWorkoutBase(
                            weekNumber, dayNumber, oneRepMax, increment, accuracy);
                    
                    Day day = days[dayNumber - 1];
                    workoutWeek.addWorkout(day, workoutBase);
                }
                
                super.addWorkoutWeek(workoutWeek);
            }
            
        } catch (Exception ex) {
            System.out.println("Error in creating 'Smolov Jr' training program: " + ex.getMessage());
        }
    }
    /**
     *  Adds a workout containing one exercise with three sets
     *  the following are calculated from TR:
     * 
     *          week 1  week 2  week 3  week 4
     *  set 1   65%x5   70%x3   75%x5   40%x5
     *  set 2   75%x5   80%x3   85%x3   50%x5
     *  set 3   85%x5+  90%x3+  95%x1+  60%x5
     */
    // day      1       2       3       4
    // week 1:  70%,    75%,    80%,    85% of one rep max
    // week 2: week 1 + increment
    // week 3: week 1 + 2 * increment
    private WorkoutBase createPrimaryWorkoutBase(int weekNumber, int dayNumber, double oneRepMax, double increment, double accuracy) {
        int workingSets = calculateNumberOfWorkingSets(dayNumber);
        int workingRepetitions = calculateNumberOfWorkingRepetitions(dayNumber);
        
        double percentage = calculatePercentage(dayNumber);
        double extra = (weekNumber - 1) * increment;
        double workingWeight = calculateWorkingWeight(percentage, oneRepMax, extra, accuracy);
        
        SetBase setBase = new SetBase(workingSets, workingRepetitions, workingWeight);
        ExerciseBase exerciseBase = new ExerciseBase(this.exerciseName, setBase);
        
        WorkoutBase workoutBase = new WorkoutBase();
        workoutBase.addExercise(exerciseBase);
        
        return workoutBase;
    }
    
    private int calculatePercentage(int dayNumber ){
        return 70 + 5 * (dayNumber - 1);
    }
    
    // day:          1, 2, 3, 4,  5, 6, 7, 8,...
    // working sets: 6, 7, 8, 10, 6, 7, 8, 10,...
    private int calculateNumberOfWorkingSets(int dayNumber) {
        return 6 + ((dayNumber - 1) % 4) + ((dayNumber % 4 == 0) ? 1 : 0);
    }
    
    // day:         1, 2, 3, 4, 5, 6, 7, 8,...
    // repetitions: 6, 5, 4, 3, 6, 5, 4, 3,...
    private int calculateNumberOfWorkingRepetitions(int dayNumber) {
        return 6 - ((dayNumber - 1) % 4);
    }
    
    private double calculateWorkingWeight(double percentage, double oneRepMax, double extra, double accuracy) {
        return Utilities.getRounded(percentage/100.0 * oneRepMax + extra, accuracy);
    }
}
