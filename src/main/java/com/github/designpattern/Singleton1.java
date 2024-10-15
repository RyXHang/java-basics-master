package com.github.designpattern;

import java.util.concurrent.locks.ReentrantLock;

public class Singleton1 {

    public static Singleton1 singleton = new Singleton1();

    private Singleton1() {
        // 私有构造函数
    }

    public static Singleton1 getInstance() {
        return singleton;
    }
}