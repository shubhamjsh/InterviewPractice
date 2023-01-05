package org.example.multithreading;

import java.util.concurrent.TimeUnit;

public class ThreadImplementation {

    public static void main(String[] args) {
//        new FirstTask();
//        Thread t = new FirstTask();

        new SecondTask();
        new SecondTask();
    }

    static class FirstTask extends Thread {
        private static int count = 0;
        private int id;
        @Override
        public void run() {
            for(int i = 0; i < 10; i++) {
                System.out.println("<"+id+">"+"Tic Tac " + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(0);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public FirstTask() {
            this.id = ++count;
            this.start();  /*this start method can be in other class as well */
        }
    }

    static class SecondTask implements Runnable {
        private static int count = 0;
        private int id;

        @Override
        public void run() {
            for(int i = 0; i < 10; i++) {
                System.out.println("<"+id+">"+"Tic Tac " + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public SecondTask() {
            this.id = count++;
            new Thread(this).start();
        }
    }
}
