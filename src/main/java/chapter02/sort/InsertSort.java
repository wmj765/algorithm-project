package chapter02.sort;

/**
 * 插入排序
 * 核心思想：分为两个区域，已排序区域和未排序区域
 * 对已排序的最后一个元素和未排序的第一个元素进行比较，当满足交换位置时，先交换位置，再依次遍历已排序元素，找到元素需要插入的位置
 *
 * 当数据量小的时候或者数据有序度较高的时候插入排序特别高效
 *
 * @author wangmj
 **/
public class InsertSort {
    public static void main(String[] args) {
        int arr[] = {3, 4, 44, 1, 33, 9, 0, 35, 11, 7, 3};
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (value < arr[j]) {
                    //将大值元素向后移一位
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
                //最后将元素插入
                arr[j] = value;
            }
        }
        PrintArr.printArr(arr);

    }


}



