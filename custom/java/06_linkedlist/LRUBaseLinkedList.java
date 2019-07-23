package linked.singlelist;


import java.util.Scanner;

/**
 * 基于单链表LRU算法（java）
 *
 * @author JiahaoWu
 * @create 2018-12-17
 */
public class LRUBaseLinkedList<T> {

    private final static Integet DEFAULT_CAPACITY = 10;

    private SNode<T> headNode;
    private Integer length;
    private Integer capacity;

    public LRUBaseLinkedList(Integer capacity){
        this.headNode = new SNode<T>();
        this.capacity = capacity;
        this.length = 0;
    }

    public LRUBaseLinkedList(){
        this(DEFAULT_CAPACITY);
    }

    public void add(T data){
        SNode preNode = findPreNode(data);
        //链表中存在，删除原数据，再插入到链表的头部
        if(preNode != null){
            deleteElemOptim(preNode);
            insertElemAtBegin(data);
        }else{
            //超过容量，则删除尾节点
            if (length>=this.capacity) {
                deleteElemAtEnd();
            }
            //插入到链表的头部
            insertElemAtBegin(data);
        }
    }

    //查找元素的前一个节点
    private SNode findPreNode(T data){
        SNode node = headNode;
        while(node.getNext() != null){
            if(data.equals(node.getNext().getElement())){
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    //删除preNode节点的下一个元素
    private void deleteElemOptim(SNode preNode){
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length -- ;
    }

    //删除尾节点
    private void deleteElemAtEnd(){
        SNode ptr = headNode;
        if (ptr.getNext() == null) {
            return;
        }
        //
        while(ptr.getNext().getNext() != null){
            ptr = ptr.getNext();
        }
        SNode temp = ptr.getNext();
        ptr.setNext(null);
        temp = null;
        length-- ;
    }

    //在链表头部插入节点
    private void insertElemAtBegin(T data){
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data,next));
        length++;
    }



    public void printAll(){
        SNode node = headNode;
        while(node!=null){
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public class SNode<T>{
        
        private T element;
        private SNode next;
        
        public SNode(T element){
            this.element = element;
        }

        public SNode(T element,SNode next){
            this.element = element;
            this.next = next;
        }

        public SNode(){
            this.next = null;
        }

        public T getElement(){
            return element;
        }

        public void setElement(T element){
            this.element = element;
        }
        
        public SNode getNext(){
            return next;
        }

        public void setNext(SNode next){
            this.next = next;
        }

    }

    public static void main(String[] args){
        LRUBaseLinkedList list = newe LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while(true){
            list.add(sc.nextInt());
            list.printAll();
        }
    }

}
