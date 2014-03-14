package edu.berkeley.ischool.aep;

/**
 * Created by Charles on 2014/1/31.
 */
public class Chance implements Bestable<Chance> {
    double prob;
    public Chance (double probability){
        this.prob = probability;
    }
    public Chance (){
        this.prob = 1;
    }

    @Override
    public boolean equals(Object c){
        if (c == this) return true;
        if(!(c instanceof Chance)) return false;
        if (Math.abs(this.prob - ((Chance)c).prob) < 0.001){
            return true;
        } else return false;
    }

    @Override
    public int hashCode() {
        //return 42;
        long longBits = Double.doubleToLongBits(prob);
        return (int) (longBits ^ (longBits >>> 32));
    }
    @Override
    public String toString(){
        return "Value: " + this.prob;
    }

    public Chance not() {
        double newChance =  1 - this.prob;
        return new Chance(newChance);
    }

    public Chance and(Chance c1, Chance c2) {
        double newChance = c1.prob * c2.prob;
        return new Chance(newChance);
    }

    public Chance or(Chance c1, Chance c2) {
        double newChance = c1.prob + c2.prob - c1.prob * c2.prob;
        return new Chance(newChance);
    }

    public Chance or_new(Chance c1, Chance c2) {
        return and(c1.not(), c2.not()).not();
    }

    @Override
    public boolean greater(Chance other){
        if (!(other instanceof Chance)) return false;
        Chance otherChance = other;
        return this.prob > other.prob;
    }
}
