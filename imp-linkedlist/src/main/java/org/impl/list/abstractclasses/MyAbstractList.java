package org.impl.list.abstractclasses;

import org.impl.list.exception.ListIndexOutOfBounds;

import java.util.Iterator;

public abstract class MyAbstractList<E> {
    protected E[] objects;
    protected int size;

    protected MyAbstractList() {}
    protected MyAbstractList(E[] objects) {
        this.objects = objects;
    }
    public abstract void add(int index, E e) throws ListIndexOutOfBounds;

    public abstract void add(E e);

    public abstract E remove(int index) throws ListIndexOutOfBounds;

    public abstract void clear();

    public abstract boolean contains(E e);

    public abstract E get(int index) throws ListIndexOutOfBounds;

    public abstract int indexOf(E e);

    public abstract int lastIndexOf(E e);

    public abstract E set(int index, E e) throws ListIndexOutOfBounds;

    public int getSize() {
        return size;
    }

    public abstract Iterator<E> iterator();
}
