package chapter02.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 7, 6, 5, 4, 3, 2, 1};
        merge(arr, 0, 7);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 递归merge
     */
    private static void merge(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        //计算中间index
        int mid = l + (r - l) / 2;
        merge(arr, l, mid);
        merge(arr, mid + 1, r);
        mergeArr(arr, l, mid, r);
    }

    private static void mergeArr(int[] arr, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int[] temp = new int[r - l + 1];
        int k = 0;
        //比较左侧数组和右侧数组的大小，并依次放入临时数组
        while (i <= mid && j <= r) {
            if (arr[j] < arr[i]) {
                temp[k++] = arr[j++];
            } else {
                temp[k++] = arr[i++];
            }
        }

        int start = i;
        int end = mid;
        if (j <= r) {
            start = j;
            end = r;
        }
        //将剩余的数组放入到temp中
        while (start <= end) {
            temp[k++] = arr[start++];
        }

        //将temp合并到arr
        for (i = 0; i <= r - l; i++) {
            arr[i + l] = temp[i];
        }

    }

}
