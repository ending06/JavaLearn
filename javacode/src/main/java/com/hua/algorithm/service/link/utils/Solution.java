package com.hua.algorithm.service.link.utils;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int data) {
        this.val = data;
        this.next = null;
    }
}

public class Solution {

    /**
     * 删除链表中某个节点
     * */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        ListNode cur = head;
        ListNode pre = newNode;
        while (cur != null) {
            if (cur.val == val) {
                if (cur.next == null) {
                    pre.next = null;
                    break;
                } else {
                    ListNode temp = cur.next;
                    pre.next = temp;
                    cur.next = null;
                    cur = temp;
                }
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 奇偶排数
     * */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 奇数头节点
        ListNode oddHead = null;
        // 奇数尾节
        ListNode oddLast = null;

        // 偶数头结点
        ListNode evenHead = null;
        // 偶数尾节点
        ListNode evenLast = null;

        int count = 1;
        while (head != null) {
            if (count % 2 != 0) {
                if (oddHead == null) {
                    oddHead = head;
                    oddLast = head;
                } else {
                    oddLast.next = head;
                    oddLast = oddLast.next;
                }
            } else {
                if (evenHead == null) {
                    evenHead = head;
                    evenLast = head;
                } else {
                    evenLast.next = head;
                    evenLast = evenLast.next;
                }

            }
            count++;
            ListNode temp = head.next;
            head.next = null;
            head = temp;
        }
        oddLast.next = evenHead;
        return oddHead;
    }

    /**
     * 是否是回文链表
     * */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        if (length == 1) {
            return true;
        }
        if (length == 2) {
            if (head.val != head.next.val) {
                return false;
            }
            return true;
        }
        int secondPart = (length % 2 != 0) ? (length / 2 + 1) : (length / 2);
        ListNode first = head;
        ListNode second = null;
        ListNode temp = head;
        for (int i = 0; i < secondPart; i++) {
            temp = temp.next;
        }
        second = temp;

        // temp.next = null;

        second = reverse(second);

        while (second != null) {
            if (second.val != first.val) {
                return false;
            }
            second = second.next;
            first = first.next;
        }
        return true;
    }

    private ListNode reverse(ListNode second) {
        // second逆序
        ListNode pre = null;
        ListNode next = null;
        while (second != null) {
            next = second.next;
            second.next = pre;
            pre = second;
            second = next;
        }
        return pre;
    }

    /**
     * 合并链表
     * */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = l1.val < l2.val ? l1 : l2;
        ListNode other = l1.val >= l2.val ? l1 : l2;
        ListNode prevHead = head;
        ListNode prevOther = other;
        while (prevHead != null) {
            ListNode next = prevHead.next;
            if (next != null && next.val > prevOther.val) {
                prevHead.next = prevOther;
                prevOther = next;
            }
            if (prevHead.next == null) {
                prevHead.next = prevOther;
                break;
            }
            prevHead = prevHead.next;
        }
        return head;
    }

    /**
     * 链表相加，原链表是逆序的
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        int ci = 0;
        result = addNumbers(result,l1,l2,ci);
        return result;
    }

    private ListNode addNumbers(ListNode result,ListNode l1, ListNode l2,int ci) {
        if(l1==null&&l2==null){
            if(ci==0){
                return result;
            }
            ListNode newNode = new ListNode(ci);
            result = newNode;
            return result;
        }
        if(l1==null&&l2!=null){
            result = new ListNode((l2.val+ci)%10);
            ci = (l2.val+ci)/10;
            l2 = l2.next;
            result.next = addNumbers(result.next,null,l2,ci);
        }
        if(l2==null&&l1!=null){
            result = new ListNode((l1.val+ci)%10);
            ci = (l1.val+ci)/10;
            l1 = l1.next;
            result.next = addNumbers(result.next,l1,null,ci);
        }

        if (l1!=null&&l2!=null) {
            result = new ListNode((l1.val+l2.val+ci)%10);
            ci = (l1.val+l2.val+ci)/10;
            l1 = l1.next;
            l2 = l2.next;
            result.next = addNumbers(result.next,l1,l2,ci);
        }
        return result;
    }
    /**
     * 旋转链表
     * */
    public ListNode rotateRightWithComplex(ListNode head, int k) {
        if(head==null||head.next==null||(k==0)){
            return head;
        }
        for(int i=0;i<k;i++){
            move(head);
        }
        return head;
    }

    private void move(ListNode head) {
        ListNode cur = head.next;
        while(cur.next!=null){
            int temp = cur.val;
            cur.val = head.val;
            head.val = temp;
            cur = cur.next;
        }
        int temp = cur.val;
        cur.val = head.val;
        head.val = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(4);
        // ListNode node7 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node4.next = node5;
        //node5.next = node6;
        //node6.next = node7;
/*        System.out.println(node4);
        solution.reverse(node4);

        boolean result = solution.isPalindrome(node1);
        System.out.println("head===>" + result);*/
        //solution.addTwoNumbers(node1,node4);

        solution.rotateRightWithComplex(node1,2);
    }
}
