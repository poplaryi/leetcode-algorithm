package com.yangyi.code.data;


/**
 * @author kcyangyi@gmail.com
 */
public class SingleLink<E> {

    private final Node<E> head = new Node<>(null, null);
    private int elementCount;

    /**
     * 尾插法
     *
     * @param e
     *
     * @return
     */
    public E addTail(E e) {
        Node<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node<>(e, null);
        elementCount++;
        return e;
    }

    /**
     * 头插法
     *
     * @param e
     *
     * @return
     */
    public E addHeader(E e) {
        Node<E> temp = head.next;
        head.next = new Node<>(e, temp);
        elementCount++;
        return e;
    }

    public void remove(E e) {
        if (elementCount <= 0) {
            throw new RuntimeException("链表为空");
        }
        Node<E> temp = head;
        Node<E> prev = null;
        while (temp.next != null) {
            if (temp.data != null && temp.data.equals(e)) {
                assert prev != null;
                prev.next = temp.next;
                elementCount--;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    static class Node<E> {
        private final E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}
