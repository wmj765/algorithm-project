package chapter02.sort;

/**
 * 二分查找
 *
 * @author wangmj
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 1, 4, 6, 7, 7, 7, 7, 7, 7, 80, 87, 89};
        int target = 1;
        System.out.println(binarySearchFirstElement(arr, target));
    }

    /**
     * find the element equals with target
     *
     * @param arr    arr
     * @param target target element
     * @return index of the element which is equals with target
     */
    public static int simpleBinarySearch(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
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

    /**
     * find the first element equals with target
     *
     * @param arr    arr
     * @param target target element
     * @return first index of the element which is equals with target
     */
    public static int binarySearchFirstElement(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] == target) {
                if (mid != 0 && arr[mid - 1] == target) {//continue to find the element if it is not the first index
                    j = mid - 1;
                } else {
                    return mid;
                }
            } else if (arr[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }
}
