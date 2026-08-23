package org.baseapp;

import org.baseapp.animals.Cat;
import org.baseapp.animals.Dog;

import org.baseapp.figures.Circle;
import org.baseapp.figures.Rectangle;
import org.baseapp.figures.ShapeInterface;
import org.baseapp.figures.Triangle;

public class Main {
    public static void main(String[] args) {
        // Задание 1
        Dog dogBobik = new Dog("Бобик");
        Cat catMurka = new Cat("Мурка", 10);
        Cat.CatBowl bowl = new Cat.CatBowl(30);

        System.out.println("Задание 1:");
        dogBobik.run(150);
        dogBobik.swim(100);
        catMurka.run(50);
        catMurka.swim(10);

        Cat[] cats = {
            new Cat("Мурзик", 10),
            new Cat("Барсик", 15),
            new Cat("Муся", 12)
        };

        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        for (Cat cat : cats) {
            cat.printSatietyInfo();
        }
        bowl.info();

        System.out.println();

        // Задание 2
        ShapeInterface[] shapes = new ShapeInterface[3];
        shapes[0] = new Circle(3.0, " белый", " красный");
        shapes[1] = new Rectangle(5.5, 5.0, " чёрный", " розовый");
        shapes[2] = new Triangle(9.0, 7.0, 3.0, " белый", " синий");

        System.out.println("Задание 2:");
        for (ShapeInterface shape : shapes) {
            shape.getInfo();
        }
    }
}