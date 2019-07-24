package queue;

/**
 * Created by JiahaoWu on 2018/10/9.
 *  循环队列: 由于判断队满条件为： (tail + 1)%n == head . 所以会浪费一个位置的存储空间
 *     【因为 head == tail ，是用来判断队列是否为空的条件，所以不能够为 (tail) %n == head】
 */
public class CircularQueue {
    public String[] items;
    private int n = 0; //容量
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity){
        items = new String[capacity];
        n = capacity;
    }

    //入队
    public boolean enqueuee(String item){
        //tail == n表示队列已满
        // if(tail == n) return false;
        if((tail + 1)%n == head) return false; //有变化
        items[tail] = item;
        // tail++;
        tail = (tail + 1) % n; //有变化，防止“溢出”
        return true;
    }

    //出队
    public String dequeue(){
        //如果head == tail ,表示队列为空
        if( head == tail) return null; //判断 “ 队空”条件保持不变 
        String ret = items[head];
        // head++;
        head = (head + 1) % n; //有变化，防止溢出
        return ret;
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
