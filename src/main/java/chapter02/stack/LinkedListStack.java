package chapter02.stack;

import java.util.LinkedList;

/**
 * @author wangmj
 **/
public class LinkedListStack<E> {
    private LinkedList<E> linkedList;
    private int size;

    public LinkedListStack() {
        linkedList = new LinkedList();
    }

    public boolean push(E e) {
        linkedList.add(e);
        size++;
        return true;
    }

    public E pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("no element");
        }
        E e = linkedList.getLast();
        linkedList.removeLast();
        size--;
        return e;
    }
}
