package queue;

/**
 * Created by JiahaoWu on 2018/10/9.
 * 相较 ArrayQueue： 添加了队列占满时的数据迁移操作
 * 这里的数据迁移是指：往前搬移数据，重新占满已经出队的空间
 */
public class DynamicArrayQueue {
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
        // items[tail] = item;
        // tail++;

        //新的操作方式
        if(tail == n){
            if(head == 0) return false;
            //数据搬移
            for(int i = head; i < tail; i++){
                items[i-head] = item[i];
            }
            // 搬移完成后，重新更新head和tail
            tail -= head;
            head = 0;
        }

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
