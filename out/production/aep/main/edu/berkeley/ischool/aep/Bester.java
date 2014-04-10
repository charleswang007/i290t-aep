package edu.berkeley.ischool.aep;

/**
 * Created by Charles on 2014/3/7.
 */
public class Bester {
    private final Bestable[] thingsToCompare;

    public Bester(Bestable... thingsToCompare){
        if (thingsToCompare == null) throw new NullPointerException();
        this.thingsToCompare = thingsToCompare;
    }

    public Bestable best(){
        Bestable bestChance = thingsToCompare[0];
        for (int i = 0; i < thingsToCompare.length; i ++){
            if (thingsToCompare[i].greater(bestChance)){
                bestChance = thingsToCompare[i];
            }
        }
        return bestChance;
    }
}
