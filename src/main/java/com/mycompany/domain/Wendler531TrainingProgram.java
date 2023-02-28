
package com.mycompany.domain;

import com.mycompany.logic.PropertyManager;
import com.mycompany.logic.Utilities;
import java.util.Properties;

/*
TODO
- if week < 4 and setNumber == 3, then max repetitions

*/

public class Wendler531TrainingProgram extends TrainingProgram {
    
    /**
     * training one rep max (TORM) is some percent of the actual one rep max.
     * 
     * @param ohpTORM       overhead press training one repetition maximum
     * @param deadliftTORM  deadlift training one repetition maximum
     * @param benchTORM     bench press training one repetition maximum
     * @param squatTORM     squat training one repetition maximum
     */
    public Wendler531TrainingProgram(double ohpTORM, double deadliftTORM, double benchTORM, double squatTORM) {
        super("Wendler 5/3/1");
        
        final String[] days = {"Monday", "Wednesday", "Friday", "Saturday"};
        final String[] exercises = {"overhead press", "deadlift", "bench press", "squat"};
        double[] tORMs = {ohpTORM, deadliftTORM, benchTORM, squatTORM};
        
        try {
            Properties props = new PropertyManager().loadProperties();
            double accuracy = Double.valueOf(props.getProperty("weightAccuracy"));
            
            for (int week = 1; week <= 4; ++week) {
                WorkoutWeek workoutWeek = new WorkoutWeek();
                
                for (int dayNumber = 1; dayNumber <= 4; ++dayNumber) {
                    String exerciseName = exercises[dayNumber - 1];
                    double trainingOneRepMax = tORMs[dayNumber - 1];
                    
                    WorkoutBase workoutBase = createPrimaryWorkoutBase(
                            week, exerciseName, trainingOneRepMax, accuracy);
                    
                    String day = days[dayNumber - 1];
                    workoutWeek.addWorkout(day, workoutBase);
                }
                
                super.addWorkoutWeek(workoutWeek);
            }
            
        } catch (Exception ex) {
            System.out.println("Error in creating 'Wendler 5/3/1' training program: " + ex.getMessage());
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
     * 
     * @param week              picks the percentage and the number of
     *                          repetitions from the above table
     * 
     * @param exerciseName      the name of the exercise to be added
     * 
     * @param trainingOneRepMax the base one rep max. The working weight is a
     *                          percentage of this one
     * 
     * @param accuracy          working weights will be rounded to the closest multiple of this value
     */
    private WorkoutBase createPrimaryWorkoutBase(int week, String exerciseName, double trainingOneRepMax, double accuracy) {
        ExerciseBase exercise = new ExerciseBase(exerciseName);
        
        for (int setNumber = 1; setNumber <= 3; ++setNumber) {
            int percentage = calculatePercentage(week, setNumber);
            int workingRepetitions = calculateNumberOfWorkingRepetitions(week, setNumber);
            double workingWeight = calculateWorkingWeight(percentage, trainingOneRepMax, accuracy);
            
            SetBase set = new SetBase(1, workingRepetitions, workingWeight);
            exercise.addSet(set);
        }
        
        WorkoutBase workout = new WorkoutBase();
        workout.addExercise(exercise);
        
        return workout;
    }
    
    private int calculatePercentage(int week, int setNumber) {
        if (week < 4) {
            return 50 + 5 * week + 10 * setNumber;
        }
        
        // week == 4
        return 30 + 10 * setNumber;
    }
    
    private int calculateNumberOfWorkingRepetitions(int week, int setNumber) {
        switch (week) {
            case 1:
                return 5;
            case 2:
                return 3;
            case 3:
                // new setNumber: 1, 2, 3
                // return value:  5, 3, 1
                return 7 - 2 * setNumber;
            default:
                // week == 4
                return 5;
        }
    }
    
    private double calculateWorkingWeight(double percentage, double trainingOneRepMax, double accuracy) {
        return Utilities.getRounded(percentage/100.0 * trainingOneRepMax, accuracy);
    }
}
