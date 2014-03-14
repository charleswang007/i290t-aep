package edu.berkeley.ischool.aep;

/**
 * Understands a shape
 */
public class Rectangle {
    private int length = 5;
    private int width = 2;

    public static Rectangle createSquare(int side) {
        return new Rectangle(side, side);
    }
    public Rectangle (int length, int width){
        this.length = length;
        this.width = width;
    }
    int area(){
        return this.length * this.width;
    }
}
