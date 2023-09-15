package by.marmur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private MyArrayList<String> myArrayList;

    @BeforeEach
    void setUp() {
        myArrayList = new MyArrayList<>();
        myArrayList.add("0");
        myArrayList.add("1");
        myArrayList.add("2");
    }

    @Test
    void shouldAdd_NewObject() {
        myArrayList.add("New3", 3);

        assertEquals("New3", myArrayList.get(3));
    }

    @Test
    void shouldReturn_CorrectValueByGet() {
        assertEquals("1", myArrayList.get(1));
    }

    @Test()
    public void shouldThrow_WhenIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.get(-1));
    }

    @Test
    void shouldReplaceElement() {
        myArrayList.replaceElement(0, "Next");

        assertEquals("Next", myArrayList.get(0));
    }

    @Test
    void shouldRemoveElement() {
        String str = myArrayList.get(0);

        assertEquals(str, myArrayList.removeElement(0));
    }

    @Test
    void shouldSort() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(3);
        list.add(9);
        list.add(1);
        list.add(7);
        MyArrayList<Integer> sortedList = new MyArrayList<>();
        sortedList.add(1);
        sortedList.add(3);
        sortedList.add(7);
        sortedList.add(9);

        list.sort((o1,o2)-> o1-o2 );

        for (int i = 0; i < list.getCountElements(); i++) {
            assertEquals(sortedList.get(i),list.get(i));
        }



    }

    @Test
    void shouldClearList() {
        myArrayList.clear();

        assertEquals(0, myArrayList.getCountElements());
    }

    @Test
    void shouldReturn_CountElements() {
        assertEquals(3, myArrayList.getCountElements());
    }


}
