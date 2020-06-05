package chapter02.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author wangmj
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8, 7, 6, 5, 4, 3, 2, 1, 11, 33, 32, 22, 10};
        quickSort(arr, 0, 12);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 获取分区位置点
     *
     * @return 分区位置点
     */
    private static int partition(int[] arr, int p, int r) {
        int q = arr[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (arr[j] < q) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        //交换arr[i] arr[r]
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
        return i;
    }

    /**
     * 快速排序
     *
     * @param arr 要排序的数组
     * @param p   数组起始位置
     * @param r   数组结束位置
     */
    private static void quickSort(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        //获取分区位置点
        int q = partition(arr, p, r);
        System.out.println("q=" + q + ",arr=" + Arrays.toString(arr));
        quickSort(arr, p, q - 1);
        quickSort(arr, q + 1, r);
    }
}
