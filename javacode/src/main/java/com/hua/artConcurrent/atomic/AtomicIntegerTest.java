package com.hua.artConcurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/17<p>
//-------------------------------------------------------
public class AtomicIntegerTest {

    private static final AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println("自增=" + atomicInteger.getAndIncrement());
        System.out.println("取当前值"+atomicInteger.get());
    }
}
