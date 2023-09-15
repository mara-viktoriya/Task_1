package by.marmur;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    static MyArrayList<String> myArrayList = new MyArrayList<>();

    @BeforeAll
    static void createMyArrayList() {
        myArrayList.add("0");
        myArrayList.add("1");
        myArrayList.add("2");

    }

    @Test
    void add() {
        myArrayList.add("New", 0);
        assertEquals("New",myArrayList.get(0));
        myArrayList.add("New2", 3);
        assertEquals("New2",myArrayList.get(3));
    }

        @Test
    void get() {
        assertEquals("1", myArrayList.get(1));
    }

    @Test
    void replaceElement() {
        myArrayList.replaceElement(0,"Next");
        assertEquals("Next", myArrayList.get(0));
    }

    @Test
    void removeElement() {
        String str = myArrayList.get(0);
        myArrayList.removeElement(0);
        assertNotEquals(str, myArrayList.get(0));
    }

    @Test
    void sort() {

    }

    @Test
    void clear() {
        MyArrayList<String> myArrayListTest = new MyArrayList<>();
        myArrayList.add("Anna");
        myArrayList.add("Zanna");
        myArrayList.add("Ganna");
        myArrayListTest.clear ();
        assertEquals(0, myArrayListTest.getCountElements());
    }

    @Test
    void getCountElements() {
        MyArrayList<String> myArrayListTest = new MyArrayList<>();
        myArrayList.add("Anna");
        myArrayList.add("Zanna");
        myArrayList.add("Ganna");
        assertEquals(3, myArrayListTest.getCountElements());
    }

}
