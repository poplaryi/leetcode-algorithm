package com.yangyi.code.data;

/**
 * 带head的单链表
 *
 * @param <E>
 */
public class SingleNode<E> {
    private SingleNode<E> head;
    private SingleNode<E> next;
    private E data;

    public SingleNode() {
    }

    public SingleNode(E data, SingleNode<E> next) {
        this.data = data;
        this.next = next;
    }

    public void add(E data) {
        SingleNode<E> newNode = new SingleNode<>(data, null);
        if (head == null) {
            head = newNode;
            return;
        }
        SingleNode<E> temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
    }

    public void find() {
        if (head == null) {
            System.out.println("链表为空");
        }
        SingleNode<E> temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println(temp);
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void remove(E data) {
        if (head == null) {
            System.out.println("链表为空");
        }
        SingleNode<E> temp = head;
        SingleNode<E> prev = null;
        while (true) {
            if (temp.data.equals(data)) {
                if (prev == null) {
                    head = temp.next;
                } else {
                    prev.next = temp.next;
                }
                break;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    @Override
    public String toString() {
        return "SingleNode{ data=" + data + '}';
    }
}
