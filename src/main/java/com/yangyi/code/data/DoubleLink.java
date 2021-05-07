package com.yangyi.code.data;


/**
 * @author kcyangyi@gmail.com
 */
public class DoubleLink<E> {
    private final Node<E> head = new Node<>(null, null, null);

    private int elementCount;

    public E add(E e) {
        Node<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node<>(e, temp, null);
        elementCount++;
        return e;
    }

    public void remove(E e) {
        Node<E> temp = head;
        while (true) {
            if (temp.data != null && temp.data.equals(e)) {
                temp.next.prev = temp.prev;
                temp.prev.next = temp.next;
                elementCount--;
                return;
            }
            temp = temp.next;
        }
    }


    static class Node<E> {
        private final E data;
        private Node<E> prev;
        private Node<E> next;

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
