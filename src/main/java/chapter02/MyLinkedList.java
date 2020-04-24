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
            head = new Node(data, null);
        } else {
            Node n = head;
            while (n.next != null) {
                //将head的尾部地址指向n
                n = n.next;
            }
            //将n的next赋值新值，即head的尾部的next也赋值成了新值，完成添加
            n.next = new Node(data, null);
        }
        size++;
    }

    public int size() {
        return this.size;
    }

    public boolean hasNext() {
        return head != null
                && head.next != null;
    }


    public void next() {
        head = head.next;
    }

    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.print("->");
            System.out.print(n.data);
            n = n.next;
        }
        System.out.println();
    }


    public boolean palindrome() {
        return false;
    }

    private Node revertNodeWithList(Node n){
        List<T> list = new ArrayList<T>();
        Node p = n;
        while (p != null) {
            list.add(p.data);
            p = p.next;
        }
        Node result = null;
        Node tail = null;
        for (int i = list.size() - 1; i > 0; i--) {

        }
        return n;
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


}
