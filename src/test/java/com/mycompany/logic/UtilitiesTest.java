
package com.mycompany.logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UtilitiesTest {
    
    @Test
    public void UtilitiesTest() {
        assertEquals(5.0, Utilities.getRounded(5.0, 1.0));
        assertEquals(5.0, Utilities.getRounded(5.0, 1.25));
        assertEquals(5.0, Utilities.getRounded(5.0, 2.5));
        assertEquals(5.0, Utilities.getRounded(5.0, 5.0));
        
        assertEquals(0.0, Utilities.getRounded(0.0, 2.5));
        assertEquals(135, Utilities.getRounded(133.5, 5.0)); // round up
        assertEquals(55.0, Utilities.getRounded(56, 2.5)); // round down
    }
    
}
