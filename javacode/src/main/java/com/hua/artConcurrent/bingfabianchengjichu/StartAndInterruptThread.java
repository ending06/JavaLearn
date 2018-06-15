package com.hua.artConcurrent.bingfabianchengjichu;

import java.util.concurrent.TimeUnit;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/3/5<p>
//-------------------------------------------------------
public class StartAndInterruptThread {

    public static void main(String[] args) {
        try {
            Runner one = new Runner();
            Thread countThread = new Thread(one,"count thread");
            countThread.start();

            TimeUnit.SECONDS.sleep(1);
            countThread.interrupt();// 中断操作停止线程

            Runner two = new Runner();
            countThread = new Thread(two,"count thread reset");
            countThread.start();

            TimeUnit.SECONDS.sleep(1);
            two.cancel();  //通过cancel操作停止线程

        } catch (InterruptedException e) {
            System.out.printf("出现异常");
            e.printStackTrace();
        }
    }


    private static class Runner implements Runnable {
        private  long i ;

        private volatile boolean on = true;
        @Override
        public void run() {
            while( on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.printf("count i="+i+"\n");

        }

        private void cancel(){
            on = false;
        }
    }
}
