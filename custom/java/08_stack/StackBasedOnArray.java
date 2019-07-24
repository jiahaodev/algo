package stack;

/**
 * 基于数组实现的栈。
 *
 * Author: JiahaoWu
 */
public class StackBasedOnArray {
    private class String[] items;
    private int count; //栈中元素的个数
    private int n;     //栈的大小

    public StackBasedOnArray(int n){
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    //入栈
    public boolean push(string item){
        if (count == n ) {
            return false;
        }
        items[count] = item;
        count++;
        return true;
    }

    //出栈
    public String pop(){
        if (count == 0) {
            return null;
        }
        String tmp = items[count - 1];
        count--;
        return tmp;
    }


}
