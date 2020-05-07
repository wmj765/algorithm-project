package chapter02.queue;

/**
 * @author wangmj
 **/
public class LinkedQueue<T> {
    //头指针index
    private Node head;
    //尾指针index
    private Node tail;

    public LinkedQueue() {
        this.head = new Node<T>();
    }

    /**
     * 入队
     *
     * @param value 元素
     * @return 是否成功
     */
    public boolean enqueue(T value) {
        return true;
    }

    class Node <T>{
        private Node next;
        private T value;
    }
}
