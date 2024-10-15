package com.github.designpattern;

public class Singleton2 {
    public static volatile Singleton2 singleton;

    public static Singleton2 getInstance() {
        if (singleton == null) {
            // 走同步代码块
            synchronized (Singleton2.class) {
                if (singleton == null) {
                    singleton = new Singleton2();
                }
            }
        }
        return singleton;
    }
}
