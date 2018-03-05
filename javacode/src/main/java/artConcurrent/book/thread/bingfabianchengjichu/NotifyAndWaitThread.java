package artConcurrent.book.thread.bingfabianchengjichu;

import artConcurrent.book.thread.utils.SleepUtils;

import java.util.concurrent.TimeUnit;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/3/5<p>
/*flag is true,this thread is wait waitThread
  notifyThread get lock
  notifyThread get lock agin
  flag is false,this thread is running waitThread
  3 4的顺序可能互换
  */
// -------------------------------------------------------
public class NotifyAndWaitThread {
    private static boolean flag = true;

    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Wait wait = new Wait();
        Thread waitThread = new Thread(wait, "waitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);

        Notify notify = new Notify();
        Thread notifyThread = new Thread(notify,"notifyThread");
        notifyThread.start();
    }

    private static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    System.out.printf("flag is true,this thread is wait " + Thread.currentThread().getName()+"\n");
                    try {
                        lock.wait();  //调用该方法会释放锁

                    } catch (InterruptedException e) {
                        System.out.printf("flag is true,this thread wait exception: " + Thread.currentThread().getName()
                                + ":" + e+"\n");
                    }
                }
                System.out.printf("flag is false,this thread is running " + Thread.currentThread().getName()+"\n");
            }
        }
    }

    private static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.printf(Thread.currentThread().getName() + " get lock\n");
                lock.notifyAll();  //通知所有等待线程

                flag = false;

                SleepUtils.seconds(5); //当前线程执行完成后，会释放锁信息
            }

            synchronized (lock) {
                System.out.printf(Thread.currentThread().getName() + " get lock agin\n");
                SleepUtils.seconds(5);
            }
        }
    }
}
