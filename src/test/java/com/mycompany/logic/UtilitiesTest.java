
package com.mycompany.logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UtilitiesTest {
    
    @Test
    public void getRoundedTest() {
        assertEquals(5.0, Utilities.getRounded(5.0, 1.0));
        assertEquals(5.0, Utilities.getRounded(5.0, 1.25));
        assertEquals(5.0, Utilities.getRounded(5.0, 2.5));
        assertEquals(5.0, Utilities.getRounded(5.0, 5.0));
        
        assertEquals(0.0, Utilities.getRounded(0.0, 2.5));
        assertEquals(135, Utilities.getRounded(133.5, 5.0)); // round up
        assertEquals(55.0, Utilities.getRounded(56, 2.5)); // round down
    }
    /*
    @Test
    public void getNextIntegerInTheCycleIncreasingBeforeTest() {
        // no shift
        int start = 1;
        int end = 4;
        assertEquals(4, Utilities.getNextIntegerInTheCycle(0, start, end));
        assertEquals(3, Utilities.getNextIntegerInTheCycle(-5, start, end));
        assertEquals(2, Utilities.getNextIntegerInTheCycle(-10, start, end));
        
        // no shift
        start = 3;
        end = 8;
        assertEquals(6, Utilities.getNextIntegerInTheCycle(0, start, end));
        assertEquals(4, Utilities.getNextIntegerInTheCycle(-2, start, end));
        assertEquals(4, Utilities.getNextIntegerInTheCycle(-20, start, end));
        
        // shift
        start = -2;
        end = 3;
        assertEquals(3, Utilities.getNextIntegerInTheCycle(-3, start, end));
        assertEquals(-1, Utilities.getNextIntegerInTheCycle(-7, start, end));
        assertEquals(1, Utilities.getNextIntegerInTheCycle(-17, start, end));
        
        // shift
        start = -5;
        end = 3;
        assertEquals(3, Utilities.getNextIntegerInTheCycle(-6, start, end));
        assertEquals(0, Utilities.getNextIntegerInTheCycle(-9, start, end));
        assertEquals(1, Utilities.getNextIntegerInTheCycle(-17, start, end));
    }
    
    @Test
    public void getNextIntegerInTheCycleIncreasingBetweenTest() {
        // +, +
        int start = 3;
        int end = 8;
        assertEquals(3, Utilities.getNextIntegerInTheCycle(3, start, end));
        assertEquals(6, Utilities.getNextIntegerInTheCycle(6, start, end));
        assertEquals(8, Utilities.getNextIntegerInTheCycle(8, start, end));
        
        // -, +
        start = -2;
        end = 3;
        assertEquals(-2, Utilities.getNextIntegerInTheCycle(-2, start, end));
        assertEquals(0, Utilities.getNextIntegerInTheCycle(0, start, end));
        assertEquals(3, Utilities.getNextIntegerInTheCycle(3, start, end));
        
        // -, -
        start = -11;
        end = -1;
        assertEquals(-11, Utilities.getNextIntegerInTheCycle(-11, start, end));
        assertEquals(-6, Utilities.getNextIntegerInTheCycle(-6, start, end));
        assertEquals(-1, Utilities.getNextIntegerInTheCycle(-1, start, end));
        
        // -, 0
        start = -11;
        end = -0;
        assertEquals(-11, Utilities.getNextIntegerInTheCycle(-11, start, end));
        assertEquals(-1, Utilities.getNextIntegerInTheCycle(-1, start, end));
        assertEquals(0, Utilities.getNextIntegerInTheCycle(0, start, end));
        
        // 0, +
        start = 0;
        end = 10;
        assertEquals(0, Utilities.getNextIntegerInTheCycle(0, start, end));
        assertEquals(6, Utilities.getNextIntegerInTheCycle(6, start, end));
        assertEquals(10, Utilities.getNextIntegerInTheCycle(10, start, end));
    }
    
    @Test
    public void getNextIntegerInTheCycleIncreasingAfterTest() {
        // no shift
        int start = 1;
        int end = 4;
        assertEquals(1, Utilities.getNextIntegerInTheCycle(5, start, end));
        assertEquals(2, Utilities.getNextIntegerInTheCycle(10, start, end));
        assertEquals(3, Utilities.getNextIntegerInTheCycle(15, start, end));
        
        // no shift
        start = 3;
        end = 8;
        assertEquals(3, Utilities.getNextIntegerInTheCycle(9, start, end));
        assertEquals(5, Utilities.getNextIntegerInTheCycle(11, start, end));
        assertEquals(4, Utilities.getNextIntegerInTheCycle(26, start, end));
        
        // shift
        start = -2;
        end = 3;
        assertEquals(-2, Utilities.getNextIntegerInTheCycle(4, start, end));
        assertEquals(3, Utilities.getNextIntegerInTheCycle(9, start, end));
        assertEquals(-1, Utilities.getNextIntegerInTheCycle(17, start, end));
        
        // shift
        start = -5;
        end = 3;
        assertEquals(-5, Utilities.getNextIntegerInTheCycle(4, start, end));
        assertEquals(0, Utilities.getNextIntegerInTheCycle(9, start, end));
        assertEquals(-1, Utilities.getNextIntegerInTheCycle(17, start, end));
        
        // shift
        start = -13;
        end = -11;
        assertEquals(-13, Utilities.getNextIntegerInTheCycle(-10, start, end));
        assertEquals(-11, Utilities.getNextIntegerInTheCycle(-8, start, end));
        assertEquals(-13, Utilities.getNextIntegerInTheCycle(-4, start, end));
        assertEquals(-12, Utilities.getNextIntegerInTheCycle(0, start, end));
        assertEquals(-11, Utilities.getNextIntegerInTheCycle(4, start, end));
        assertEquals(-12, Utilities.getNextIntegerInTheCycle(9, start, end));
        assertEquals(-13, Utilities.getNextIntegerInTheCycle(17, start, end));
    }
    */
    
}
