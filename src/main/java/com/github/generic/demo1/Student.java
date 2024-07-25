package com.github.generic.demo1;

public class Student<T> {
    private String name;
    private T score;

    public Student() {}

    public Student(String name, T score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getScore() {
        return this.score;
    }

    public void setScore(T score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + this.name + '\'' + ", score=" + this.score + '}';
    }
}
