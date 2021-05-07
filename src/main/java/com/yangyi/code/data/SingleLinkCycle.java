package com.yangyi.code.data;

/**
 * 循环单链表
 *
 * @author kcyangyi@gmail.com
 */
public class SingleLinkCycle<E> {
    private final Node<E> head = new Node<>(null, null);
    private Node<E> tail = head;

    private int elementCount;

    static class Node<E> {
        private final E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 尾插法
     *
     * @param data
     */
    public void addTail(E data) {
        Node<E> temp = head;
        while (temp != null && temp != tail) {
            temp = temp.next;
        }
        assert temp != null;
        temp.next = new Node<>(data, head);
        tail = temp.next;
        elementCount++;
    }

    /**
     * 头插法
     *
     * @param data
     */
    public void addHeader(E data) {
        Node<E> newNode = new Node<>(data, tail);
        head.next = newNode;
        tail = newNode;
        elementCount++;
    }

    public void remove(E data) {
        Node<E> temp = head;
        Node<E> prev = null;
        while (true) {
            if (temp.data != null && temp.data.equals(data)) {
                assert prev != null;
                prev.next = temp.next;
                elementCount--;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }
}
