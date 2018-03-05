package artConcurrent.book.thread.threadjoin;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/2<p>
// 当前线程执行，必须从上一个线程结束，才执行，0线程必须在main函数结束后才执行
/*      main函数结束
        0is treminate

        1is treminate

        2is treminate

        3is treminate

        4is treminate

        5is treminate

        6is treminate

        7is treminate

        8is treminate

        9is treminate*/
// -------------------------------------------------------
public class Join {

    // 线程1需要等待线程0结束，线程0需要等待main结束
    public static void main(String[] args) {
        Thread previous = Thread.currentThread();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Demo(previous), String.valueOf(i));
            thread.start();

            previous = thread;
        }
        System.out.println("main函数结束");
    }

    // --------------------- Change Logs----------------------
    // <p>@author ruirui.qu Initial Created at 17/9/2<p>
    // -------------------------------------------------------
    private static class Demo implements Runnable {
        private Thread thread;

        public Demo(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "is treminate\n");
        }
    }
}
