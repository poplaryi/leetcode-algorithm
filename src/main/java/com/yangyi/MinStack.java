package com.yangyi;

import java.util.Arrays;

/**
 * @author kcyangyi@gmail.com
 */
public class MinStack {
    // 数组
    private Object[] elementData;

    //  条目总数
    private int elementCount = 0;

    public MinStack() {
        elementData = new Object[0];
    }

    public void push(int val) {
        if (elementData.length <= elementCount)
            refresh();
        elementData[elementCount++] = val;
    }

    private void refresh() {
        int oldCapacity = elementData.length;
        int newCapacity;
        // 初始化容量
        if (oldCapacity <= 10) {
            newCapacity = 10;
        } else {
            newCapacity = oldCapacity * 2;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public void pop() {
        removeElementAt(elementCount - 1);
    }

    public int top() {
        return (int) elementData[elementCount - 1];
    }

    public int getMin() {
        int temp = (int) elementData[0];
        for (int i = 1; i < elementCount; i++) {
            if (temp > ((int) elementData[i])) {
                temp = (int) elementData[i];
            }
        }
        return temp;
    }

    public void removeElementAt(int index) {
        if (index >= elementCount)
            throw new ArrayIndexOutOfBoundsException();
        else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j = elementCount - index - 1;
        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        elementCount--;
        elementData[elementCount] = null;
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
