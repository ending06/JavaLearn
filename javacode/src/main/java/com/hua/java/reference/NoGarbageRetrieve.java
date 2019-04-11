package com.hua.java.reference;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2019/4/11<p>
// -------------------------------------------------------

public class NoGarbageRetrieve {
    // 清除对象
    public static void main(String[] args) {
        MyDate date = new MyDate();
        date = null;
    }
}