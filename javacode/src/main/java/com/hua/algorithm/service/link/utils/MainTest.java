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
        System.out.println("找出两个单向链表的公共部分==============");
        SingleLinkedUtils.findSameStrByOrderingLinked(singleLinked, singleLinked2);
        System.out.println("\n");
        System.out.println("删除单向链表倒数第"+4+"个节点==============");
        SingleLinkedUtils.delBackWardsKNode(singleLinked,4);

        SingleLinked singleLinked1 = new SingleLinked();
        singleLinked1.addTail(1);
        singleLinked1.addTail(2);
        singleLinked1.addTail(3);
        singleLinked1.addTail(4);
        System.out.println("\n");
        System.out.println("删除单向链表倒数第"+2+"个节点==============");
        SingleLinkedUtils.delBackWardsKNode(singleLinked1,2);


        SingleLinked singleLinked3 = new SingleLinked();
        singleLinked3.addTail(1);
        singleLinked3.addTail(2);
        singleLinked3.addTail(3);
        singleLinked3.addTail(4);
        System.out.println("\n");
        System.out.println("反转单向链表==============");
        SingleLinkedUtils.reverseLinkedByNSpace(singleLinked3);
    }
}
