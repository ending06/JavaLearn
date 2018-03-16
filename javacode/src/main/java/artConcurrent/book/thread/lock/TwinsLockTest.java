package artConcurrent.book.thread.lock;

import java.util.concurrent.locks.Lock;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/3/7<p>
// -------------------------------------------------------
public class TwinsLockTest {
    public static void main(String[] args) {

        Lock lock = new TwinsLock();

        class Worker extends Thread {

            @Override
            public void run() {

            }
        }
    }
}
