package artConcurrent.book.thread.threadjoin;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/2<p>
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
            System.out.printf(Thread.currentThread().getName() + "is treminate\n");
        }
    }
}
