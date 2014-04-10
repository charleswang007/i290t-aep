package edu.berkeley.ischool.aep;

/**
 * Created by Charles on 2014/2/7.
 */

public class Quantity {
    private int value;
    private String unit;
    //private enum Unit { INCHES, FEET; }
    //private Unit unit;

    public Quantity(int value, String unit) {
        this.value = value;
        this.unit = unit;
    }


    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof Quantity)) return false;
        if ((unit == ((Quantity) other).unit) && (value == ((Quantity) other).value))
            return true;

        else if ((unit == "INCHES") && (((Quantity) other).unit == "FEET"))
            return (value == ((Quantity) other).value * 12);
        else if ((unit == "FEET") && (((Quantity) other).unit == "INCHES"))
            return (value * 12 == ((Quantity) other).value);
        else if ((unit == "FEET") && (((Quantity) other).unit == "YARDS"))
            return (value == ((Quantity) other).value * 3);
        else if ((unit == "YARDS") && (((Quantity) other).unit == "FEET"))
            return (value * 3 == ((Quantity) other).value);
        else if ((unit == "YARDS") && (((Quantity) other).unit == "MILES"))
            return (value == ((Quantity) other).value * 1760);
        else if ((unit == "MILES") && (((Quantity) other).unit == "YARDS"))
            return (value * 1760 == ((Quantity) other).value);
        else if ((unit == "TSP") && (((Quantity) other).unit == "TBSP"))
            return (value == ((Quantity) other).value * 3);
        else if ((unit == "TBSP") && (((Quantity) other).unit == "TSP"))
            return (value * 3 == ((Quantity) other).value);
        else if ((unit == "TBSP") && (((Quantity) other).unit == "OZ"))
            return (value == ((Quantity) other).value * 2);
        else if ((unit == "OZ") && (((Quantity) other).unit == "TBSP"))
            return (value * 2 == ((Quantity) other).value);
        else if ((unit == "OZ") && (((Quantity) other).unit == "CUP"))
            return (value == ((Quantity) other).value * 8);
        else if ((unit == "CUP") && (((Quantity) other).unit == "OZ"))
            return (value * 8 == ((Quantity) other).value);
        else
            return false;
    }
}
    /*
public boolean equals(Object other){
    if (other==this) return true;
    if (!(other instanceof Quantity)) return false;
    Quantity otherQuantity = (Quantity) other;
    return this.value == otherQuantity.convertTo(unit);
}
*/
/*
public class Quantity {
    private double size;
    private enum Unit {INCHES, FEET;}
    private Unit units;
    private Quantity(double inches, Unit units){
        this.size = inches;
        this.units = units;
    }
    private static Quantity INCHES(double feet){
        return new Quantity(feet*12,Unit.INCHES);
    }

    private static Quantity FEET(double inches){
        return new Quantity(inches/12,Unit.FEET);
    }

}
*/