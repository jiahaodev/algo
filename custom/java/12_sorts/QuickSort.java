package sorts;

/**
 * Created by JiahaoWu on 2018/10/16.
 */
public class QuickSort {

    // 快速排序，a是数组，n表示数组的大小
    public static void quickSort(int[] a, int n){
        quickSortInternally(a, 0, n-1);
    }

    private static void quickSortInternally(int[] a, int p, int r){
        if(p >= r) return;
        int q = partition(a,p,r); // 获得分区点
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }

    //分治排序实现1
    private static int partition(int[] a, int p, int r){
        int pivot = a[r];
        int i = p;
        for(int j = p; j < r; j++){
            if (i == j) {
                i++;
            }else{
                int tmp = a[i];
                a[i++] = a[j];
                a[j] = tmp;
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        return i;
    }


    //分治排序实现2
    public static int divide(int[] arr, int start, int end)
    {
        int tmp = arr[start]; //base值，如果是用start，则最后start；end同理。
        while (start < end)
        {
            while (start < end && arr[end] > tmp)
            {
                end--;
            }
            arr[start] = arr[end];
            while (start < end && arr[start] <= tmp)
            {
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = tmp;

        return start;
    }

}
