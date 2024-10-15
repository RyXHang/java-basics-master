package com.github.stream.demo01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode //用于后期
public class Author {
    //id
    private Long id;

    //姓名
    private String name;

    //姓名
    private Integer age;

    //简介
    private String intro;

    //作品
    private List<Book> books;
}
