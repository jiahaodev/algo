package queue;

/**
 * Created by JiahaoWu on 2018/10/9.
 * 说明：数组实现的队列中，head指向的是队首的位置，tail则会指向最后一个入队的位置的“ 下一位“
 */
// 用数组实现的队列
public class ArrayQueue {

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
        if(tail == n) return false;
        items[tail] = item;
        tail++;
        return true;
    }

    //出队
    public String dequeue(){
        //如果head == tail ,表示队列为空
        if( head == tail) return null;
        String ret = items[head];
        head++;
        return ret;
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
