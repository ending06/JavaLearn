package com.hua.artConcurrent.base;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/8/29<p>
// -------------------------------------------------------
public class MainThread {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.printf("Mythread is start\n");

    }

}
