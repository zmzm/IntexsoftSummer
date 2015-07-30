package by.intexsoft.rectangle;

/**
 * Created by Admin on 17.07.2015.
 */
public class Rectangle {
    private int x;
    private int y;
    private int width;
    private int height;

    Rectangle (int x, int y, int width, int height) throws IllegalArgumentException{
        if(width <= 0 || height <= 0){
            throw new IllegalArgumentException("Illegal width/height");
        }
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw() {
        System.out.println("Rectangle drawn!!");
    }
}
