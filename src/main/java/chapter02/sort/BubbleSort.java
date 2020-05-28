package chapter02.sort;

/**
 * 冒泡排序
 * 核心思想：两两比较并做交换
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 8, 12, 1, 2, 10};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            printArr(arr);
            System.out.println();
        }
    }

    private static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}
