package com.hua.java.reference;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2019/4/11<p>
//-------------------------------------------------------

public class ReferenceTest {

    public ReferenceTest() {
    }

    public static void drainMemory() {
        String[] array = new String[1024*10];
        for(int i=0;i<1024*10;i++){
            for(int j = 'a'; j <= 'z'; j++) {
                array[i] += (char)j;
            }
        }
    }
}