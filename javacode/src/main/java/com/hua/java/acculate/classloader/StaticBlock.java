package com.hua.java.acculate.classloader;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/6/19<p>
//-------------------------------------------------------
public class StaticBlock {
    static final int c = 3;

/*
    static int e = 5;
    static {
        d = 5;
        e = 10;
        System.out.println("Initializing");
    }

    StaticBlock() {
        System.out.println("Building");
    }
*/


/*    static final int d;

    static int e;

    static {
        e=5;
    }

    static {
        d = 5;
        e = 10;
        System.out.println("Initializing");
    }

    StaticBlock() {
        System.out.println("Building");
    }*/

    static {
        d = 5;
        e = 10;
        System.out.println("Initializing");
    }

    static final int d;

    static int e = 5;

    StaticBlock() {
        System.out.println("Building");
    }
}
