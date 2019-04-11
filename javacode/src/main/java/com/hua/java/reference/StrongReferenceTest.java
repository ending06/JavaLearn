package com.hua.java.reference;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2019/4/11<p>
// -------------------------------------------------------

public class StrongReferenceTest {
    public static void main(String[] args) {
        MyDate date = new MyDate();
        // 即使显式调用了垃圾回收，但是用于date是强引用，date没有被回收。
        System.gc();
    }
}