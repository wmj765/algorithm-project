package chapter02.linkedlist;

import chapter02.linkedlist.MyLinkedList;

/**
 * @author wangmj
 **/
public class Test {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<String>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.printList();

        linkedList.reverse();

        MyLinkedList reverseList = linkedList.reverseNodeWithList();
        reverseList.printList();

    }
}
