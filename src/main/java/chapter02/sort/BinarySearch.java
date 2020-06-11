package chapter02.sort;

/**
 * 二分查找
 *
 * @author wangmj
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 7, 12, 45, 67, 78, 79, 80, 87, 89};
        int target = 792;
        System.out.println(binarySearch(arr, target));
    }

    /**
     * 二分查找 注意终止条件为i<=j
     *
     * @param arr    数组
     * @param target 目标值
     * @return 数组位置
     */
    public static int binarySearch(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            System.out.println(i + "," + j);
            int mid = i + (j - i) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }
}
