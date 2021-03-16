package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Main {

    public static int width = 1000;
    public static int height = 600;

    public static void main(String[] args) {
        Turtle t = new Turtle(7, width, height);
        // Начало рисования:
        t.penDown();
        drawSystem(t, 60, 10, 6, "f", "f>f-ff-", "->-f--");


    }

    public static void drawSystem(Turtle turtle, int angle, int dist, int iteration, String start, String... rule) {
        // Начинаем черепашить с координат:
        turtle.setx(50);
        turtle.sety(50);
        // Массив, изначально содержит стартовую аксиому..?, будет заполняться по правилам:
        ArrayList<String> axiom = new ArrayList<>(Arrays.asList(start.split("")));
        // Временная строка для новго алфавита:
        ArrayList<String> axmTemp = new ArrayList<>();
        // Создание правил:
        HashMap<String, String> rules = new HashMap<>();
        for (String str : rule) {
            int splitter = str.indexOf(">");
            rules.put(str.substring(0, splitter), str.substring(splitter + 1));
        }
        // Сборка "нового" алфавита, после итерирования правилами..Magic
        for (int i = 0; i < iteration; i++) {
            for (String key : axiom) {
                if (rules.containsKey(key)) axmTemp.addAll(Arrays.asList(rules.get(key).split("")));
                else axmTemp.add(key);
            }
            axiom = new ArrayList<>(axmTemp);
            axmTemp.clear();
        }

        // Рисование:
        for (String key : axiom) {
            if (key.equals("-")) {
                turtle.right(angle);
            } else if (key.equals("+")) {
                turtle.left(angle);
            } else {
                turtle.forward(dist);
            }
        }

    }


}

// TODO: центровка рисунка. - Нет, центровка только в программе для L-систем а черипаху не трожъ
// What..