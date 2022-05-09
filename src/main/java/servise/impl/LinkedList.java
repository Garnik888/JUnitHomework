package servise.impl;

import servise.List;

import java.util.Iterator;
import java.util.Objects;

public class LinkedList<T> implements List<T> {

    //Fields of LinkedList class
    private int size = 0;
    private Node<T> head;

    // Static native class
    private static class Node<T> {

        //Fields of Node class
        private T val;
        private Node<T> next;

        //Constructor for Node class
        public Node(T val, Node<T> next) {
            this.val = val;
            this.next = next;
        }

        public Node() {

        }
    }

    private class LinkedListIterator implements Iterator<T> {

        private Node<T> lastElement = head;

        @Override
        public boolean hasNext() {
            return lastElement != null;
        }

        @Override
        public T next() {
            T value = lastElement.val;
            lastElement = lastElement.next;
            return value;
        }
    }

    public LinkedList() {

    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public T get(int index) {

        if (index < 0 || index > size) {

            throw new IndexOutOfBoundsException();
        }

        Node<T> findElement = head;

        for (int i = 0; i < index; i++) {

            findElement = findElement.next;
        }

        return findElement.val;
    }

    @Override
    public void add(T val) {

        Node<T> lastElement = head;

        if (isEmpty()) {

            head = new Node<T>(val, null);
        } else {

            while (lastElement.next != null) {

                lastElement = lastElement.next;
            }

            lastElement.next = new Node<>(val, null);
        }

        size++;

    }

    @Override
    public void add(int index, T val) {

        if (index < 0 || index > size) {

            throw new IndexOutOfBoundsException();
        }

        Node<T> findElement = head;

        if (isEmpty()) {

            head = new Node<>(val, null);
        } else {

            for (int i = 0; i < index-1; i++) {

                findElement = findElement.next;
            }

            findElement.next = new Node<>(val, findElement.next);
            size++;
        }


    }

    @Override
    public void delete(int index) {

        if (index < 0 || index > size) {

            throw new IndexOutOfBoundsException();
        }

        Node<T> findElement = head;

        if (index == 0) {

            head = findElement.next;
        } else {
            for (int i = 0; i < index - 1; i++) {

                findElement = findElement.next;
            }

            findElement.next = findElement.next.next;
        }

        size--;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedList<?> that = (LinkedList<?>) o;
        return size == that.size && Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, head);
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "size=" + size +
                ", head=" + head +
                "}\n";
    }
}
