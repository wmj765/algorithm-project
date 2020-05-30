package chapter02.sort;

/**
 * 选择排序
 * 核心思想，每次遍历找到最小元素 并将最小元素和遍历的第一个元素交换位置
 *
 * @author wangmj
 **/
public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {3, 4, 44, 1, 33, 9, 0, 35, 11, 7, 3};
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
        PrintArr.printArr(arr);
    }
}
