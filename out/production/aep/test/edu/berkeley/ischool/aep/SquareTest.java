package edu.berkeley.ischool.aep;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Charles on 2014/2/7.
 */
public class SquareTest{

    @Test
    public void shouldReturnAreaOfSquare() {
        Square square = new Square(8);
        Assert.assertEquals(64, square.area());
    }
}
