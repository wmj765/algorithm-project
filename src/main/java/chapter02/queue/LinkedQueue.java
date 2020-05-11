package chapter02.queue;

/**
 * @author wangmj
 **/
public class LinkedQueue<T> {
    //头指针index
    private Node<T> head;
    //尾指针index
    private Node<T> tail;

    public LinkedQueue() {

    }

    /**
     * 入队
     *
     * @param value 元素
     * @return 是否成功
     */
    public boolean enqueue(T value) {
        Node node = new Node(value, null);
        if (head == null) {
            head = node;
            tail = head;
        }else {
            tail.next = node;
            tail = node;
        }
        return true;
    }

    public T dequeue(){
        if (head == null) {
            return null;
        }
        T value = head.value;
        head = head.next;
        return value;
    }

    class Node <T>{
        private Node next;
        private T value;

        public Node(T value,Node next) {
            this.next = next;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkedQueue<String> linkedQueue = new LinkedQueue<>();
        linkedQueue.enqueue("1");
        linkedQueue.enqueue("2");
        linkedQueue.enqueue("3");
        linkedQueue.enqueue("4");
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
    }
}
