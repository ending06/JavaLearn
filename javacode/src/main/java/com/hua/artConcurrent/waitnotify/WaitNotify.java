package com.hua.artConcurrent.waitnotify;

import com.hua.artConcurrent.utils.SleepUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/2<p>
// -------------------------------------------------------
public class WaitNotify {
    public static boolean flag = true;

    public static Object lock = new Object();

    public static void main(String[] args) {
        try {
            Thread waitThread = new Thread(new Wait(), "waitThread");
            waitThread.start();
            TimeUnit.SECONDS.sleep(1);

            Thread notifyThread = new Thread(new Notify(), "notifyThread");
            notifyThread.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // --------------------- Change Logs----------------------
    // <p>@author ruirui.qu Initial Created at 17/9/2<p>
    // -------------------------------------------------------
    private static class Wait implements Runnable {

        @Override
        public void run() {
            // 加锁 拥有lock的Monitor
            synchronized (lock) {

                while (flag) {
                    try {
                        System.out.printf(Thread.currentThread() + "flag is true,wait@"
                                + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "\n");

                        // 调用wait方法后 会释放对象锁
                        lock.wait();

                    } catch (Exception e) {

                    }
                }

                System.out.printf(Thread.currentThread() + "flag is false,wait@"
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "\n");
            }

        }
    }

    // --------------------- Change Logs----------------------
    // <p>@author ruirui.qu Initial Created at 17/9/2<p>
    // -------------------------------------------------------
    private static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.printf(Thread.currentThread() + "hold  lock ,notify@"
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "\n");

                lock.notifyAll();

                flag = false;

                SleepUtils.seconds(5);

            }

            synchronized (lock) {

                System.out.printf(Thread.currentThread() + "hold  lock again,notify@"
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "\n");

                SleepUtils.seconds(5);

            }

        }
    }
}
