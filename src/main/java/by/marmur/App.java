package by.marmur;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        MyArrayList<String> strings2 = new MyArrayList<>();
        strings2.add("ab");
        strings2.add("bcd");
        strings2.add("cdfg", 0);
        for (int i = 0; i < strings2.getCountElements(); i++) {
            System.out.print(strings2.get(i)+" ");
        }

        strings2.sort((o1, o2) -> o1.length()-o2.length());
        System.out.println();
        System.out.print("Sorted list: ");
        for (int i = 0; i < strings2.getCountElements(); i++) {
            System.out.print(strings2.get(i)+" ");

        }
    }
}

