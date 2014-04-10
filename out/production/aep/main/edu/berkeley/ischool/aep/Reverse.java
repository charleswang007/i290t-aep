package edu.berkeley.ischool.aep;

/**
 * Created by Charles on 2014/3/7.
 */
public class Reverse {
    private String toReverse;
    private String reversed = "";

    public Reverse(String toReverse){
        this.toReverse = toReverse;
    }

    public static String reverse(String toReverse){
        if (toReverse.length() == 1) return toReverse;
        else return reverse(toReverse.substring(1)) + toReverse.charAt(0);
    }
}
