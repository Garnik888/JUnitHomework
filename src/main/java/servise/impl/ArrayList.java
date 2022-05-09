package servise.impl;

import servise.List;

import java.util.Iterator;

public class ArrayList<T> implements List<T> {

    private static final int DEF_CAPACITY = 10;
    private int capacity = DEF_CAPACITY;
    private int size;
    private Object[] arrayList;

    public ArrayList() {

        this.arrayList = new Object[capacity];
    }

    private class ArrayListIterator<T> implements Iterator<T> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {

            T value = (T) arrayList[index];
            index++;
            return value;
        }
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

        if (index < 0 || index >= size) {

            throw new IndexOutOfBoundsException();
        }

        return (T) arrayList[index];
    }

    @Override
    public void add(T val) {

        if (checkLength()) {
            grow();
        }
        arrayList[size] = val;
        size++;
    }

    @Override
    public void add(int index, T val) {

        if (index < 0 || index >= size) {

            throw new IndexOutOfBoundsException();
        }

        if (checkLength()) {
            grow();
        }

        if (size + 1 - index >= 0) {
            System.arraycopy(arrayList, index, arrayList,
                    index + 1, size + 1 - index);
        }

        arrayList[index] = val;
        size++;
    }

    @Override
    public void delete(int index) {

        if (index < 0 || index >= size) {

            throw new IndexOutOfBoundsException();
        }

        if (size - 1 - index >= 0) {
            System.arraycopy(arrayList, index + 1, arrayList, index,
                    size - 1 - index);
        }

        arrayList[size - 1] = 0;
        size--;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator<T>();
    }

    public void set(int index, T val) {

        if (index < 0 || index >= size) {

            throw new IndexOutOfBoundsException();
        }

        arrayList[index] = val;
    }

    public int indexOf(T val) {

        for (int i = 0; i < size; i++) {

            if (arrayList[i] == val) {

                return i;
            }
        }
        return -1;
    }

    public String toString() {

        StringBuilder str = new StringBuilder("[");

        for (int i = 0; i < size; i++) {

            if (i == size - 1) {
                str.append(arrayList[i]).append("]");
            } else {

                str.append(arrayList[i]).append(" ");
            }
        }

        return str.toString();
    }

    public boolean contains(T val) {

        for (int i = 0; i< size; i++) {
           if((T)arrayList[i] == val) {

               return true;
           }
        }

        return false;
    }

    public T[] toArray() {

        T[] array = (T[]) new Object[size];

        System.arraycopy(arrayList, 0, array, 0, size);

        return array;
    }

    private boolean checkLength() {

        return size == capacity;
    }

    /**
     * Grow the array list
     */
    private void grow() {

        T[] array;
        capacity *= 2;
        array = (T[]) new Object[capacity];

        if (size >= 0) {
            System.arraycopy(arrayList, 0, array, 0, size);
        }

        arrayList = array;
    }
}
