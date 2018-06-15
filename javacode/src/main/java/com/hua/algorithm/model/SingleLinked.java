package com.hua.algorithm.model;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/6/15<p>
// -------------------------------------------------------
public class SingleLinked {
    private int size;

    private Node head;

    public SingleLinked() {
        this.size = 0;
        this.head = null;
    }

    /**
     * 头部添加元素
     * */
    public Object addHead(Object data) {
        if (data == null) {
            return null;
        }
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        return head.data;
    }

    /**
     * 头部删除元素
     * */
    public Object delHead() {
        if (isEmpty()) {
            return null;
        }
        Object data = head.data;
        head = head.next;
        return data;
    }

    /**
     * 尾部添加元素,返回元链表长度
     * */
    public int addTail(Object data){
        if(data==null){
            return size;
        }
        Node newNode = new Node(data);
        if(size==0){
            head = newNode;
            size++;
            return size;
        }
        Node cur = head;
        while(null!=cur.next){
            cur = cur.next;
        }
        cur.next = newNode;
        size++;
        return size;
    }

    /**
     * 查找元素
     * */
    public Object find(Object targetData) {
        if (targetData == null || size == 0) {
            return null;
        }
        int tempSize = size;
        Node cur = head;
        while (tempSize > 0) {
            if (cur.data == targetData) {
                return targetData;
            } else {
                cur = cur.next;
            }
            tempSize--;
        }
        return null;

    }

    /**
     * 删除元素
     * */
    public boolean delObject(Object target) {
        if (target == null || size == 0) {
            return false;
        }
        Node preNode = head;
        Node curNode = head;
        while (curNode.data != target) {
            if (curNode.next == null) {
                return false;
            } else {
                preNode = curNode;
                curNode = curNode.next;
            }
        }
        if (curNode == head) {
            size--;
            head = curNode.next;
        } else {
            size--;
            preNode.next = curNode.next;
        }
        return true;
    }

    /**
     * 输出list
     * */
    public void disPlay(){
        if(size==0){
            return;
        }
        int tempSize = size;
        Node cur = head;
        while(tempSize>0){
            if(cur.equals(head)){
                System.out.printf(cur.data+"-->");
            }else if(cur.next==null){
                System.out.printf(cur.data.toString());
            }else{
                System.out.printf(cur.data+"-->");
            }
            cur = cur.next;
            tempSize--;
        }
    }

    /**
     * 判断为空
     * */
    public boolean isEmpty() {
        return size == 0;
    }

    // --------------------- Change Logs----------------------
    // <p>@author ruirui.qu Initial Created at 18/6/15<p>
    // -------------------------------------------------------
    public class Node {
        private Object data;

        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public static void main(String[] args) {
        SingleLinked singleLinked = new SingleLinked();
        singleLinked.addHead("A");
        singleLinked.addHead("B");
        singleLinked.addHead("C");
        singleLinked.addHead("D");

        System.out.println("显示链表");
        singleLinked.disPlay();


        SingleLinked singleLinked2 = new SingleLinked();
        singleLinked2.addTail("A");
        singleLinked2.addTail("B");
        singleLinked2.addTail("C");
        singleLinked2.addTail("D");

        System.out.println("显示链表");
        singleLinked2.disPlay();
    }

}
