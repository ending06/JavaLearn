package com.hua.algorithm.service.link.impl;

import com.hua.algorithm.model.SingleLinked;
import com.hua.algorithm.service.link.SingleLinkedService;
import com.google.common.primitives.Ints;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/6/15<p>
// -------------------------------------------------------
public class SingleLinkedServiceImpl implements SingleLinkedService {
    @Override
    public void findSameStrByOrderingLinked(SingleLinked a, SingleLinked b) {
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

    private int compareResult(SingleLinked.Node head1, SingleLinked.Node head2) {
        int head1Data = Integer.parseInt(String.valueOf(head1.getData()));
        int head2Date = Integer.parseInt(String.valueOf(head2.getData()));
        int result = Ints.compare(head1Data, head2Date);
        return result == 0 ? 0 : result > 0 ? 1 : -1;
    }

    public static void main(String[] args) {
        SingleLinked singleLinked = new SingleLinked();
        singleLinked.addTail(1);
        singleLinked.addTail(2);
        singleLinked.addTail(3);
        singleLinked.addTail(4);

        SingleLinked singleLinked2 = new SingleLinked();
        singleLinked2.addTail(2);
        singleLinked2.addTail(3);
        singleLinked2.addTail(4);

        findSameStrByOrderingLinked(singleLinked,singleLinked2);
    }
}
