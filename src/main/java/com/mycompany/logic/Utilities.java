
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
    
    public static double getInputDoubleValue(String input) {
        return Double.valueOf(input.replace(",", "."));
    }
    
    /*
    /**
     * DECREASING DOES NOT WORK CURRENTLY
     * generates a integer cyclic sequence 
     * 
     * (start, start + 1,... , end - 1, end, start, start + 1, ...), if start < end
     * (start, start - 1,... , end + 1, end, start, start - 1, ...), if start > end
     * 
     * 
     * @param integer
     * 
     * @param start
     * @param end
     * @return 
    public static int getNextIntegerInTheCycle(int integer, int start, int end) {
        if (start == end) {
            return end;
        }
        
        // increasing sequence
        if (start < end) {
            if (start <= integer && integer <= end) {
                return integer;
            }
            
            // shift so that (start > 0), it follows that (end != 0)
            int shift = 0;
            if (start < 1) {
                shift = -1 * start + 1;
                
                integer += shift;
                start += shift;
                end += shift;
            }
            // increase integer value so that (integer > end)
            // so the final result is not affected
            if (integer < start) {
                int n = (end - integer)/(end - start + 1) + 1;
                integer += n * (end - start + 1);
            }
            // calculate value with the shift and then remove the shift
            return start + ((integer - 1) % end) - shift;
            
        // decreasing sequence
        } else {
            if (start >= integer && integer >= end) {
                return integer;
            }
            
            return 0;
            //return end + ((integer - 1) % start);
                    
        }
    }
    */
}