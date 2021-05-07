package com.yangyi.code.data;

import java.util.Arrays;

/**
 * 用队列实现栈
 * @author kcyangyi@gmail.com
 */
public class MyQueue {
    private Object[] elementData;

    private int elementCount = 0;

    private static final int minCapacity = 10;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        elementData = new Object[0];
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (elementData.length >= elementCount) {
            refresh();
        }
        elementData[elementCount++] = x;
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (elementCount <= 0)
            throw new ArrayIndexOutOfBoundsException();
        Object o = elementData[0];
        int j = elementCount - 1;
        if (j > 0) {
            System.arraycopy(elementData, 1, elementData, 0, j);
        }
        elementCount--;
        return (int) o;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (elementCount <= 0)
            throw new ArrayIndexOutOfBoundsException();
        return (int) elementData[0];
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return elementCount == 0;
    }

    private void refresh() {
        int newCapacity, oldCapacity = elementData.length;
        if (oldCapacity < minCapacity) {
            newCapacity = minCapacity;
        } else {
            newCapacity = oldCapacity << 1;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

}
