package interview.suanfa.prac;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/6/14<p>
// 链表上线栈
//-------------------------------------------------------
public class StackLinkedList {
    private SingleLinkedList singleLinkedList;

    public StackLinkedList() {
        this.singleLinkedList = new SingleLinkedList();
    }
    //添加元素
    public void push(Object object){
        singleLinkedList.addHead(object);
    }

    //弹出
    public Object pop(){
        Object object = singleLinkedList.deleteHead();
        return object;
    }

    //判断是否为空
    public boolean isEmpty(){
        return singleLinkedList.isEmpty();
    }

    public static void main(String[] args) {
        StackLinkedList statckList = new StackLinkedList();
        statckList.push("A");
        statckList.push("B");
        System.out.println("弹出元素==>"+statckList.pop());
    }
}
