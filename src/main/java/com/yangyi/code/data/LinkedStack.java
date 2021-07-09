package com.yangyi.code.data;

import java.util.Arrays;

/**
 * 用链表实现栈
 */
public class LinkedStack<E> {
    private Node<E> head;
    private int elementCount;

    /**
     * 入栈
     *
     * @param e
     *
     * @return
     */
    public E push(E e) {
        head = new Node<>(e, head);
        elementCount++;
        return e;
    }

    /**
     * 获取栈顶元素
     *
     * @return
     */
    public E peek() {
        return head.element;
    }

    /**
     * 出栈
     *
     * @return
     */
    public E pop() {
        elementCount--;
        E e = peek();
        head = head.next;
        return e;
    }


    class Node<E> {
        private E element;
        private Node<E> next;

        private Node() {
        }

        private Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
