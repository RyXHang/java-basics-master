package com.github.programs.interview2;

public class MyQueue {
    private int front;
    private int rear;
    private int[] data;
    // 代表当前值
    private int size;


    public MyQueue(int capacity) {
        this.data = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean enqueue(int value) {
        // 判断是否已满
        if (this.size == data.length) {
            return false;
        }
        rear = (rear + 1) % data.length;
        data[rear] = value;
        size++;
        return true;
    }

    public int dequeue() throws Exception {
        // 特殊情况
        if (this.size == 0) {
            throw new Exception("Something went wrong.");
        }
        int value = data[front];
        front = (front + 1) % data.length;
        size--;
        return value;
    }

    public int getSize() {
        return size;
    }

    public int[] getData() {
        return data;
    }
}
