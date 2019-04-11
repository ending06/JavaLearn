package com.hua.java.reference;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2019/4/11<p>
// 显式调用垃圾回收
// -------------------------------------------------------

public class ExplicitGarbageRetrieve {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyDate date = new MyDate();
        date = null;
        // 调用了System.gc()，使JVM运行垃圾回收
        System.gc();
    }
}