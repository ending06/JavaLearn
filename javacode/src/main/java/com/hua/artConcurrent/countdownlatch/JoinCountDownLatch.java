package com.hua.artConcurrent.countdownlatch;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/23<p>
// -------------------------------------------------------
public class JoinCountDownLatch {
    public static void main(String[] args) {

        try {
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.printf("thread1 finish\n");
                }
            });

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.printf("thread2 finish\n");
                }
            });

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            System.out.printf("all thread finished");
        } catch (InterruptedException e) {
            System.out.printf("InterruptedException:"+e);
        }
    }
}
