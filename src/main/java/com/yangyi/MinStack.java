package com.yangyi;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author kcyangyi@gmail.com
 */
public class MinStack {
    // 数组
    private Object[] elementData;

    //  条目总数
    private int elementCount = 0;

    private final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        elementData = new Object[0];
    }

    public void push(int val) {
        if (elementData.length <= elementCount)
            refresh();
        elementData[elementCount++] = val;
        priorityQueue.add(val);
    }

    public void pop() {
        Object o = removeElementAt(elementCount - 1);
        priorityQueue.remove(o);
    }

    public int top() {
        return (int) elementData[elementCount - 1];
    }

    public int getMin() {
        return priorityQueue.peek();
    }

    private void refresh() {
        int oldCapacity = elementData.length;
        int newCapacity;
        // 初始化容量
        if (oldCapacity < 10) {
            newCapacity = 10;
        } else {
            newCapacity = oldCapacity << 1;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public Object removeElementAt(int index) {
        if (index >= elementCount)
            throw new ArrayIndexOutOfBoundsException();
        else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j = elementCount - index - 1;
        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        Object o = elementData[--elementCount];
        elementData[elementCount] = null;
        return o;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();

        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}
