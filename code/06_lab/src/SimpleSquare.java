import java.awt.*;
import java.util.Random;

public class SimpleSquare {
    public int SQUARE_X, SQUARE_Y, SIZE;
    public Color color;

    public SimpleSquare(int x, int y, int size) {
        this.SQUARE_X = x;
        this.SQUARE_Y = y;
        this.SIZE = size;
        Random r = new Random();
        this.color = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
    }

    public SimpleSquare(int x, int y, int size, Color clr) {
        this.SQUARE_X = x;
        this.SQUARE_Y = y;
        this.SIZE = size;
        this.color = clr;
    }

    public boolean isPointInside(int x, int y) {
        int x1 = SQUARE_X, y1 = SQUARE_Y;
        int x2 = SQUARE_X + SIZE, y2 = SQUARE_Y;
        int x3 = SQUARE_X + SIZE, y3 = SQUARE_Y - SIZE;
        int x4 = SQUARE_X, y4 = SQUARE_Y - SIZE;
        //System.out.print(x1 + " " + y1 + ", " + x2 + " " + y2 + ", " + x3 + " " + y3 + ", " + x4 + " " + y4 + "\n");
        return x >= x1 && x >= x4 && x <= x2 && x<= x3 && y <= y1 && y <= y2 && y >= y3 && y >= y4;
    }
}