package edu.berkeley.ischool.aep;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;
/**
 * Created by Charles on 2014/2/14.
 */
public class QuantityTest {

    @Test
    public void twelveInchesShouldBeEqualToOneFoot() {
        assertEquals(new Quantity(12, "INCHES"), new Quantity(1, "FEET"));
        assertEquals(new Quantity(1, "YARDS"), new Quantity(3, "FEET"));
        assertEquals(new Quantity(1760, "YARDS"), new Quantity(1, "MILES"));
        assertEquals(new Quantity(1, "TBSP"), new Quantity(3, "TSP"));
        assertEquals(new Quantity(1, "OZ"), new Quantity(2, "TBSP"));
        assertEquals(new Quantity(8, "OZ"), new Quantity(1, "CUP"));
    }
}
