package chapter02.sort;

/**
 * 归并排序
 *
 * @author wangmj
 **/
public class MergeSort {
    public static void main(String[] args) {
        merge(10, 12, "origin");
    }

    static void merge(int i, int j, String text) {
        System.out.println(i + "," + j + "," + text);
        if (i >= j) {
            return;
        }
        merge(++i, j, "first");
        merge(i + 10, j + 10, "second");
    }
}
