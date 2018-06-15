package com.hua.artConcurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/23<p>
// -------------------------------------------------------
public class CylicBarrierTest {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    // 主线程和子线程的调度是由CPU完成的
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}
