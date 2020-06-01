package chapter02.sort;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {2,1,3,5,6,9,8};
        merge(arr,0,6);
    }

    public static void merge(int[] arr,int l,int n){
        System.out.println(l+","+n);
        if (l >= n) {
            return;
        }
        int mid = (l + n) / 2;
        merge(arr, l, mid);
        merge(arr, mid + 1, n);
        System.out.println("xxxxxxxx");

    }


}
