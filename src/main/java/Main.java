import servise.impl.LinkedList;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(1, 40);

        for (Integer integer : linkedList) {

            System.out.println(integer);
        }

        System.out.println(linkedList.get(1));
    }
}
