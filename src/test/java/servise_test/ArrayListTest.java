package servise_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import servise.impl.ArrayList;

public class ArrayListTest<T> {

    @Test
    public void sizeAddDelete() {

        ArrayList<Integer> arrayList = new ArrayList<>();

        Assertions.assertEquals(0, arrayList.size());

        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        Assertions.assertEquals(3, arrayList.size());

        arrayList.add(1, 40);

        Assertions.assertEquals(4, arrayList.size());

        arrayList.delete(2);

        Assertions.assertEquals(3, arrayList.size());
    }

    @Test
    public void isEmpty() {

        ArrayList<Integer> arrayList = new ArrayList<>();
        Assertions.assertTrue(arrayList.isEmpty());

        arrayList.add(20);
        Assertions.assertFalse(arrayList.isEmpty());

        arrayList.delete(0);
        Assertions.assertTrue(arrayList.isEmpty());
    }

    @Test
    public void addIndexSetGet() {

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        Assertions.assertEquals(20, arrayList.get(1));

        arrayList.add(1, 40);
        Assertions.assertEquals(40, arrayList.get(1));

        arrayList.set(2, 50);
        Assertions.assertEquals(50, arrayList.get(2));
    }

    @Test
    public void indexOf() {

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        Assertions.assertEquals(1, arrayList.indexOf(20));

        arrayList.add(1, 40);
        Assertions.assertEquals(1, arrayList.indexOf(40));

        arrayList.set(1, 50);
        Assertions.assertEquals(1, arrayList.indexOf(50));

        arrayList.delete(1);
        Assertions.assertEquals(1, arrayList.indexOf(20));
    }

    @Test
    public void contains() {

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        Assertions.assertTrue(arrayList.contains(20));
        Assertions.assertFalse(arrayList.contains(100));
    }
}
