package com.hua.algorithm.service.link.utils;

import com.google.common.primitives.Ints;
import com.hua.algorithm.service.link.model.SingleLinked;

import java.util.Enumeration;
import java.util.Stack;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/6/15<p>
// -------------------------------------------------------
public class SingleLinkedUtils {
    // 有序链表中查找相同的部分
    public static void findSameStrByOrderingLinked(SingleLinked a, SingleLinked b) {
        if (null == a || null == b || a.getSize() == 0 || b.getSize() == 0) {
            return;
        }
        System.out.printf("链表A:");
        a.disPlay();
        System.out.printf("   链表B:");
        b.disPlay();

        SingleLinked.Node head1 = a.getHead();
        SingleLinked.Node head2 = b.getHead();
        System.out.printf("     公共子串为");
        while (head1 != null && head2 != null) {
            int result = compareResult(head1, head2);
            if (result == -1) {
                head1 = head1.getNext();
            } else if (result == 1) {
                head2 = head2.getNext();
            } else {
                System.out.printf(head1.getData() + " ");
                head1 = head1.getNext();
                head2 = head2.getNext();
            }
        }
    }

    // 删除第K个节点
    public static void delBackWardsKNode(SingleLinked originNode, int k) {
        // 首选获取节点的总长度，如果<K则无法删除
        if ((originNode.getSize() == 0) || k < 1) {
            System.out.println("参数非法，无法删除");
            return;
        }

        System.out.printf("删除前的链表为");
        originNode.disPlay();
        int count = 0;
        SingleLinked.Node curNode = originNode.getHead();
        while (curNode != null) {
            curNode = curNode.getNext();
            count++;
        }
        int posi = count - k;
        if (posi < 0) {
            System.out.println("当前长度小于" + k + ";不支持删除操作");
            return;
        }

        SingleLinked.Node processNode = originNode.getHead();
        if (posi == 0) {
            originNode.setHead(processNode.getNext());
            int size = originNode.getSize();
            originNode.setSize(size - 1);
        } else {
            int tempCount = 1;
            while (tempCount != posi) {
                processNode = processNode.getNext();
                tempCount++;
            }
            processNode.setNext(processNode.getNext().getNext());

            int size = originNode.getSize();
            originNode.setSize(size - 1);
        }
        System.out.printf("    删除后的链表为");
        originNode.disPlay();
    }

    // 空间O(N),反转链表
    public static void reverseLinkedByNSpace(SingleLinked singleLinked) {
        if (singleLinked == null || singleLinked.getSize() == 0) {
            System.out.println("空链表无需反转");
        }

        // 链表更改数据，堆栈数据也会更改。。
        Stack<Object> stack = pushStack(singleLinked);
        System.out.printf("原链表:");
        singleLinked.disPlay();

        int tempSize = stack.size();
        SingleLinked.Node reverseNode = singleLinked.getHead();
        while (tempSize > 0) {
            Object data = stack.pop();
            reverseNode.setData(data);
            reverseNode = reverseNode.getNext();

            tempSize--;
        }
        System.out.printf("    反转后链表为");
        singleLinked.disPlay();

    }

    /**
     * 判断链表是否是回文结构 O(N)
     * */
    public static boolean isPalindrome(SingleLinked singleLinked) {
        if (singleLinked == null || singleLinked.getSize() == 0) {
            return false;
        }
        Stack<Object> stack = pushStack(singleLinked);

        int tempSize = singleLinked.getSize();
        SingleLinked.Node cur = singleLinked.getHead();

        while (tempSize > 0) {
            if (cur.getData() != stack.pop()) {
                return false;
            }
            cur = cur.getNext();
            tempSize--;
        }
        return true;
    }

    private static Stack<Object> pushStack(SingleLinked singleLinked) {
        Stack<Object> stack = new Stack<>();
        int tempSize = singleLinked.getSize();
        SingleLinked.Node curNode = singleLinked.getHead();
        while (tempSize > 0) {
            stack.push(curNode.getData());
            curNode = curNode.getNext();
            tempSize--;
        }
        return stack;
    }

    private static int compareResult(SingleLinked.Node head1, SingleLinked.Node head2) {
        int head1Data = Integer.parseInt(String.valueOf(head1.getData()));
        int head2Date = Integer.parseInt(String.valueOf(head2.getData()));
        int result = Ints.compare(head1Data, head2Date);
        return result == 0 ? 0 : result > 0 ? 1 : -1;
    }

    private static void printStack(Stack<Object> stack) {
        if (stack.empty()) {
            return;
        } else {
            Enumeration items = stack.elements(); // 得到 stack 中的枚举对象
            while (items.hasMoreElements()) // 显示枚举（stack ） 中的所有元素
            {
                System.out.print(items.nextElement());
            }
        }
        System.out.println(); // 换行
    }
}
