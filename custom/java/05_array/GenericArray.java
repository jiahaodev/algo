/**
 * 泛型数组，支持动态扩容,所以容量没有限制
 * Author: JiahaoWu
 * 
 */

public class GenericArray<T>{
    private T[] data;
    private int size;

    public GenericArray(int capacity){
        data = (T[])new Object[capacity];
        size = 0;
    }

    public GenericArray(){
        this(10);
    }

    public int getCapacity(){
        return data.length;
    }

    public int count(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void set(int index,T e){
        checkIndexForGet(index);
        data[index] = e;
    }

    public T get(int index){
        checkIndexForGet(index);
        return data[index];
    }

    public boolean contains(T e){
        int ret = find(T e);
        if(ret == -1) 
            return false;
        return true;
    }

    public int find(T e){
        for (int i = 0; i<size ;i++ ) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;        
    }

    public void add(int index,T e){
        checkIndex(index);
        //扩容
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size; i > index ; i --) {
            data[i] = data[i-1];
        }
        data[index] = e;
        size++;
    }

    // 向数组头插入元素
    public void addFirst(T e) {
        add(0, e);
    }

    // 向数组尾插入元素
    public void addLast(T e) {
        add(size, e);
    }

    public T remove(int index){
        checkIndexForGet(index);

        T ret = data[index];
        for (int i = index+1; i < size ; i++ ) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null; //可要可不要，因为通过size来限制访问了。

        //缩容
        if (size == data.length/4 && data.length/2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    // 删除第一个元素
    public T removeFirst() {
        return remove(0);
    }

    // 删除末尾元素
    public T removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除指定元素
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }


    //扩容
    private void resize(int capacity){
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0;i< size ;i++ ) {
            newData[i] = data[i];
        }
        data = newData;
    }

    //用于添加，设置
    private void checkIndex(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
        }
    }

    //用于获取/移除
    //移除是移除已经存在的实体，而data[size]还不存在，所以不能移除
    private void checkIndexForGet(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index < size.");
        }
    }

}