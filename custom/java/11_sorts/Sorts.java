package sorts;

import java.util.Arrays;

/**
 * 冒泡排序、插入排序、选择排序
 * 
 * Author: JiahaoWu
 */
public class Sorts {
    // 冒泡排序，a是数组，n表示数组大小
    public static void bubbleSort(int[] a, int n){
        if(n <= 1) return;
        for (int i = 0; i < n; i++ ) {
            boolean flag = false; //提前退出标记为
            for (int j = 0; j < n - i - 1; j++ ) {
                if (a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;
                }
            }
            if(!flag) break;
        }
    }

    /**
     * 冒泡排序改进:在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界,
     * 对于边界外的元素在下次循环中无需比较.
     *
     *需要lastExchange 跟 sortBorder两个变量的原因，sortBorder作为for循环的判断条件，如果直接用于记录j的值，则会引起循环判断的混乱。
     */ 
    public static void bubbleSort(int[] a, int n){
        if(n <= 1) return;
        //最后一次交换的位置
        int lastExchange = 0;
        int sortBorder = n - 1; 
        for (int i = 0; i < n; i++ ) {
            boolean flag = false; //提前退出标记为
            for (int j = 0; j < sortBorder; j++ ) {
                if (a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;
                    //更新最后一次交换的位置
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if(!flag) break;
        }
    }

    //插入排序
    public static void insertionSort(int[] a,int n){
        if(n <= 1) return;

        for(int i = 1; i < n; i++){
            int value = a[i];
            int j = i - 1;
            for(; j >= 0;j--){
                if (a[j] > value) {
                    a[j+1] = a[j];
                }
            }
            a[j+1] = value;
        }
    }
   
    //选择排序，a表述数组，n表示数组中大小
    public static void selectionSort(int[] a, int n){
        if( n <= 1) return;
        for (int i = 0;i < n - 1 ; i++ ) {
            //查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n ; j++ ) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            //交换
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }



    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        bubbleSort2(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
