package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window extends JFrame {
    public int width;
    public int height;
    public ArrayList<Integer[]> turtle_road = new ArrayList<>();

    public Window(ArrayList<Integer[]> turtle_road, int width, int height) {
        this.width = width;
        this.height = height;
        initWindow();
        // my code..
        this.turtle_road = turtle_road;


    }

    public void onRepaint(Graphics g) {
        g.drawOval(turtle_road.get(0)[0]-2, turtle_road.get(0)[1]-2, 4,4);
        for (Integer[] arr: turtle_road) {
            g.drawLine(arr[0],arr[1], arr[2], arr[3]);
            g.drawOval(arr[0]-1,arr[1]-1, 2, 2);

        }
    }

    public class TurtleField extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            onRepaint(g);
            repaint();
        }
    }

    public void initWindow() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int ww = (int) screenSize.getWidth();
        int wh = (int) screenSize.getHeight();
        this.setLocation((ww-width)/2, (wh-height)/2);
        this.setSize(width, height);
        this.setResizable(false);

        TurtleField turtle_field = new TurtleField();
        this.setTitle("Turtle");

        this.add(turtle_field);
        this.setVisible(true);
    }
}
