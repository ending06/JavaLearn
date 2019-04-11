package com.hua.java.reference;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2019/4/11<p>
// 隐式调用垃圾回收
// -------------------------------------------------------

public class ImplicitGarbageRetrieve {

    public static void main(String[] args) {
        MyDate date = new MyDate();
        date = null;
        ReferenceTest.drainMemory();
    }
}