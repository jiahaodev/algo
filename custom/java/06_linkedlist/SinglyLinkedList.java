package linkedlist;

/**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 *
 * Author：JiahaoWu
 */
public class SinglyLinkedList {

    public static class Node{
        private int data;
        private Node next;
        public Node(int data,Node next){
            this.data = data;
            this.next = next;
        }
        public int getData(){
            return data;
        }
    }

    private Node head = null;

    public Node findByValue(int value){
        Node p = head;
        while(p!=null && p.data！= value){
            p = p.next;
        }
        return p;
    }

    public Node findByIndex(int index){
        Node p = head;
        int pos = 0;
        while(p!= null && pos!= index){
            p = p.next;
            ++pos;
        }
        return p;
    }

    public void insertToHead(int value){
        Node newNode = new Node(value,null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode){
        if (head == null) {
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertTail(int value){
        Node newNode = new Node(value,null);
        insertTail(newNode);
    }

    public void insertTail(Node newNode){
        if(head == null){
            head = newNode;
        }else{
            Node q = head;
            while(q.next != null){
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    //在p节点之后
    public void insertAfter(Node p, int value){
        Node newNode = new Node(value,null);
        insertAfter(p,newNode);
    }

    public void insertAfter(Node p, Node newNode){
        if(p == null) return;

        newNode.next = p.next;
        p.next = newNode;
    }

    //在p节点之前
    public void insertBefore(Node p,int value){
        Node newNode = new Node(value,null);
        insertBefore(p,newNode);
    }

    public void insertBefore(Node p, Node newNode){
        if(p==null) return;
        if (head == p) {
            insertToHead(newNode);
            return;
        }
        Node q = head;
        while(q!=null && q.next!=p){
            q = q.next;
        }
        if(q == null){
            return;
        }
        newNode.next = p;//先接手
        q.next = newNode;
    }


    public void deleteByNode(Node p){
        if( p==null || head) return;

        if (p == head) {
            head = head.next;
            return;
        }

        Node q = head;
        while(q != null && q.next != p){
            q = q.next;
        }

        if (q == null) {
            return;
        }

        q.next = q.next.next;
    }

    public void deleteByValue(int value){
        if(head == null) return;
        Node p = head;
        Node q = null;
        while(p != null && p.data != value){
            q = p; //用来记录前继节点
            p = p.next;
        }
        if(p == null) return;
        if(q == null){
            head = head.next;
        }else{
            q.next = q.next.next;
        }

        //可重复删除指定value的代码
        /*
        if (head != null && head.data == value) {
            head = head.next;
        }
        Node pNode = head;
        while(pNode!=null){
            if (pNode.next！= null && pNode.next.data == data) {  //预读取下一个节点的值
                pNode.next = pNode.next.next; //如果符合，删除下一个节点
                continue;
            }
            pNode = pNode.next; //不符合，则继续往下走
        }
        */
    }

    public void printAll(){
        Node p = head;
        while(p!=null){
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public boolean TFResult(Node left,Node right){
        Node l = left;
        Node r = right;
        while(l != null && r != null){
            if (l.data == r.data) {
                l = l.next;
                r = r.next;
                continue;
            }else{
                break;
            }
        }
        if (l == null && r == null) {
            return true;
        }else{
          return false;
        }
    }

    //判断是否为回文
    public boolean palindrome(){
        if (head == null) 
            return false;

        Node p = head; //慢指针
        Node q = head; //快指针
        if (p.next == null) {
            return true;//只有一个节点
        }
        while(q.next != null && q.next.next != null){
            p = p.next;
            q = q.next.next;
        }

        Node leftLink = null;
        Node rightLink = null;
        if (q.next == null) {
            //p 一定为整个链表的重点，且节点数目为奇数
            rightLink = p.next;
            leftLink = inverseLinkList(p).next;
        }else{
            //p、q均为中点
            rightLink = p.next;
            leftLink = inverseLinkList(p);
        }
        return TFResult(leftLink,rightLink);
    }

    //无头节点的链表翻转
    public Node inverseLinkList(Node p){
        Node pre = null;
        Node next = null;
        Node r = head;
        while( r != p){
            next = r.next;

            r.next = pre;
            pre = r;
            r = next;
        }
        r.next = pre;

        return r;
    }



    public static void main(String[] args){
      SinglyLinkedList link = new SinglyLinkedList();
      int[] data  = {1,2,5,3,1};
      for (int i = 0; i < data.length ;i++ ) {
        link.insertTail(data[i]);
      }
    }


}
