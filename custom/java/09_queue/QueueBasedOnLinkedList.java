package queue;

/**
 * 基于链表实现的队列
 *
 * Author: JiahaoWu
 * 说明：数组实现的队列中，head指向的是队首的位置，tail则会指向最后一个入队的位置的“ 下一位“。
         而基于链表实现的队列中，由于需要“操作实体”，改变尾节点的 -> next. 
         所以队尾必须指向最后插入的节点位置
 */
public class QueueBasedOnLinkedList {

    //队列的  队首 和 队尾
    private Node head = null;
    private Node tail = null;

    //入队
    public void enqueue(value){
        Node newNode = new Node(value,null);
        if (tail == null) {  //如果队尾为空，则表示当前为“队空”。重新初始化 首尾 节点数据
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = tail.next; 
        }
    }

    //出队
    public String dequeue(){
        if(head == null) return null;

        String value = head.data;
        head = head.next;
        if(head == null){
          //如果只剩最后一个节点时，那么head、tail应该是指向同个节点
          //如果不将tail置为null. 则入队时无法判断是否为“队空”
            tail = null; 
        }
        return value;
    }


    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node{
        private String data;
        private Node next;
        public Node(String data, Node next){
            this.data = data;
            this.next = next;
        }
    }

}
