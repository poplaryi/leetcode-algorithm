package com.yangyi.code.data;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> {

    /**
     * 数组
     */
    private Object[] elementData;
    /**
     * 默认长度
     */
    private static final int DEFAULT_SIZE = 10;
    /**
     * 元素统计
     */
    private int elementCount;

    /**
     * 容量增加量
     */
    private int capacityIncrement;

    /**
     * 最大数组长度
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public Stack() {
        elementData = new Object[DEFAULT_SIZE];
    }

    public E push(E e) {
        //确保组数长度足够
        ensureCapacity(elementCount + 1);
        //插入元素
        elementData[elementCount++] = e;
        return e;
    }

    public E pop() {
        E e = peek();
        removeElementAt(elementCount - 1);
        return e;
    }

    private void removeElementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j = elementCount - index - 1;
        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        elementCount--;
        elementData[elementCount] = null;
    }

    public E peek() {
        if (elementCount == 0)
            throw new EmptyStackException();
        return elementAt(elementCount - 1);
    }

    private E elementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) elementData[index];
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + capacityIncrement > 0 ? capacityIncrement : oldCapacity;
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private int hugeCapacity(int minCapacity) {
        if (minCapacity < 0)
            throw new OutOfMemoryError();
        return minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "elementData=" + Arrays.toString(elementData) + "}";
    }
}
