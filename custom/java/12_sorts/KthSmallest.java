package sort;

/**
 * @author JiahaoWu
 * @since 2019-03-10
 */
public class KthSmallest {

    public static int kthSmallest(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            return -1;
        }

        int partition = partition(arr, 0, arr.length - 1);
        while (partition + 1 != k) {
            if (partition + 1 < k) {
                partition = partition(arr, partition + 1, arr.length - 1);
            } else {
                partition = partition(arr, 0, partition - 1);
            }
        }

        return arr[partition];
    }

    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];

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

        swap(arr, i, r);

        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
