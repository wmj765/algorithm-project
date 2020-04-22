package chapter02;

import java.util.ArrayList;
import java.util.List;

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

    }
}
