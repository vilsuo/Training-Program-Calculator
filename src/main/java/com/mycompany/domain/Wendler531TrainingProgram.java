
package com.mycompany.domain;

import com.mycompany.logic.PropertyManager;
import com.mycompany.logic.Utilities;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*
TODO
- if week < 4 and setNumber == 3, then max repetitions

*/

public class Wendler531TrainingProgram {
    
    private final String[] exercises = {"ohp", "deadlift", "bench", "squat"};
    private List<WorkoutBase> workouts;
    
    /**
     * training one rep max (TORM) is some percent of the actual one rep max.
     * 
     * @param ohpTORM
     * @param deadliftTORM
     * @param benchTORM
     * @param squatTORM
     */
    public Wendler531TrainingProgram(double ohpTORM, double deadliftTORM, double benchTORM, double squatTORM) {
        this.workouts = new ArrayList<>();
        
        double[] tORMS = {ohpTORM, deadliftTORM, benchTORM, squatTORM};
        
        try {
            Properties props = new PropertyManager().loadProperties();
            double accuracy = Double.valueOf(props.getProperty("weightAccuracy"));
            
            for (int week = 1; week <= 4; ++week) {
                for (int day = 1; day <= 4; ++day) {
                    double trainingOneRepMax = tORMS[day - 1];
                    String exerciseName = this.exercises[day - 1];
                    createPrimaryWorkoutBase(week, trainingOneRepMax, accuracy, exerciseName);
                }
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
     * @param trainingOneRepMax the base one rep max. The working weight is a
     *                          percentage of this one
     * @param exerciseName      the name of the exercise to be added
     */
    private void createPrimaryWorkoutBase(int week, double trainingOneRepMax, double accuracy, String exerciseName) {
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
        
        this.workouts.add(workout);
    }
    
    /**
     * @param week      integer in range [1, 4]
     * @param setNumber integer in range [1, 3]
     * 
     * @return          the percentage to take from training max
     */
    private int calculatePercentage(int week, int setNumber) {
        if (week < 4) {
            return 50 + 5 * week + 10 * setNumber;
        }
        
        // week == 4
        return 30 + 10 * setNumber;
    }
    
    /**
     * @param week      integer in range [1, 4]
     * @param setNumber integer in range [1, 3]
     * 
     * @return          number of repetitions of the given set in the given week
     */
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Wendler 5/3/1 program:\n");
        
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
