package com.github.juc;

public class ThreeThreadPrintSync {
    private static Object lock = new Object();
    private static int count = 0;

    public static void main(String[] args) {
        Thread t0 = new Thread(new PrintTask(0));
        Thread t1 = new Thread(new PrintTask(1));
        Thread t2 = new Thread(new PrintTask(2));

        t0.start();
        t1.start();
        t2.start();
    }

    static class PrintTask implements Runnable {
        private int threadId;

        public PrintTask(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            for (; ; ) {
                synchronized (lock) {
                    try {
                        while (count % 3 != threadId) {
                            lock.wait();
                        }
                        if (count > 100) {
                            lock.notifyAll();
                            break;
                        }
                        System.out.println("Thread : " + threadId + " " + count++);
                        lock.notifyAll();

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}

