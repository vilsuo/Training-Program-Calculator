
package com.mycompany.domain;

import com.mycompany.logic.Utilities;
import java.util.ArrayList;
import java.util.List;

public class TrainingPlan {

    private List<WorkOutDay> workOutDays;
    
    public TrainingPlan(double oneRepMax, double increment, int week) {
        this.workOutDays = new ArrayList<>();
        for (int day = 1; day <= 4; ++day) {
            addWorkOutDay(week, day, oneRepMax, increment);
        }
    }
    
    // day      1       2       3       4
    // week 1:  70%,    75%,    80%,    85% of one rep max
    // week 2: week 1 + increment
    // week 3: week 1 + 2 * increment
    private void addWorkOutDay(int week, int day, double oneRepMax, double increment) {
        double percentage = 0.70 + 0.05 * (day - 1);
        double extra = (week - 1) * increment;
        double workingWeight = Utilities.getRounded(percentage * oneRepMax + extra, increment);
        
        this.workOutDays.add(new WorkOutDay(getNumberOfWorkingSets(day), getNumberOfRepetitions(day), workingWeight));
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
    
    public List<WorkOutDay> getTrainingPlan() {
        return this.workOutDays;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Your training plan:\n");
        for (int i = 0; i < this.workOutDays.size(); ++i) {
            sb.append("Day ");
            sb.append(i + 1);
            sb.append(": ");
            sb.append(this.workOutDays.get(i).toString());
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }
}
