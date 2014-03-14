package edu.berkeley.ischool.aep;

import junit.framework.Assert;
import org.junit.Test;


/**
 * Created by Charles on 2014/1/24.
 */
public class RectangleTest {

    @Test
    public void shouldReturnAreaOfTenForTwoByFiveRectangle() {
        Rectangle rectangle = new Rectangle(5, 2);
        Assert.assertEquals(10, rectangle.area());
        Assert.assertTrue("this is true", rectangle.area()==10);
    }
    @Test
    public void createSquare() {
        Assert.assertEquals(25, Rectangle.createSquare(5).area());
    }
}
