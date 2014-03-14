package edu.berkeley.ischool.aep;

/**
 * Created by Charles on 2014/2/14.
 */
public class Unit2 {
    private final int inBaseUnits;
    private final String name;
    public static Unit2 FEET = new Unit2(1, "Feet");
    public static Unit2 YARDS = new Unit2(3, "Yards");
    public Unit2(int inBaseUnits, String name){
        this.inBaseUnits = inBaseUnits;
        this.name = name;
    }
}
