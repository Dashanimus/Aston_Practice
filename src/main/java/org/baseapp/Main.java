package org.baseapp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        System.out.println("Задание 1:");
        Set<Student> studentSet = new HashSet<>();

        studentSet.add(new Student("Иван Иванов", "А-11", 1, List.of(4, 5, 3, 4)));
        studentSet.add(new Student("Стас Васильев", "Б-21", 2, List.of(2, 3, 2, 2))); // Ср. балл < 3
        studentSet.add(new Student("Андрей Смирнов", "А-11", 1, List.of(5, 5, 4, 5)));
        studentSet.add(new Student("Мария Иванова", "В-31", 3, List.of(3, 3, 4, 3)));

        StudentService.processStudents(studentSet);
       // studentSet.forEach(System.out::println); - Не сказано, надо ли выводить полный список после удаления студентов со ср. баллом < 3
        StudentService.printStudents(studentSet, 2); 

        System.out.println("\nЗадание 2:");
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Рекламный", "8-800-555-35-35");
        phoneBook.add("Король", "777-77-77");
        phoneBook.add("Король", "333-33-33");

        System.out.println("Номера для фамилии 'Рекламный': " + phoneBook.get("Рекламный"));
        System.out.println("Номера для фамилии 'Король': " + phoneBook.get("Король"));
        System.out.println("Номера для фамилии 'Левый': " + phoneBook.get("Смирнов"));
    }
}