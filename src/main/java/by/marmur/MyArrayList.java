package by.marmur;


import java.util.Comparator;

public class MyArrayList<E> {

    /**
     * стандартный размер внутреннего массива
     */
    private static final int STANDARD_CAPACITY = 10;

    /**
     * пустой массив
     */
    private static final Object[] EMPTY_ARRAY = {};

    /**
     * переменная хранит обект - массив
     */
    Object[] array;

    /**
     * переменная хранит счетчик количества элементов в листе.
     */
    private int countElements = 0;

    /**
     * конструктор1. создается пустой лист
     */
    public MyArrayList() {
        this.array = new Object[STANDARD_CAPACITY];
    }

    /**
     * конструктор2. создается пустой лист с размером внетреннего массива равного myInitialCapacity.
     */
    public MyArrayList(int myInitialCapacity) {
        if (myInitialCapacity > 0) {
            this.array = new Object[myInitialCapacity];
        } else if (myInitialCapacity == 0) {
            this.array = EMPTY_ARRAY;
        } else {
            throw new IllegalArgumentException("Incorrect capacity!");
        }
    }

    /**
     * увеличить размер внутреннего массива. Копирует старый массив в новый увеличенный массив и присваивает ссылку нового массива в array.
     */
    private void increaseSizeArray() {
        Object[] copyArray = new Object[this.array.length + STANDARD_CAPACITY];
        System.arraycopy(array, 0, copyArray, 0, this.array.length);
        array = copyArray;
    }

    /**
     * проверить заполнен ли полностью массив. если массив заполнен - вызывает метод increaseSizeArray для увеличения размера массива
     */
    private void checkCapacity(int length) {
        if (this.countElements == length) {
            this.increaseSizeArray();
        }
    }


    /**
     * Добавить элемент в конец списка.
     */
    public boolean add(E element) {
        checkCapacity(array.length);
        array[countElements] = element;
        countElements++;
        return true;

    }

    /**checkIndex
     * Добавить элемент по индексу. смещает остальные элементы на 1 позицию.
     */
    public void add(E element, int index) {
        if ((index < 0) || (index > (this.countElements))) {
            throw new IndexOutOfBoundsException("Incorrect index!");
        }
        if (index == this.countElements) {
            checkCapacity(index);
            array[index] = element;
            countElements++;
        } else if (index < this.countElements) {
            Object[] copyArray = new Object[this.array.length + 1];
            System.arraycopy(this.array, 0, copyArray, 0, index);
            copyArray[index] = element;
            System.arraycopy(this.array, index, copyArray, index + 1, copyArray.length - 1 - index);
            array = copyArray;
            countElements++;
        }
    }

    /**checkIndex
     * получить элемент по индексу
     */
    public E get(int index) {
        if ((index < 0) || (index > (this.countElements-1))) {
            throw new IndexOutOfBoundsException("Incorrect index!");
        }
        return (E) array[index];
    }

    /**checkIndex
     * заменить элемент по индексу
     */
    public void replaceElement(int index, E element) {
        if ((index < 0) || (index > (this.countElements-1))) {
            throw new IndexOutOfBoundsException("Incorrect index!");
        }
        if (element == null) {
            array[index] = null;
        } else if (this.get(index).getClass() == element.getClass()) {
            array[index] = element;
        } else {
            System.out.println("Class mismatch");
        }
    }

    /**!! checkIndex
     * Удалить элемент по индексу
     */
    public E removeElement(int index) {
        if ((index < 0) || (index > (this.countElements-1))) {
            throw new IndexOutOfBoundsException("Incorrect index!");
        }
        E element = (E) this.array[index];

        if (index == (array.length - 1)) {
            array[index] = null;
            countElements--;
        } else {
            Object[] copyArray = new Object[array.length];
            System.arraycopy(this.array, 0, copyArray, 0, index);
            System.arraycopy(this.array, index + 1, copyArray, index, array.length - 1 - index);
            array = copyArray;
            countElements--;
        }
        return element;
    }

    /**
     * Отсортировать массив методом быстрой сортировки. Принимает в качестве аргумента объект Comparator
     */
    public void sort(Comparator<? super E> comparator) {
        new Quicksort().quickSort((E[]) this.array, 0, this.countElements- 1, comparator);
    }

    /*
    Проверить валидность индекса листа.
     */
//    private void checkIndex(int index) {
//        if ((index < 0) || (index > (this.countElements + 1))) {
//            throw new IndexOutOfBoundsException("Incorrect index!");
//        }
//    }

    /**
     * Очистить всю коллекцию, колличество ячеек в массиве остается тем же.
     */
    public void clear() {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = null;
        }
        countElements = 0;
    }


    /**
     * получить размер внутреннего массива
     */
    private int getSize() {
        return this.array.length;
    }

    /**
     * Получить количество элементов в Листе
     */
    public int getCountElements() {
        return this.countElements;
    }


    /**
     * Класс с реализацией метода быстрой сортировки
     */
    class Quicksort {
        public void quickSort(E[] sortArr, int low, int high, Comparator<? super E> comparator) {
            /*
             *завершить,если массив пуст или уже нечего делить
             */
            if (sortArr.length == 0 || low >= high) return;

            /*
             *выбор опорного элемента
             */
            int middle = low + (high - low) / 2;
            E border = sortArr[middle];
            /*
             *разделить на подмассивы и меняем местами
             */
            int i = low, j = high;
            while (i <= j) {
                while (comparator.compare(border, sortArr[i]) >= 1) i++;

                while (comparator.compare(border, sortArr[j]) <= (-1)) j--;

                E swap = sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = swap;
                i++;
                j--;
            }
            /*
            рекурсия для сортировки левой и правой части
            */
            if (low < j) quickSort(sortArr, low, j, comparator);
            if (high > i) quickSort(sortArr, i, high, comparator);
        }
    }


}




