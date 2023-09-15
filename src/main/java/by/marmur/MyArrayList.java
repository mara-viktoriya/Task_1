package by.marmur;

import java.util.Comparator;

/**
 * Resizable array.
 * Permits all elements, including null.
 * Provides methods to manipulate the size of the array that is used internally to store the list.
 * Has an internal class for quick array sorting.
 * This realization is not synchronized.
 * @param <E> – the type of elements in this list.
 */
public class MyArrayList<E> {

    /**
     * Standard initial capacity of array.
     */
    private static final int STANDARD_CAPACITY = 10;

    /**
     * Shared empty array instance. Used for empty instances.
     */
    private static final Object[] EMPTY_ARRAY = {};

    /**
     * The array stored the elements of the MyArrayList.
     */
    Object[] array;

    /**
     * The number of elements this MyArrayList contains.
     */
    private int countElements = 0;

    /**
     * Constructs an empty list with the standard initial capacity.
     */
    public MyArrayList() {
        this.array = new Object[STANDARD_CAPACITY];
    }



    /**
     * Constructs an empty list with the capacity equal to myInitialCapacity.
     * @param myInitialCapacity – the initial capacity of the list
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
     * Increases the capacity of array by standard initial capacity if the array is completely full.
     */
    private void increaseSizeArray() {
        Object[] copyArray = new Object[this.array.length + STANDARD_CAPACITY];
        System.arraycopy(array, 0, copyArray, 0, this.array.length);
        array = copyArray;
    }

    /**
     *Checks the capacity of the array. When the array is filled, increaseSizeArray method will be invoked.
     * @param length - length of this array.
     */
    private void checkCapacity(int length) {
        if (this.countElements == length) {
            this.increaseSizeArray();
        }
    }


    /**
     * Appends the element to the end of this list.      *
     * @param element - element to be appended to this list.
     * @return true (as specified by Collection.add)
     */
    public boolean add(E element) {
        checkCapacity(array.length);
        array[countElements] = element;
        countElements++;
        return true;

    }

    /**
     * Add the element at the specified position in this list.
     * Shifts the elements to the right (adds one to their indices).
     * @param element – element to be inserted
     * @param index – index at which the specified element is to be inserted
     * @throws IndexOutOfBoundsException – if the index is out of range (index < 0) || (index > (this.countElements))
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

    /**
     * Returns the element at the specified position in this list.
     * @param index – index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException – if the index is out of range (index < 0) || (index > (this.countElements-1))
     */
    public E get(int index) {
        if ((index < 0) || (index > (this.countElements-1))) {
            throw new IndexOutOfBoundsException("Incorrect index!");
        }
        return (E) array[index];
    }

    /**
     * * Replaces the element at the specified position in this list with the specified element.
     * @param index - index of the element to replace
     * @param element - element to be stored at the specified position
     * @throws IndexOutOfBoundsException – if the index is out of range (index < 0) || (index > (this.countElements-1))
     */
    public void replaceElement(int index, E element) {
        if ((index < 0) || (index > (this.countElements-1))) {
            throw new IndexOutOfBoundsException("Incorrect index!");
        }
        if (element == null) {
            array[index] = null;
        } else if (this.get(index).getClass() == element.getClass()) {
            array[index] = element;
        }
    }

    /**
     * Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices).
     * @param index – the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException – if the index is out of range (index < 0) || (index > (this.countElements-1))
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
     * Sort the array using quicksort method from inner class Quicksort.
     * @param comparator - object for comparing objects
     */
    public void sort(Comparator<? super E> comparator) {
        new Quicksort().quickSort((E[]) this.array, 0, this.countElements- 1, comparator);
    }

    /**
     * Removes all of the elements from this list.
     */
    public void clear() {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = null;
        }
        countElements = 0;
    }

    /**
     * Get the number of elements in this list.
     * @return the number of elements.
     */
    public int getCountElements() {
        return this.countElements;
    }

    /**
     * Inner class with realization of quicksort method.
     */
    class Quicksort {

        /**
         * Sort the array using quicksort.
         * @param sortArr - the array for sorting
         * @param low - minimum left array cell for sorting
         * @param high - maximum right array cell for sorting
         * @param comparator - object storing rules for comparing objects
         */
        public void quickSort(E[] sortArr, int low, int high, Comparator<? super E> comparator) {
            if (sortArr.length == 0 || low >= high) return;
            int middle = low + (high - low) / 2;
            E border = sortArr[middle];
            int i = low;
            int j = high;
            while (i <= j) {
                while (comparator.compare(border, sortArr[i]) >= 1) i++;
                while (comparator.compare(border, sortArr[j]) <= (-1)) j--;
                if (i <= j) {
                    E swap = sortArr[i];
                    sortArr[i] = sortArr[j];
                    sortArr[j] = swap;
                    i++;
                    j--;
                }
            }
            if (low < j) quickSort(sortArr, low, j, comparator);
            if (high > i) quickSort(sortArr, i, high, comparator);
        }
    }


}




