import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PictureForm {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton applyButton;
    private DrawSquare drawSquare;

    private class ButtonClickListener implements ActionListener {

        private int getCoord(int min, int max) {
            return (int)((Math.random() * (max - min)) + min);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Apply")) {
                applyButton.setText("Apply");
                String n = textField1.getText().toString();
                String r = textField2.getText().toString();
                drawSquare.data.clear();
                try {
                    int nValue = Integer.parseInt(n);
                    try {
                        int rValue = Integer.parseInt(r);
                        if (nValue >= 0 && rValue > 0) {
                            int xMax = 700 - rValue;
                            int yMax = 500 - rValue;
                            for (int i = 0; i < nValue; ++i) {
                                drawSquare.addSquare(new SimpleSquare(getCoord(0, xMax), getCoord(0, yMax), rValue));
                            }
                            drawSquare.repaint();
                            /*drawSquare.setPreferences(5000, 0, );*/

                        }
                        else {
                            applyButton.setText("Error");
                        }1

                    } catch (NumberFormatException nfe) {
                        System.out.println("error");
                        applyButton.setText("Error");
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("error");
                    applyButton.setText("Error");
                }

            }
        }
    }

    public PictureForm() {
        this.applyButton.setActionCommand("Apply");
        this.applyButton.addActionListener(new ButtonClickListener());

        drawSquare.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.out.print(e.getX() + " ");
                System.out.println(e.getY());
                int _x = e.getX(), _y = e.getY();
                for (int i = 0; i < drawSquare.data.size(); ++i) {
                    SimpleSquare s = drawSquare.data.get(i);
                    if (s.isPointInside(_x, _y - s.SIZE)) {
                        System.out.println("INSIDE");
                        drawSquare.data.remove(s);
                    }
                }
                drawSquare.repaint();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PictureForm");
        frame.setBounds(100,100, 1000, 600);
        frame.setContentPane(new PictureForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
