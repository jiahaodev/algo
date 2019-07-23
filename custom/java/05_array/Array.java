package array;

/**
 * 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是int类型的；
 *
 * Author: JiahaoWu
 * 
 */
public class Array{
    private int data[];
    private int n;
    private int count;

    public Array(int capacity){
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
        //一开始一个数都没有存所以为0
        //如果存有m个数，则count  == m
    }

    //获取index处的元素，支持随机访问
    public int find(int index){
        if (!checkIndexValid(index)) 
            return -1;
        return data[index];
    }

    //在index处，添加元素value
    public boolean insert(int index,int value){
        if (count == n) {
            System.out.println("没有可插入的位置");
        }
        //这个判断有点特殊，因为可以插入到count的位置
        if (index < 0||index > count) {
            System.out.println("位置不合法");
            return false;
        }
        for (int i = count;i > index ;i-- ) {
            data[i] = data[i-1];
        }
        data[index] = value;
        count++;
        return true;
    }

    //删除index处元素
    public boolean delete(int index){
        if (!checkIndexValid(index))
            return false;
        for (int i = index + 1;i<count ;i++ ) {
            data[i-1] = data[i];  //思路：后一个位置覆盖前一个位置
        }
        count--;
        return true;
    }

    //检测位置的有效性
    private checkIndexValid(int index){
        if (index < 0 || index >= count) {
            return false;
        }
        return true;
    }

    public void printAll(){
        for (int i = 0;i<cout ;i++ ) {
            System.out.print(dat[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Array array = new Array(5);
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        //array.insert(3, 11);
        array.printAll();
    }
}