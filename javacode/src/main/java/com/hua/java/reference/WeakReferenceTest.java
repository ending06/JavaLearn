package com.hua.java.reference;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2019/4/11<p>
//-------------------------------------------------------

import java.lang.ref.WeakReference;

public class WeakReferenceTest {
    public static void main(String[] args) {
        //在JVM垃圾回收运行时，弱引用被终止.
        WeakReference ref = new WeakReference(new MyDate());
        System.gc();
    }
}