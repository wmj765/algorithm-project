package chapter02.linkedlist;

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

    /**
     * 添加元素
     */
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

    public void reverse(){
        Node newNode = null;
        Node node = null;
        while (head != null) {
            //定义变量记录头指针
            node = head;
            //删除头指针
            head = head.next;
            //插入数据到新节点
            node.next = newNode;
            newNode = node;
        }
        head = newNode;
    }

    /**
     * 反转链表借助list，时间复杂度O(n) 空间复杂度O(n)
     */
    public MyLinkedList reverseNodeWithList() {
        List<T> list = new ArrayList<T>();
        Node p = this.head;
        while (p != null) {
            list.add(p.data);
            p = p.next;
        }
        MyLinkedList result = new MyLinkedList();
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
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
