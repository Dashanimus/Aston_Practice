package org.baseapp;

import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public double getAverageGrade() {
        if (grades == null || grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public void incrementCourse() {
        this.course++;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && 
               Objects.equals(name, student.name) && 
               Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group, course);
    }

    @Override
    public String toString() {
        return String.format("%s (Курс: %d, Группа: %s, Средний балл: %.2f)", name, course, group, getAverageGrade());
    }
}