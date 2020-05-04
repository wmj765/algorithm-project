package chapter02.queue;

/**
 * @author wangmj
 **/
public class ArrayQueue {

    //头指针index
    private int head;
    //尾指针index
    private int tail;
    //数组大小
    private int capacity;
    //存放元素
    private String[] arr;

    /**
     * 初始化一个容量为n的队列
     *
     * @param capacity 容量
     */
    public ArrayQueue(int capacity) {
        arr = new String[capacity];
        this.capacity = capacity;
    }

    /**
     * 入队，当数据有空间且head不为0 tail指向尾部的时候先进行数据迁移，之后再次入队
     *
     * @param value 元素
     * @return 是否成功
     */
    public boolean enqueue(String value) {
        if (tail == capacity) {
            if (head == 0) {
                throw new IndexOutOfBoundsException("队列中已没有位置入队," + value + "入队失败");
            } else {
                System.out.println("数据进行搬移");
                int index = 0;
                //将队列元素进行搬移
                for (int i = head; i < tail; i++) {
                    arr[index] = arr[i];
                    index++;
                }
                tail = tail - head;
                head = 0;
                printQueue();
            }
        }
        arr[tail] = value;
        tail++;
        return true;
    }

    public void printQueue() {
        StringBuilder sb = new StringBuilder();
        for (int i = head; i < tail; i++) {
            sb.append(arr[i]);
        }
        System.out.println("队列中元素为" + sb.toString() + ",head=" + head + ",tail=" + tail);
    }

    /**
     * 出队
     *
     * @return 队头的元素
     */
    public String dequeue() {
        if (head == tail) {
            throw new IndexOutOfBoundsException("队列中已没有元素");
        }
        String value = arr[head];
        head++;
        return value;
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(String.valueOf(i));
            System.out.println(i + "入队");
        }
        arrayQueue.printQueue();

        for (int i = 0; i < 6; i++) {
            System.out.println(arrayQueue.dequeue() + "出队");
        }
        arrayQueue.printQueue();

        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(String.valueOf(i));
            System.out.println(i + "入队");
        }
        arrayQueue.printQueue();
    }
}
