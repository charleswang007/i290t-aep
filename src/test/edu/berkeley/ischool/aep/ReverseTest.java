package edu.berkeley.ischool.aep;
import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Charles on 2014/3/7.
 */
public class ReverseTest {
    @Test
    public void shouldReturnReverse(){
        assertEquals("Reverse", Reverse.reverse("esreveR"));

    }
    @Test
    public void shouldEndCondition(){
        assertEquals("e", Reverse.reverse("e"));

    }
}
