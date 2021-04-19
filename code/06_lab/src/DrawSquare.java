import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawSquare extends JPanel {
    public ArrayList<SimpleSquare> data;

    public DrawSquare() {
        super();
        data = new ArrayList<>();
    }

    public void addSquare(SimpleSquare s) {
        data.add(s);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        for (SimpleSquare s : data) {
            g.setColor(s.color);
            g.fillRect(s.SQUARE_X, s.SQUARE_Y, s.SIZE, s.SIZE);
        }
    }

}