package org.baseapp;

import java.util.Set;

class StudentService {

    public static void processStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3.0);
        for (Student student : students) {
            student.incrementCourse();
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты на " + course + " курсе:");
        boolean found = false;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("- " + student.getName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("(Нет студентов на данном курсе!)");
        }
    }
}