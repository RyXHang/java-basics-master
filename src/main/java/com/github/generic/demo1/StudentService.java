package com.github.generic.demo1;

public class StudentService {
    public static Student<? extends Comparable> max(Student<? extends Comparable>[] arr) {
        Student<? extends Comparable> max = arr[0];
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i].getScore().compareTo(max.getScore()) > 0) {
                // 替换此时的max
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Student<Integer> s1 = new Student<>("Alice", 85);
        Student<Integer> s2 = new Student<>("Bob", 90);
        Student<Integer> s3 = new Student<>("Charlie", 80);

        Student<Integer>[] students = new Student[]{s1, s2, s3};
        Student<? extends Comparable> topStudent = StudentService.max(students);

        System.out.println("Top student: " + topStudent);
    }
}
