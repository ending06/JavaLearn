package com.hua.java.reference;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2019/4/11<p>
// -------------------------------------------------------

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {
    public static void main(String[] args) {
        ReferenceQueue queue = new ReferenceQueue();
        // obj [Date: 1372142282558] is gc
        // 结果说明：假象引用，在实例化后，就被终止了
        PhantomReference ref = new PhantomReference(new MyDate(), queue);
        System.gc();
    }
}