package com.yangyi.code.data;

/**
 * @author kcyangyi@gmail.com
 */
public class DoubleLinkCycle<E> {

    private Node<E> head = new Node<>(null, null, null);
    private Node<E> tail = head;
    private int elementCount;

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
        Node<E> newNode = new Node<>(data, temp, tail);
        assert temp != null;
        temp.next = newNode;
        tail = newNode;
        head.prev = tail;
        elementCount++;
    }

    public void addHeader(E data) {
        Node<E> newNode = new Node<>(data, head, tail);
        head.next = newNode;
        tail = newNode;
        head.prev = tail;
        elementCount++;
    }


    static class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
