package org.impl.list.concrete;

import org.impl.list.abstractclasses.MyAbstractList;
import org.impl.list.exception.ListIndexOutOfBounds;

import java.util.Iterator;

public class MyLinkedList<E> extends MyAbstractList<E> {

    private Node<E> head;
    private Node<E> tail;

    /**
     * default constructor
     */
    public MyLinkedList(){
    }

    public MyLinkedList(E[] objects) {
        super(objects);
    }

    /**
     *
     * @return first element in the list
     */
    public E getFirst() {
        if (size == 0) {
            return null;
        }
        return head.element;
    }

    /**
     *
     * @return The last element in the last
     */
    public E getLast() {
        if (size == 0) {
            return null;
        }
        return tail.element;
    }

    /**
     * add an element in the first position of the list
     * @param e
     */
    public void addFirst(E e) {
        if (head == null) {
            head = new Node<E>(e);
            tail = head;
        }
        else {
            Node<E> temp = head;
            head = new Node<E>(e);
            head.next = temp;
        }
        size++;
    }

    /**
     * Add an element at the end of this list
     * @param e
     */
    public void addLast(E e) {
        if (head == null) {
            head = new Node<E>(e);
            tail = head;
        }
        else {
            tail.next = new Node<E>(e);
            tail = tail.next;
        }
        size++;
    }
    public void add(int index, E e) throws ListIndexOutOfBounds {

        if (index < 0 || index > size) {
            throw new ListIndexOutOfBounds(String.format("Index: %d is out of bounds for list with size: %d", index, size));
        }
        if (head == null) {
            addFirst(e);
        }
        if (index == 0) {
            addFirst(e);
        }
        if (index == size-1) {
            addLast(e);
        }
        Node<E> currentNode = head;
        for (int i = 1; i < index; i++) {
            currentNode = currentNode.next;
        }
        Node<E> temp = currentNode.next;
        Node<E> newNode = new Node<E>(e);
        currentNode.next = newNode;
        newNode.next = temp;
        size++;
    }

    public void add(E e) {
        addLast(e);
    }

    /**
     * Remove the head node and
     * @return the object that is contained in the removed node
     */
    public E removeFirst() {
        if (head == null) {
            return null;
        }
        Node<E> current = head;
        if (head == tail) {
            head = tail = null;
            return current.element;
        }
        head = head.next ;
        size--;
        return current.element;
    }

    public E removeLast() {
        if (head == null) {
            return null;
        }
        Node<E> current = head;
        if (head == tail) {
            head = tail = null;
            return current.element;
        }
        while(current.next != tail) {
            current = current.next;
        }
        Node<E> removedEle = current.next;
        tail = current;
        size--;
        return removedEle.element;
    }

    public E remove(int index) throws ListIndexOutOfBounds {
        if (head == null) {
            return null;
        }
        if (index < 0 || index > size) {
            throw new ListIndexOutOfBounds(String.format("Index: %d is out of bounds for list with size: %d", index, size));
        }
        if (head == tail) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }
        Node<E> current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        Node<E> eleToBeRemoved = current.next;
        current.next = eleToBeRemoved.next;
        size--;
        return eleToBeRemoved.element;
    }

    public void clear() {
        size = 0;
        head = null;
    }

    /**
     *
     * @param e
     * @return true if this list contains the element e
     */
    public boolean contains(E e) {
        if (head == null) {
            return false;
        }
        Node<E> current = head;
        while (current != null) {
            if (current.element.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     *
     * @param index
     * @return the index of the head matching element
     * @throws ListIndexOutOfBounds
     */
    public E get(int index) throws ListIndexOutOfBounds {
        if (head == null) {
            return null;
        }
        if (index < 0 || index > size) {
            throw new ListIndexOutOfBounds(String.format("Index: %d is out of bounds for list with size: %d", index, size));
        }
        Node<E> current = head;
        for (int i=1; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    public int indexOf(E e) {
        if (head == null) {
            return -1;
        }
        int index = 0;
        Node<E> current = head;
        while (current != null) {
            if (current.element.equals(e)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(E e) {
        if (head == null) {
            return -1;
        }
        Node<E> current = head;
        int currIndex = 0;
        int index = -1;

        while (current != null) {
            if (current.element.equals(e)) {
                index = currIndex;
            }
            current = current.next;
            currIndex++;
        }
        return index;
    }

    public E set(int index, E e) throws ListIndexOutOfBounds {
        if (head == null) {
            return null;
        }
        if (index < 0 || index > size) {
            throw new ListIndexOutOfBounds(String.format("Index: %d is out of bounds for list with size: %d", index, size));
        }
        Node<E> current = head;
        for (int i=1; i < index; i++) {
            current = current.next;
        }
        E element = current.element;
        current.setElement(e);
        return element;
    }
    public void printElements() {
        Node<E> current = head;
        while(current != null) {
            System.out.println(current.element);
            current = current.next;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {

        private Node<E> current = head;
        public boolean hasNext() {
            return current.next != null;
        }
        public E next() {
            E element = current.element;
            current = current.next;
            return element;
        }
        public void remove() {
            Node<E> currNode = head;
            while(currNode.next != current) {
                currNode = currNode.next;
            }
            currNode.next = current.next;
            current = null;
            size--;
        }
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E element) {
            this.element = element;
        }
        public void setElement(E e) {
            this.element = e;
        }
    }
}
