package com.hua.java.reference;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2019/4/11<p>
// -------------------------------------------------------

import java.util.Date;

public class MyDate extends Date {

    public MyDate() {
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("obj [Date: " + this.getTime() + "] is gc");
    }

    @Override
    public String toString() {
        return "Date:" + this.getTime();
    }
}