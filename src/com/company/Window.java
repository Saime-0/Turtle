package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;

public class Window extends JFrame {
    private final int width;
    private final int height;

    private long last_frame_time;
    private int drawing_speed;

    private ArrayList<Integer[]> turtle_road;
    private int current_point_x; // TODO: WDF??
    private int current_point_y;
    private ArrayList<Integer[]> rendered_turtle_road = new ArrayList<>();

    public Window(ArrayList<Integer[]> turtle_road, int drawing_speed, int width, int height) {
        this.drawing_speed = drawing_speed;
        this.width = width;
        this.height = height;
        initWindow();
        // my code..
        this.turtle_road = turtle_road;


    }

    public void onRepaint(Graphics g) {
        for (Integer[] arr: turtle_road) {
            g.drawLine(arr[0],arr[1], arr[2], arr[3]);
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
        last_frame_time = System.nanoTime();
    }
}
