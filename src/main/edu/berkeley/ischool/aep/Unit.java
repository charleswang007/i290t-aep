package edu.berkeley.ischool.aep;

/**
 * Created by Charles on 2014/2/21.
 */
public class Unit {

    public enum UnitType { LENGTH, VOLUME, TEMPERATURE };
    public enum QuantityType { STATE, ORDERED, SCALED, ARITHMETIC};

    public static Unit INCHES = new Unit(1, "Inches", UnitType.LENGTH, QuantityType.ARITHMETIC);
    public static Unit FEET = new Unit(12, "Feet", UnitType.LENGTH, QuantityType.ARITHMETIC );
    public static Unit YARDS = new Unit(3 * 12, "Yards", UnitType.LENGTH, QuantityType.ARITHMETIC);
    public static Unit MILES = new Unit(1760 * 3 * 12, "Miles", UnitType.LENGTH, QuantityType.ARITHMETIC);

    public static Unit TEASPOONS = new Unit(1, "Teaspoons", UnitType.VOLUME, QuantityType.ARITHMETIC);
    public static Unit TABLESPOONS = new Unit(3, "Tablespoons", UnitType.VOLUME, QuantityType.ARITHMETIC);
    public static Unit OUNCES = new Unit(2 * 3, "Ounces", UnitType.VOLUME, QuantityType.ARITHMETIC);
    public static Unit CUPS = new Unit(2 * 3 * 8, "Cups", UnitType.VOLUME, QuantityType.ARITHMETIC);

    public static Unit FAHRENHEIT = new Unit((double) 5/9, "Fahrenheit", UnitType.TEMPERATURE, QuantityType.SCALED);
    public static Unit CELSIUS = new Unit((double) 9/5, "Celsius", UnitType.TEMPERATURE, QuantityType.SCALED);

    private double conversionFactor; //uses inches if "length", teaspoons if "volume"
    private String name;
    protected UnitType type;
    protected QuantityType qtype;

    private Unit(double conversionFactor, String name, UnitType type, QuantityType qtype) {
        this.conversionFactor = conversionFactor;
        this.name = name;
        this.type = type;
        this.qtype = qtype;
    }

    public double convertTo(double size, Unit otherUnit) throws RuntimeException{
        if (this.type != otherUnit.type) {
            throw new RuntimeException("unit mismatch");
        }
        else if (this.name == "Fahrenheit" && otherUnit.name == "Celsius"){
            return (size - 32) * conversionFactor;
        }
        else if (this.name == "Celsius" && otherUnit.name == "Fahrenheit"){
            return size * conversionFactor + 32;
        }
        else {
            return size * conversionFactor / otherUnit.conversionFactor;
        }
    }

    public String toString() {
        return name;
    }

}
