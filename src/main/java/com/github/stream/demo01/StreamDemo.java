package com.github.stream.demo01;

import com.github.stream.demo01.Author;
import com.github.stream.demo01.Book;

import java.util.*;

public class StreamDemo {

    public static void main(String[] args) {
        // 1.打印所有年龄小于70的作家的名字, 并且要注意去重
        // 传统做法
        List<Author> authors2 = getAuthors();
        Set<String> authorNames = new HashSet<>();
        for (Author author : authors2) {
            if (author.getAge() < 70) {
                authorNames.add(author.getName());
            }
        }

        for (String authorName : authorNames) {
            System.out.println(authorName);
        }

        // stream流做法
        List<Author> authors1 = getAuthors();
        authors1.stream().
                filter(author -> author.getAge() < 70)
                .map(Author::getName)
                .distinct()
                .forEach(System.out::println);

        System.out.println();
    }

    public static List<Author> getAuthors() {
        //数据初始化
        Author author1 = new Author(1L, "莫言", 69, "中国首位诺贝尔文学奖获得者", null);
        Author author2 = new Author(2L, "韩寒", 41, "中国80后代表作家", null);
        Author author3 = new Author(3L, "贾平凹", 72, "茅盾文学奖获得者", null);
        Author author4 = new Author(3L, "贾平凹", 72, "茅盾文学奖获得者", null);

        //书籍列表
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "《丰乳肥臀》", "哲学,爱情", 88, "山东发生的故事"));
        books1.add(new Book(2L, "《红高粱》", "个人成长,爱情", 99, "高粱地发生的故事"));

        books2.add(new Book(3L, "《三重门》", "哲学", 85, "三重门发生的故事"));
        books2.add(new Book(3L, "《三重门》", "哲学", 85, "三重门发生的故事"));
        books2.add(new Book(4L, "《长安乱》", "爱情,个人传记", 56, "在长安街发生的故事"));


        books3.add(new Book(5L, "《废都》", "爱情", 56, "废都发生的故事"));
        books3.add(new Book(6L, "《秦腔》", "个人传记", 100, "秦腔发生的故事"));
        books3.add(new Book(6L, "《秦腔》", "个人传记", 100, "秦腔发生的故事"));

        author1.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author1, author2, author3, author4));
        return authorList;

    }
}