package com.hua.java.acculate.classloader;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/6/19<p>
//-------------------------------------------------------
public class BClass {
    static int value = 100;
    static {
        System.out.println("Class B is initialized");// 输出
    }
}
