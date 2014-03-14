package edu.berkeley.ischool.aep;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
/**
 * Created by Charles on 2014/2/21.
 */
public class MeasurementTest {
    @Test
    public void twelveInchesShouldBeEqualToOneFoot() {
        assertEquals(new Measurement(Unit.INCHES,12), new Measurement(Unit.FEET,1));
    }
    @Test
    public void testIsEqual3Feet1Yard() {
        assertEquals(new Measurement(Unit.FEET, 3), new Measurement(Unit.YARDS, 1));
    }

    @Test
    public void testIsEqual1760Yards1Mile() {
        assertEquals(new Measurement(Unit.MILES, 1), new Measurement(Unit.YARDS, 1760));
    }

    @Test
    public void testIsEqual1Tablespoon3Teaspoons() {
        assertEquals(new Measurement(Unit.TEASPOONS, 3), new Measurement(Unit.TABLESPOONS, 1));
    }

    @Test
    public void testIsEqual1Ounce2Tablespoons() {
        assertEquals(new Measurement(Unit.OUNCES, 1), new Measurement(Unit.TABLESPOONS, 2));
    }

    @Test
    public void testIsEqual8Ounces1Cup() {
        assertEquals(new Measurement(Unit.OUNCES, 8), new Measurement(Unit.CUPS, 1));
    }

    @Test
    public void twoInchesPlusTwoInchesShouldEqualFourInches() throws RuntimeException {
        assertEquals(new Measurement(Unit.INCHES, 2).add(new Measurement(Unit.INCHES, 2)),new Measurement(Unit.INCHES, 4));
    }

    @Test
    public void twoTbspPlusOneOunceShouldEqualTwelveTsps() throws RuntimeException {
        assertEquals(new Measurement(Unit.TABLESPOONS, 2).add(new Measurement(Unit.OUNCES, 1)),new Measurement(Unit.TEASPOONS, 12));
    }

    @Test(expected = RuntimeException.class)
    public void testMismatchRaiseException() throws RuntimeException {
        assertEquals(new Measurement(Unit.TEASPOONS, 1).add(
                new Measurement(Unit.INCHES, 1)),new Measurement(Unit.INCHES, 2));
    }

    @Test
    public void twoHundredAndTwelveFahrenheitEqualsOneHundredCelsius() throws RuntimeException {
        assertEquals(new Measurement(Unit.FAHRENHEIT, 212), new Measurement(Unit.CELSIUS, 100));
        assertEquals(new Measurement(Unit.CELSIUS, 100), new Measurement(Unit.FAHRENHEIT, 212));

    }

    @Test
    public void thirtyTwoFahrenheitEqualsZeroCelsius() throws RuntimeException {
        assertEquals(new Measurement(Unit.FAHRENHEIT, 32), new Measurement(Unit.CELSIUS, 0));
        assertEquals(new Measurement(Unit.FAHRENHEIT, -40), new Measurement(Unit.CELSIUS, -40));
    }

    @Test
    public void testToStringMakesSense() {
        assertEquals("12.0 Inches", new Measurement(Unit.INCHES, 12).toString());
        assertEquals("10.0 Feet", new Measurement(Unit.FEET, 10).toString());
        assertEquals("300.0 Yards", new Measurement(Unit.YARDS, 300).toString());
    }

    @Test(expected = RuntimeException.class)
    public void tempCanNotBeAdded(){
        assertEquals(new Measurement(Unit.CELSIUS, 200).add(
                new Measurement(Unit.CELSIUS, 100)),new Measurement(Unit.CELSIUS, 100));
    }
    @Test
    public void testGreaterThan() throws RuntimeException {
        assertTrue(new Measurement(Unit.INCHES, 2).greater(new Measurement(Unit.INCHES, 1)));
    }

    @Test
    public void testBestOnSameUnit() throws RuntimeException {
        Measurement[] quantityArray = {new Measurement(Unit.INCHES, 1),new Measurement(Unit.INCHES, 5),new Measurement(Unit.INCHES, 10)};
        assertEquals(Measurement.best(quantityArray), new Measurement(Unit.INCHES, 10));
    }

    @Test
    public void testBestOnDifferentUnitButSameUnitType() throws RuntimeException {
        Measurement[] quantityArray = {new Measurement(Unit.INCHES, 1),new Measurement(Unit.FEET, 1000),new Measurement(Unit.MILES, 1)};
        assertEquals(Measurement.best(quantityArray), new Measurement(Unit.MILES, 1));
    }

    @Test(expected = RuntimeException.class)
    public void testBestShouldThrowException() throws RuntimeException {
        Measurement[] quantityArray = {new Measurement(Unit.INCHES, 1),new Measurement(Unit.INCHES, 2),new Measurement(Unit.CELSIUS, 100)};
        assertEquals(Measurement.best(quantityArray), new Measurement(Unit.INCHES, 2));
    }

    @Test

    public void testBestMeasurement(){
        Measurement A = new Measurement(Unit.INCHES, 1);
        Measurement B = new Measurement(Unit.INCHES, 2);
        Measurement C = new Measurement(Unit.INCHES, 3);
        assertEquals(new Bester(A, B, C).best(), C);
    }

}
