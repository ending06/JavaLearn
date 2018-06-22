package com.hua.java.acculate.gc;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/6/19<p>
// -------------------------------------------------------
public class GCTest {
    /**
     *
     *[GC 33424K->1568K(125952K), 0.0017450 secs]
     [GC 35032K->1504K(125952K), 0.0013280 secs]
     [GC 34730K->1408K(125952K), 0.0012710 secs]
     *
     * 33424K:回收前的，对象占用空间
     * 1568K：回收后，对象占用空间
     * 0.0017450：本地垃圾回收使用时间
     *
     * */
/*    public static void main(String[] args) {
        byte[] bytes = null;
        for (int i = 0; i < 100; i++) {
            bytes = new byte[1 * 1024 * 1024];
        }
    }*/


    public static void main(String[] args) {
        System.out.println("最大堆：" + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");
        System.out.println("空闲堆：" + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");
        System.out.println("总的堆：" + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
    }
}
