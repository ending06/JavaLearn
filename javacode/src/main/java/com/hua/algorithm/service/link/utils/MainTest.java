package com.hua.algorithm.service.link.utils;

import com.hua.algorithm.service.link.model.SingleLinked;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/6/15<p>
//-------------------------------------------------------
public class MainTest {
    public static void main(String[] args) {
        SingleLinked singleLinked = new SingleLinked();
        singleLinked.addTail(1);
        singleLinked.addTail(2);
        singleLinked.addTail(3);
        singleLinked.addTail(4);

        SingleLinked singleLinked2 = new SingleLinked();
        singleLinked2.addTail(2);
        singleLinked2.addTail(3);
        singleLinked2.addTail(5);

        SingleLinkedUtils.findSameStrByOrderingLinked(singleLinked,singleLinked2);
    }
}
