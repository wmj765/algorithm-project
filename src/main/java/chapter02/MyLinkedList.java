package chapter02;

import com.sun.glass.events.mac.NpapiEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * 单链表
 *
 * @author wangmj
 **/
public class MyLinkedList<T> {

    private Node head;
    private int size;


    public void add(T data) {
        if (head == null) {
            head = new Node(data,null);
        } else {
            Node n = head;
            while (n.next != null) {
                n=n.next;
            }
            n.next = new Node(data, null);
        }
        size++;
    }

    public void insertTail(T data) {
    }

    public int size(){
        return this.size;
    }

    public boolean hasNext() {
        return head != null
                && head.next != null;
    }

    public void next(){
        head = head.next;
    }

    public void printList() {
        Node n = head;
        if (hasNext()) {
            System.out.println(head.data + "->" + head.next.data);
            this.next();
        }
    }


    class Node {
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }

    public boolean palindrome(){
        return false;
    }


}
