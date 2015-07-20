package by.intexsoft.point;

/**
 * Created by Admin on 20.07.2015.
 */
public class Point {
    private int rowIndex;
    private int columnIndex;

    public Point(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public void move(Direction d) {
        rowIndex += d.dj;
        columnIndex += d.di;

        System.out.println("(" + rowIndex + "," + columnIndex + ")");

    }
}
