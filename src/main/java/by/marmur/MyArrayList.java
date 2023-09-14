package by.marmur.aston;

/* Методы:


○ Java generics ○ Comparable, Comparator.
Не должно быть ограничение на Comparable класс в ArrayList.

 */

import java.util.*;

public class MyArrayList<E> implements Iterable {

    /*
    стандартный размер внутреннего массива
     */
    private static final int STANDARD_CAPACITY = 10;

    /*
    переменная хранит стандартный пустой массив
    */
    //private static final Object[] STANDARD_EMPTY_ARRAY = {};

    /*
    переменная хранит обект - массив
     */
    Object[] array;

    /*
    переменная хранит размер внутреннего массива листа.
     */
    private int sizeArray;

    /*
    переменная хранит счетчик количества элементов в листе.
    */
    private int countElements = 0;

    /*
    конструктор1. создается пустой лист
     */
    public MyArrayList() {
        this.array = new Object[STANDARD_CAPACITY];
        this.sizeArray = STANDARD_CAPACITY;
    }

    /*
    конструктор2. создается пустой лист с размером внетреннего массива равного myInitialCapacity.
     */
    public MyArrayList(int myInitialCapacity) {
        if (myInitialCapacity > 0) {
            this.array = new Object[myInitialCapacity];
            sizeArray = myInitialCapacity;
        } else if (myInitialCapacity == 0) {
            this.array = new Object[STANDARD_CAPACITY];
            this.sizeArray = STANDARD_CAPACITY;
        } else {
            throw new IllegalArgumentException("Incorrect capacity!");
        }
    }

    /*
    увеличить размер внутреннего массива. Копирует старый в новый увеличенный массив и присваивает ссылку нового массива в array.
     */
    private void increaseSizeArray() {
        Object[] copyArray = new Object[this.sizeArray + STANDARD_CAPACITY];
        if (this.sizeArray >= 0) System.arraycopy(array, 0, copyArray, 0, this.sizeArray);
        array = copyArray;
    }

    private void checkCapacity (){
        if (this.countElements == this.sizeArray){
            this.increaseSizeArray();
        }
    }


    /*
    Добавить элемент в конец списка. Проверяет capacity внутреннего массива. Если внутренний массив полностью заполнен, увеличивает его.
    */

    public boolean add(E element) {
        checkCapacity();
        array[countElements] = element;
        countElements++;
        return true;

    }

    /*
    Добавить элемент по индексу. смещает остальные элементы на 1 позицию.
    */
    public void add(E element, int index) {

        if ((index < 0) || (index > (this.countElements + 2))  ) {
            throw new IndexOutOfBoundsException("Incorrect index!");
        }

        if (index == this.countElements){
            checkCapacity();
            array[index]=element;
        }


        else if (index < this.countElements ) {
            Object[] copyArray = new Object[this.sizeArray + 1];

            for (int i = 0; i < index; i++) {
                copyArray[i] = this.array[i];
            }
            copyArray[index] = element;

            for (int i = index; i < copyArray.length; i++) {
                copyArray[i + 1] = this.array[i];
            }
            countElements++;
        }
    }


    /*
    получить элемент
    */
    public E get(int index) {

        Objects.checkIndex(index, this.getSize());
        return (E) array[index];
    }

    /*
    заменить элемент по индексу
     */

    public void replaceElement(int index, E element) {
        if (element == null) {
            array[index] = null;
        } else if (this.get(index).getClass() == element.getClass()) {
            array[index] = element;
        } else {
            System.out.println("Class mismatch");
        }
    }

    /*
    удалить элемент
    */
    public void removeElement (int index){

    }


    /*
    отсортировать
     */
    public void sort(Comparator<? super E> comparator) {
        Arrays.sort((E[]) array, 0, countElements, comparator);
    }

    /*
    очистить всю коллекцию, колличество ячеек в массиве остается тем же.
     */
    public void clear() {
        for (Object e : this) {
            e = null;

        }
    }


     /*
    получить размер внутреннего Массива
    */

    public int getSize() {
        return this.array.length;
    }

    /*
    получить количество элементов в Листе
     */

    public int getCountElements() {
        return countElements;
    }

    /*
    проверить пустой ли Лист
    */

    public boolean isEmpty() {
        return this.getCountElements() == 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {
        return null;
    }


}
