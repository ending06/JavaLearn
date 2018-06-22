package com.hua.java.acculate.classloader;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/6/19<p>
//-------------------------------------------------------
public class AClass extends BClass {
    static {
        System.out.println("Class A is initialized"); // 不输出
    }
}
