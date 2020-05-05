package chapter02.queue;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 并发安全的队列
 *
 * @author wangmj
 **/
public class ConcurrentArrayQueue {

    //头指针index
    private volatile int head;
    //尾指针index
    private volatile int tail;

    private final ReentrantLock lock;
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
        lock = new ReentrantLock();
    }

    /**
     * 入队
     *
     * @param value 元素
     * @return 是否成功
     */
    public boolean enqueue(String value) {
        try {
            lock.lock();
            if (tail == capacity) {
                return false;
            }
            System.out.print("tail=" + tail + ",");
            arr[tail] = value;
            tail += 1;
            return true;
        } finally {
            lock.unlock();
        }
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
        try {
            lock.lock();
            if (head == tail) {
                throw new IndexOutOfBoundsException("队列中已没有元素");
            }
            String value = arr[head];
            head++;
            System.out.print(value);
            return value;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 测试
     */
    public static void main(String[] args) throws InterruptedException {
        ConcurrentArrayQueue arrayQueue = new ConcurrentArrayQueue(1000);
        //20 个线程同时并发入队，tail 正常位移则说明线程安全
        for (int i = 1; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    arrayQueue.enqueue(String.valueOf(j));
                }
            }).start();
        }

        //sleep 2s，让所有线程执行完成
        Thread.sleep(2000);
        //打印队列结果
        arrayQueue.printQueue();

        //出队，与入队顺序相同则线程安全
        for (int i = 1; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    //不能在此打印出队元素对比，因为在这没有线程保护不安全，为了对比将打印结果放到dequeue方法里面
                    String dequeue = arrayQueue.dequeue();
//                    System.out.println(dequeue);
                }
            }).start();
        }


    }
}
