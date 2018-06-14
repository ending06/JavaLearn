package interview.suanfa.prac;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/6/14<p>
// -------------------------------------------------------
public class SingleLinkedList {
    private int size;// 节点个数
    private Node head;

    public SingleLinkedList() {
        this.size = 0;
        this.head = null;
    }

    private class Node {
        // 数据
        private Object data;
        // 下一个节点
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    // 添加元素
    public Object addHead(Object object) {
        Node newHead = new Node(object);
        if (size == 0) {
            head = newHead;
        } else {
            newHead.next = head;
            head = newHead;
        }
        size++;
        return object;
    }

    // 在表头删除元素
    public Object deleteHead() {
        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    // 查找指定节点，不存在返回null
    public Object find(Object object) {
        if (object == null) {
            return null;
        }
        Node cur = head;
        int tempSize = size;
        while (tempSize > 0) {
            if (cur.equals(object)) {
                return object;
            } else {
                cur = cur.next;
            }
            tempSize--;
        }
        return null;
    }

    public boolean delObject(Object object) {
        if (object == null || size == 0) {
            return false;
        }
        Node preNode = head;
        Node curNode = head;
        while (curNode.data != object) {
            if (curNode.next == null) {
                return false;
            } else {
                preNode = curNode;
                curNode = curNode.next;
            }
        }
        // 如果删除的是第一个节点
        if (curNode == head) {
            head = curNode.next;
            size--;
        } else {
            preNode.next = curNode.next;
            size--;
        }
        return true;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    //显示节点
    public void disPlay(){
        if(size>0){
            Node node = head;
            int tempSize = size;
            if(tempSize==1){
                System.out.println(";" + node.data);
                return;
            }
            while(tempSize>0){
                if(node.equals(head)){
                    System.out.println(";"+node.data);
                }else if(node.next==null){
                    System.out.println(";"+node.data);
                    return;
                }else{
                    System.out.println(";" + node.data);
                }
                node = node.next;
                tempSize--;
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addHead("A");
        singleLinkedList.addHead("B");
        singleLinkedList.addHead("C");
        singleLinkedList.addHead("D");

        System.out.println("显示链表");
        singleLinkedList.disPlay();

        System.out.println("删除头结点");
        singleLinkedList.deleteHead();

        System.out.println("删除C节点");
        singleLinkedList.delObject("C");

        System.out.println("最终链表数据为");
        singleLinkedList.disPlay();
    }
}
