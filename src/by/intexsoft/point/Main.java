package by.intexsoft.point;

import java.io.IOException;

/**
 * Created by Admin on 20.07.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Point point = new Point(1,1);
        System.out.println(point);
        point.move(Direction.UP);
        System.out.println(point);
        point.move(Direction.RIGHT);
        System.out.println(point);
    }
}
