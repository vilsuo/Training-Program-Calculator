
package com.mycompany.logic;

public final class Utilities {
    
    /**
     * @param   value       Value to round. Must be non-negative
     * @param   toNearest   Nearest increment the value argument to be rounded to.
     *                      Must be positive
     * 
     * @return              this.oneRepMax rounded to closest 2.5 increment
     */
    public static double getRounded(double value, double toNearest) {
        double rounded  = value - (value % toNearest);
        if (((value % toNearest) - toNearest / 2) >= 0) {
            rounded += toNearest;
        }
        return rounded;
    }
    
    public static boolean validateOneRepMaxInput(String input) {
        return input.matches("[0-9]{1,3}([,.][0-9]{0,3})?");
    }
}