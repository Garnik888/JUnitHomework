package servise_test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import servise.impl.LinkedList;

public class LinkedLisTest <T>{

    @Test
    public void size() {

        LinkedList<Integer> list = new LinkedList<>();
        Assertions.assertEquals(0, list.size());

        list.add(10);
        Assertions.assertEquals(1, list.size());

        list.delete(0);
        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void isEmpty() {

        LinkedList<Integer> list = new LinkedList<>();
        Assertions.assertTrue(list.isEmpty());

        list.add(10);
        Assertions.assertFalse(list.isEmpty());

        list.delete(0);
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void get() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        Assertions.assertEquals(20, list.get(1));
    }

    @Test
    public void addIndex() {

        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(1, 40);
        Assertions.assertEquals(40, list.get(1));
    }
}
