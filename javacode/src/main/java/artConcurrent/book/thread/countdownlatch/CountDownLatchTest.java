package artConcurrent.book.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/23<p>
// -------------------------------------------------------
public class CountDownLatchTest {
    // int 计数器，等待第N个节点完成，则传N
    // 可以是N个线程，也可以是1个线程里的N个执行步骤
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();

                System.out.println(2);
                c.countDown();
            }
        }).start();

        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(3);
    }
}
