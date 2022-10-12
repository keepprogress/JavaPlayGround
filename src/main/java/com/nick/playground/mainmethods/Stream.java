package com.nick.playground.mainmethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stream {
    public static void main(String args[]) {
        try {
            testMethod();
            System.out.println("我是Main的尾巴 ");
        } catch (Exception e) {
            throw new ArithmeticException();
        }
    }
    /** 為了以多執行緒去做Merge資料的Runnable物件 **/
    static class TestRunnable implements Runnable {
        int a =0;
        Map exceptionThreadMap = new HashMap();

        public Map getExceptionThreadMap() {
            return exceptionThreadMap;
        }

        public TestRunnable setExceptionThreadMap(Map exceptionThreadMap) {
            this.exceptionThreadMap = exceptionThreadMap;
            return this;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            int random = (int) (Math.random() * 1000);
            try {
                System.out.println(" 子執行緒 : " + threadName + " start. ");
                int x = 1/a;

            } catch (Exception e) {
                System.out.println(" 子執行緒 : " + threadName + "處理 失敗!!");
                exceptionThreadMap.put("Subtread" + random , threadName);
                System.out.println(" exceptionThreadMap : " + exceptionThreadMap.get("Subtread" + random));
            }
            System.out.println(" 子執行緒 : " + threadName + " finish. ");
        }
    }
    /** 多執行緒處理Merge資料 **/
    static void testMethod () {

        Map<String,String> exceptionThreadMap = new HashMap<>();
        System.out.println(" 主執行緒 :  start. ");
        List<Thread> threadList = new ArrayList<>();
        try {
            TestRunnable runnable1 = new TestRunnable();
            runnable1.a=0;

            Thread thread1 = new Thread(runnable1);
            thread1.start();
            exceptionThreadMap.putAll(runnable1.getExceptionThreadMap());

            TestRunnable runnable2 = new TestRunnable();
            runnable2.a=0;
            Thread thread2 = new Thread(runnable2);
            thread2.start();
            exceptionThreadMap.putAll(runnable2.getExceptionThreadMap());

            TestRunnable runnable3 = new TestRunnable();
            runnable3.a=0;
            Thread thread3 = new Thread(runnable3);
            thread3.start();
            exceptionThreadMap.putAll(runnable3.getExceptionThreadMap());

            threadList.add(thread1);
            threadList.add(thread2);
            threadList.add(thread3);
        } catch (Exception e) {
            System.out.println(" 主執行緒 :  處理 失敗!!");
            exceptionThreadMap.put("MainThread" , Thread.currentThread().getName());
        }
        for (Thread thread : threadList) {
            if (thread != null) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        if(exceptionThreadMap.size()>0){
            exceptionThreadMap.forEach((u,v)->System.out.println(u+" : "+v));
            throw new ArithmeticException();
        }
        System.out.println(" 主執行緒 finish.");
    }
}
