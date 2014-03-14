package edu.berkeley.ischool.aep;

/**
 * Created by Charles on 2014/2/21.
 * Abstract Class: Understands how to translate
 * between families of units (enumerated in the Unit enum).
 */

public class Measurement implements  Bestable<Measurement>{

    protected double value;
    protected Unit unit;

    public Measurement(Unit unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    public Measurement add(Measurement otherMeasurement) throws RuntimeException {
        if(this.unit.qtype != Unit.QuantityType.ARITHMETIC){
            throw new RuntimeException("cannot be added");
        }
        if(this.unit.type != otherMeasurement.unit.type) {
            throw new RuntimeException("unit mismatch");
        }
        double otherValue = otherMeasurement.unit.convertTo(otherMeasurement.value, this.unit);
        double sum = this.value + otherValue;
        return new Measurement(this.unit,sum);
    }
    @Override
    public String toString() {
        return value + " " + unit;
    }

    @Override
    public boolean equals(Object other) {
        if(other == this) return true;
        if (!(other instanceof Measurement)) return false;
        Measurement otherMeasurement = (Measurement)other;
        double otherValue = otherMeasurement.unit.convertTo(otherMeasurement.value, this.unit);
        double result = value - otherValue;
        if(Math.abs(result) < .0000000001)
            return true;
        return false;
    }

    public boolean greater(Measurement other){
        if (!(other instanceof Measurement)) return false;
        Measurement otherMeasurement = other;
        double otherValue = otherMeasurement.unit.convertTo(otherMeasurement.value, this.unit);
        double result = value - otherValue;
        if(result > 0 )
            return true;
        return false;
    }

    public static Measurement best (Measurement[] QuantityArray)  throws RuntimeException{
        Unit.UnitType unit = QuantityArray[0].unit.type;
        Measurement bestQuantity = QuantityArray[0];
        for (int i = 0; i < QuantityArray.length; i ++){
            if (QuantityArray[i].unit.type != unit){
                throw new RuntimeException("cannot compare quantity with different unit type!");
            }
            else{
                if (QuantityArray[i].greater(bestQuantity)){
                    bestQuantity = QuantityArray[i];
                }
            }
        }
        return bestQuantity;
    }

    @Override
    public int hashCode() {
        long longBits = Double.doubleToLongBits(value);
        return (int)(longBits ^ longBits >>>32);
    }

}

