package com.hua.artConcurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/23<p>
// -------------------------------------------------------
public class BarrierActionTest {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new BarrierAction());

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

    // --------------------- Change Logs----------------------
    // <p>@author ruirui.qu Initial Created at 17/9/23<p>
    // -------------------------------------------------------
    private static class BarrierAction implements Runnable {
        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
