package org.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Executor {

    public static void main(String[] args) {

//        ExecutorService fixedSvc = Executors.newFixedThreadPool(3);
//
//        for(int i=0; i<3; i++) {
//            fixedSvc.execute(new UsingFixedThreadPool());
//        }
//        fixedSvc.shutdown();

//        ExecutorService cachedSvc = Executors.newCachedThreadPool();
//        for(int j=0; j<5; j++){
//            cachedSvc.execute(new UsingCachedThreadPool());
//        }
//        cachedSvc.shutdown();

        ExecutorService singleThreadSvc = Executors.newSingleThreadExecutor();
        for(int j=0; j<5; j++){
            singleThreadSvc.execute(new UsingCachedThreadPool());
        }
        singleThreadSvc.shutdown();
    }



    static class UsingCachedThreadPool implements Runnable {
        private static int count = 1;
        private int id;
        public UsingCachedThreadPool() {
            this.id = count++;
        }

        @Override
        public void run() {
            System.out.println("####### < Task " + id + "STARTING");

            for(int i =0; i<10; i++) {
                System.out.println("<" + id + "> Tick Tack - " + i);

                try {
                    TimeUnit.MILLISECONDS.sleep((long)Math.random()*1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("******* < Task " + id + "ENDING");
        }
    }

    static class UsingSingleThread implements Runnable {
        private static int count = 1;
        private int id;
        public UsingSingleThread() {
            this.id = count++;
        }

        @Override
        public void run() {
            System.out.println("####### < Task " + id + "STARTING");

            for(int i =0; i<10; i++) {
                System.out.println("<" + id + "> Tick Tack - " + i);

                try {
                    TimeUnit.MILLISECONDS.sleep((long)Math.random()*1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("******* < Task " + id + "ENDING");
        }
    }

    static class UsingFixedThreadPool implements Runnable{
        private static int count = 1;
        private int id;
         public UsingFixedThreadPool() {
             this.id = count++;
         }

        @Override
        public void run() {
            System.out.println("####### < Task " + id + "STARTING");

            for(int i =0; i<10; i++) {
                System.out.println("<" + id + "> Tick Tack - " + i);

                try {
                    TimeUnit.MILLISECONDS.sleep((long)Math.random()*1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("******* < Task " + id + "ENDING");
        }
    }
}
