package com.github.juc;

import java.util.concurrent.*;

public class ScheduledExecutorExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 创建一个包含单线程的 ScheduledExecutorService
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(30);

        // 定义任务1
        Callable<Long> task1 = () -> {
            long startTime = System.currentTimeMillis();
            System.out.println("Task 1 is running...");
            Thread.sleep(1000); // 模拟任务执行时间
//            System.out.println(System.currentTimeMillis());
//            System.out.println(System.currentTimeMillis() - startTime);
            return System.currentTimeMillis() - startTime; // 返回任务执行时间
        };

        // 定义任务2
        Callable<Long> task2 = () -> {
            long startTime = System.currentTimeMillis();
            System.out.println("Task 2 is running...");
            Thread.sleep(2000); // 模拟任务执行时间
            return System.currentTimeMillis() - startTime; // 返回任务执行时间
        };

        // 定义任务3
        Callable<Long> task3 = () -> {
            long startTime = System.currentTimeMillis();
            System.out.println("Task 3 is running...");
            Thread.sleep(1500); // 模拟任务执行时间
            return System.currentTimeMillis() - startTime; // 返回任务执行时间
        };

        // 安排任务1立即执行
        ScheduledFuture<Long> future1 = executor.schedule(task1, 0, TimeUnit.MILLISECONDS);

        // 安排任务2在任务1完成后的时间延迟后执行
        ScheduledFuture<Long> future2 = executor.schedule(task2, future1.get(), TimeUnit.MILLISECONDS);
        System.out.println(future1.get());

        // 安排任务3在任务2完成后的时间延迟后执行
        ScheduledFuture<Long> future3 = executor.schedule(task3, future2.get(), TimeUnit.MILLISECONDS);
        System.out.println(future2.get());

        // 关闭执行器
        executor.shutdown();
    }
}
