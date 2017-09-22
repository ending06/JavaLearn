package com.java.thread.utils;

import java.util.concurrent.TimeUnit;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/2<p>
// -------------------------------------------------------
public class SleepUtils {
    public static final void seconds(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
