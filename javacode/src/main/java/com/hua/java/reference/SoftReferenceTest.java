package com.hua.java.reference;

import java.lang.ref.SoftReference;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2019/4/11<p>
// -------------------------------------------------------

public class SoftReferenceTest {

    public static void main(String[] args) {
        SoftReference ref = new SoftReference(new MyDate());
        //在内存不足时，软引用被终止。软引用被禁止时
        ReferenceTest.drainMemory();

/*        如上代码等价于
        MyDate date = new MyDate();

        由JVM决定运行
        If(JVM.内存不足()) {
            date = null;
            System.gc();
        }*/
    }
}