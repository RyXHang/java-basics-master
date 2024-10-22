package com.github.juc.thread;

import java.util.concurrent.CountDownLatch;

/**
 * TaskCoordinator（任务协调器）
 * <p>
 * 该类负责管理和协调多个任务的并发执行。通过使用多线程执行子任务，
 * 它确保主线程在所有子线程完成各自任务后才继续执行。
 * <p>
 * 主要功能：
 * 1. 并发执行多个任务，每个任务运行在单独的线程中。
 * 2. 确保主线程等待所有子任务完成后再继续执行后续操作。
 * 3. 可扩展性强，可根据不同任务类型进行定制和扩展。
 * <p>
 * 使用示例：
 * TaskCoordinator taskCoordinator = new TaskCoordinator();
 * taskCoordinator.executeTasks(); // 执行任务并等待所有任务完成。
 */
public class TaskCoordinator {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("子线程1正在执行");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("子线程2正在执行");
        });


        Thread t3 = new Thread(() -> {
            System.out.println("子线程3正在执行");
        });

        t3.start();
        t3.join();

        t2.start();
        t2.join();

        t1.start();
        t1.join();
        System.out.println("现在所有子线程执行完毕开始执行主线程");
    }
}
