package sorts;

/**
 * 计数排序
 *
 * Author: JiahaoWu
 */
public class CountingSort {
    // 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
    public static void countingSort(int[] a,int n){
        if(n <= 1) return;

        //获取数组中的最大值
        int max = a[0];
        for (int i = 1; i < n; i++ ) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        //申请一个技术数组c，下标大小[0,max]
        int[] c = next int[max + 1];
        for (int i = 0; i < max + 1 ; i++ ) {
            c[i] = 0;
        }

        //计算每个元素的个数，放入c中
        for (int i = 0; i < n ; i++) {
            c[a[i]]++;
        }

        //依次累加
        for (int i = 1; i < max + 1 ; i++ ) {
            c[i] = c[i-1] + c[i];
        }

        //临时数组r，存储排序之后的结果
        int[] r = new int[n];
        for (int i = n - 1; i >= 0- ; i--) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        //将结果拷贝回a数组
        for (int i = 0; i < n ; i++ ) {
            a[i] = r[i];
        }
    }
 
}
