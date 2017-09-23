package artConcurrent.book.thread.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/17<p>
//-------------------------------------------------------
public class AtomicIntegerArrayTest {
    private static final int[]  value = new int[]{1,2};

    private static final AtomicIntegerArray atomicIntegerArray =  new AtomicIntegerArray(value);

    public static void main(String[] args) {
        atomicIntegerArray.getAndSet(0, 3);

        System.out.println("取值" + atomicIntegerArray.get(0));
        System.out.println("origin取值"+value[0]);
    }
}
