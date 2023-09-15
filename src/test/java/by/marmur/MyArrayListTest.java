package by.marmur;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void add() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("0");
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("New", 0);
        assertEquals("New", myArrayList.get(0));
        myArrayList.add("New2", 3);
        assertEquals("New2", myArrayList.get(3));
    }

    @Test
    void get() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("0");
        myArrayList.add("1");
        myArrayList.add("2");
        assertEquals("1", myArrayList.get(1));
    }

    @Test
    void replaceElement() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("0");
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.replaceElement(0, "Next");
        assertEquals("Next", myArrayList.get(0));
    }

    @Test
    void removeElement() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("0");
        myArrayList.add("1");
        myArrayList.add("2");
        String str = myArrayList.get(0);
        myArrayList.removeElement(0);
        assertNotEquals(str, myArrayList.get(0));
    }

    @Test
    void sort() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("0");
        myArrayList.add("1");
        myArrayList.add("2");

        // тест сортировки


    }

    @Test
    void clear() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("0");
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.clear();
        assertEquals(0, myArrayList.getCountElements());
    }

    @Test
    void getCountElements() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("0");
        myArrayList.add("1");
        myArrayList.add("2");
        assertEquals(3, myArrayList.getCountElements());
    }

}
