package com.yangyi;

import java.util.Arrays;

/**
 * 用队列实现栈
 * @author kcyangyi@gmail.com
 */
public class MyStack {

    private Object[] elementData;

    private int elementCount = 0;

    private static final int minCapacity = 10;

    public MyStack() {
        elementData = new Object[0];
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (elementData.length >= elementCount)
            refresh();
        elementData[elementCount++] = x;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        Object o = elementData[--elementCount];
        elementData[elementCount] = null;
        return (int) o;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return (int) elementData[elementCount - 1];
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return elementCount == 0;
    }

    public void refresh() {
        int newCapacity, oldCapacity = elementData.length;
        if (oldCapacity < minCapacity)
            newCapacity = minCapacity;
        else
            newCapacity = oldCapacity << 1;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
}
