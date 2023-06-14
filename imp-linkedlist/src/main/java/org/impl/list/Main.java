package org.impl.list;

import org.impl.list.concrete.MyLinkedList;
import org.impl.list.exception.ListIndexOutOfBounds;

public class Main {
    public static void main(String[] args) throws ListIndexOutOfBounds {
        MyLinkedList<String> list = new MyLinkedList<String>();

        // add elements to the list
        list.add("America");
        list.add(0, "Canada");
        list.printElements();
        System.out.print(list.getSize());
    }
}