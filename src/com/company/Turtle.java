package com.company;

import java.util.ArrayList;

public class Turtle {

    private Window window;
    private ArrayList<Integer[]> road = new ArrayList<>();
    private int turtle_x;
    private int turtle_y;
    private boolean pendown = false;
    private double angle = 0.0;
    private int speed;

    public Turtle(int speed, int width, int height) {
        window = new Window(road, speed, width, height);
        turtle_x = 0;
        turtle_y = 0;
    }

    public void penDown(boolean down) {
        pendown = down;
    }

    public void penDown() {
        this.penDown(true);
    }

    public void left(double deg) {
        angle -= deg;
    }

    public void right(double deg) {
        angle += deg;
    }

    public void forward(int distance) {
        int x, y;

        x = (int) (distance * Math.cos(angle * (Math.PI / 180)));
        y = (int) (distance * Math.sin(angle * (Math.PI / 180)));

        to(turtle_x + x, turtle_y + y);
    }

    public void backward(int distance) {
        int x, y;

        x = (int) (distance * Math.cos(angle * (Math.PI / 180)));
        y = (int) (distance * Math.sin(angle * (Math.PI / 180)));

        to(turtle_x - x, turtle_y - y);
    }

    // прямое изменение полей:

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void to(int x, int y) {
        if (pendown) road.add(new Integer[]{turtle_x, turtle_y, x, y});
        turtle_x = x;
        turtle_y = y;
    }

    public void home() {
        boolean pd_temp = pendown;
        pendown = false;
        to(0, 0);
        pendown = pd_temp;
    }

    public void setx(int x) {
        boolean pd_temp = pendown;
        pendown = false;
        to(x, turtle_y);
        pendown = pd_temp;
    }

    public void sety(int y) {
        boolean pd_temp = pendown;
        pendown = false;
        to(turtle_x, y);
        pendown = pd_temp;
    }

    public void undo() {
        // TODO:
    }
}
