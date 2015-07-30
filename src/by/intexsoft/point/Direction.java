package by.intexsoft.point;

/**
 * Created by Admin on 20.07.2015.
 */
public enum Direction {

    UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1);

    public final int di;
    public final int dj;

    Direction(int di, int dj) {
        this.di = di;
        this.dj = dj;
    }

    public boolean isOpposite(Direction d) {
        if (this.di == d.di * -1 || this.dj == d.dj * -1) {
            return true;
        }
        return false;
    }
}
