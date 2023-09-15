package by.marmur;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private static MyArrayList<String> myArrayList;

    @BeforeEach
    void createNewMyArrayList (){
        myArrayList = new MyArrayList<>();
        myArrayList.add("0");
        myArrayList.add("1");
        myArrayList.add("2");
    }

    @Test
    void add() {
        myArrayList.add("New3", 3);
        assertEquals("New3", myArrayList.get(3));
    }

    @Test
    void get() {
    assertEquals("1", myArrayList.get(1));
    }

    @Test
    void replaceElement() {
                myArrayList.replaceElement(0, "Next");
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

        // тест сортировки

    }

    @Test
    void clear() {
        myArrayList.clear();
        assertEquals(0, myArrayList.getCountElements());
    }

    @Test
    void getCountElements() {
        assertEquals(3, myArrayList.getCountElements());
    }

}
