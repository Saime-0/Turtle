package com.company;

public class Main {

    public static int width = 1000;
    public static int height = 600;

    public static void main(String[] args) {
        Turtle t = new Turtle(width, height);
        t.to(300,300);
        t.penDown();
        t.to(300,300);
        t.to(300,320);
        // начало рисования:

        t.forward(50);
        t.left(45);
        t.forward(50);
        t.right( 90);
        t.forward(50);



    }
}
