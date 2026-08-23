package org.baseapp;

import org.baseapp.animals.Cat;
import org.baseapp.animals.Dog;

public class Main {
    public static void main(String[] args) {
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
    }
}