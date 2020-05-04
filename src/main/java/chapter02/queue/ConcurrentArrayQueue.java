package chapter02.queue;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 并发安全的队列
 *
 * @author wangmj
 **/
public class ConcurrentArrayQueue {

    //头指针index
    private AtomicInteger head;
    //尾指针index
    private AtomicInteger tail;
    //数组大小
    private int capacity;
    //存放元素
    private String[] arr;

    /**
     * 初始化一个容量为n的队列
     *
     * @param capacity 容量
     */
    public ConcurrentArrayQueue(int capacity) {
        arr = new String[capacity];
        this.capacity = capacity;
    }

    /**
     * 入队
     *
     * @param value 元素
     * @return 是否成功
     */
    public boolean enqueue(String value) {
        int temp = tail.get() + 1;
        for (; ; ) {
            if (tail.compareAndSet(tail.get(), temp)) {
                arr[tail.get()] = value;
                tail.incrementAndGet();
                break;
            }
        }
        return true;
    }

//    public void printQueue() {
//        StringBuilder sb = new StringBuilder();
//        for (int i = head; i < tail; i++) {
//            sb.append(arr[i]);
//        }
//        System.out.println("队列中元素为" + sb.toString() + ",head=" + head + ",tail=" + tail);
//    }
//
//    /**
//     * 出队
//     *
//     * @return 队头的元素
//     */
//    public String dequeue() {
//        if (head == tail) {
//            throw new IndexOutOfBoundsException("队列中已没有元素");
//        }
//        String value = arr[head];
//        head++;
//        return value;
//    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        ConcurrentArrayQueue arrayQueue = new ConcurrentArrayQueue(10);
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(String.valueOf(i));
            System.out.println(i + "入队");
        }
//        arrayQueue.printQueue();
//
//        for (int i = 0; i < 6; i++) {
//            System.out.println(arrayQueue.dequeue() + "出队");
//        }
//        arrayQueue.printQueue();
//
//        for (int i = 0; i < 10; i++) {
//            arrayQueue.enqueue(String.valueOf(i));
//            System.out.println(i + "入队");
//        }
//        arrayQueue.printQueue();
    }
}
