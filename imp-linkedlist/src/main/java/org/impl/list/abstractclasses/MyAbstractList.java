package org.impl.list.abstractclasses;

public abstract class MyAbstractList<E> {

    public abstract void add(int index, E e);

    public abstract E remove(int index);

    public abstract void clear();

    public abstract boolean contains(E e);

    public abstract E get(int index);

    public abstract int indexOf(E e);

    public abstract int lastIndexOf(E e);

    public abstract E set(E e);
}
