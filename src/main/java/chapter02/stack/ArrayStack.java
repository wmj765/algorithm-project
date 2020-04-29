package chapter02.stack;

/**
 * @author wangmj
 **/
public class ArrayStack {
    private int size;
    private String[] arr;
    private int n;

    public ArrayStack(int n) {
        arr = new String[n];
        this.n = n;
    }

    public boolean push(String value){
        if (n > size) {
            throw new IndexOutOfBoundsException("out of stack size");
        }
        if (n == size) {
            return false;
        }
        arr[size - 1] = value;
        size++;
        return true;
    }

    public String pop() {
        if (size < 0) {
            throw new IndexOutOfBoundsException("out of stack size");
        }
        String value = arr[size - 1];
        size--;
        return value;
    }
}
