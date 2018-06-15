package com.hua.artConcurrent.semaphore;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/23<p>
// -------------------------------------------------------
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    // 许可证 最大10个链接
    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();

                        System.out.println("save data");

                        System.out.println("save data.等待线程"+semaphore.getQueueLength());

                        semaphore.release();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            System.out.println("shutdown.等待线程"+semaphore.getQueueLength());

            threadPool.shutdown();
        }
    }

}
