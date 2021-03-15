package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Main {

    public static int width = 1000;
    public static int height = 600;

    public static void main(String[] args) {
        Turtle t = new Turtle(width, height);
        // Начало рисования:
        t.penDown();
        drawSystem(t, 4);


    }

    public static void drawSystem(Turtle turtle, int iteration) {
        // Начинаем черепашить с координат:
        turtle.setx(200);
        turtle.sety(200);
        // Аксиома, она же и алфавит:
        ArrayList<String> axiom = new ArrayList<>(Arrays.asList("F++F++F++F++F".split("")));
        // Временная строка для новго алфавита:
        ArrayList<String> axmTemp = new ArrayList<>();
        // Создание правил:
        HashMap<String, String> rules = new HashMap<>();
        rules.put("f", "F++F++F+++++F-F++F");
        // Угол поворота при "-" и "+", и длина отрезков при остальных аксиомах:
        int angle = 36;
        int dist = 10;
        // Сборка "нового" алфавита, после итерирования правилами..Magic
        for (int i = 0; i < iteration; i++) {
            for (String key: axiom) {
               if (rules.containsKey(key)) axmTemp.addAll(Arrays.asList(rules.get(key).split("")));
            }
//            System.out.printf("%d(%d): %s\n", i, iteration, axmTemp.toString());
            axiom = new ArrayList<>(axmTemp);
            axmTemp.clear();
        }
        System.out.println(axiom.toString());
        // Рисование:
        for (String key: axiom) {
            if (key.equals("-")) {
                turtle.right(angle);
                System.out.println(key + " = -");
            }
            else if (key.equals("+")) {
                turtle.left(angle);
                System.out.println(key + " = +");
            }
            else {
                turtle.forward(dist);
                System.out.println(key + " = forward");
            }
        }

    }


}

// TODO: центровка рисунка. - Нет, центровка только в программе для L-систем а черипаху не трожъ
// What..