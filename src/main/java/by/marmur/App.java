package by.marmur;


import by.marmur.MyArrayList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        MyArrayList<String> strings2 = new MyArrayList<>();
        strings2.add("ab");
        strings2.add("bcd");
        strings2.add("cdfg", 0);
        for (int i = 0; i < strings2.getCountElements(); i++) {
            System.out.println(strings2.get(i));
        }


        strings2.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        System.out.println("_____________________");
        for (int i = 0; i < strings2.getCountElements(); i++) {
            System.out.println(strings2.get(i));

        }











    }
}

