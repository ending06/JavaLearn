package com.hua.algorithm.service.link.utils;

import com.google.common.primitives.Ints;
import com.hua.algorithm.service.link.model.SingleLinked;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/6/15<p>
//-------------------------------------------------------
public class SingleLinkedUtils {
    //有序链表中查找相同的部分
    public static void findSameStrByOrderingLinked(SingleLinked a, SingleLinked b) {
        if (null == a || null == b || a.getSize() == 0 || b.getSize() == 0) {
            return;
        }
        SingleLinked.Node head1 = a.getHead();
        SingleLinked.Node head2 = b.getHead();

        while(head1!=null&&head2!=null){
            int result = compareResult(head1,head2);
            if(result==-1){
                head1 = head1.getNext();
            }else if(result==1){
                head2 = head2.getNext();
            }else{
                System.out.println(head1.getData()+";");
                head1 = head1.getNext();
                head2 = head2.getNext();
            }
        }
    }
    //删除第K个节点
    public static void delBackWardsKNode(SingleLinked originNode,int k){
        //首选获取节点的总长度，如果<K则无法删除
        if((originNode.getSize()==0)||k<1){
            System.out.println("参数非法，无法删除");
            return;
        }

        System.out.println("删除前的链表为");
        originNode.disPlay();
        int count = 0;
        SingleLinked.Node curNode = originNode.getHead();
        while(curNode!=null){
            curNode = curNode.getNext();
            count++;
        }
        System.out.println("当前链表的总长度="+count);
        int posi = count-k;
        if(posi<0){
            System.out.println("当前长度小于"+k+";不支持删除操作");
            return ;
        }

        SingleLinked.Node processNode = originNode.getHead();
        if(posi==0){
            originNode.setHead(processNode.getNext());
            int size = originNode.getSize();
            originNode.setSize(size-1);
        }else{
            int tempCount = 1;
            while(tempCount!=posi){
                processNode = processNode.getNext();
                tempCount++;
            }
            processNode.setNext(processNode.getNext().getNext());

            int size = originNode.getSize();
            originNode.setSize(size-1);
        }
        System.out.println("删除后的链表为");
        originNode.disPlay();
    }

    private static int compareResult(SingleLinked.Node head1, SingleLinked.Node head2) {
        int head1Data = Integer.parseInt(String.valueOf(head1.getData()));
        int head2Date = Integer.parseInt(String.valueOf(head2.getData()));
        int result = Ints.compare(head1Data, head2Date);
        return result == 0 ? 0 : result > 0 ? 1 : -1;
    }


}
