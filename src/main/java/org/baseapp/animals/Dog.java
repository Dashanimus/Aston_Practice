package org.baseapp.animals;

public class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
    super(name, 500, 10); // Имя, бег, плавание
    dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
}
