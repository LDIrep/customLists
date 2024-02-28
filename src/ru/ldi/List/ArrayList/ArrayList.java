package ru.ldi.List.ArrayList;

import ru.ldi.List.Interface.List;
import ru.ldi.List.LinkedList.LinkedList;

import java.util.Arrays;
import java.util.Iterator;

/**
 * This class represents a dynamic array list.
 *
 * @param <T> The type of elements in the array list.
 */
public class ArrayList<T> implements List<T> {

    private T[] array;
    private int size = 0;
    private int maxIndex = -1;
    private static final int DEFAULT_CAPACITY = 20;

    /**
     * Constructs an array with the capacity we specified
     */
    public ArrayList() {
        array = createArray(DEFAULT_CAPACITY);
    }

    /**
     * Constructs a new array list with the specified initial capacity.
     *
     * @param capacity The initial capacity of the array list
     */
    public ArrayList(int capacity) {
        if (capacity > 0) {
            array = createArray(capacity);
        } else throw new IllegalArgumentException("Illegal capacity " + capacity);
    }

    /**
     * Constructs a new array list with the specified array.
     *
     * @param array The array to be used as the initial contents of the array list.
     */
    public ArrayList(T[] array) {
        this.array = createArray(array.length * 3);
        if (array.length == 0) {
            size = 0;
        } else {
            size = array.length;
            for (int i = 0; i < array.length; i++) {
                this.array[i] = array[i];
                this.maxIndex++;
            }
        }
    }

    /**
     * Constructs a new array list with the specified linked list.
     *
     * @param linkedList The linked list to be used as the initial contents of the array list.
     */
    public ArrayList(LinkedList<T> linkedList) {
        int linkedListSize = linkedList.getSize();
        array = createArray(linkedListSize * 3);
        for (int i = 0; i < linkedListSize - 1; i++) {
            array[i] = linkedList.get(i);
            size++;
            maxIndex++;
        }
    }

    /**
     * Adds the specified element to the array list.
     * If the array list is nearly to full, it will be expanded.
     *
     * @param t The element to be added to the array list.
     */
    @Override
    public void add(T t) {
        if (size >= array.length / 2) {
            increaseArraySize();
        }
        array[size++] = t;
        System.out.println("Size is: " + size);
        maxIndex++;
        System.out.println("Max index is: " + maxIndex);
        System.out.println("Array length: " + getLength());
    }

    /**
     * Adds the specified element to the array list at the specified index.
     * If the array list is full, it will be expanded.
     *
     * @param t     The element to be added to the array list.
     * @param index The index at which the element should be added.
     * @throws IllegalArgumentException If the index is less than 0 or greater than the size of the array list.
     */
    public void add(T t, int index) {
        if ((index == size)) {
            array[++maxIndex] = t;
            size++;
            if (size == array.length / 2) {
                increaseArraySize();
            }
            return;
        } else if ((index >= 0) && (index <= maxIndex)) {
            array[index] = t;
        } else throw new IllegalArgumentException("Illegal index: " + index);
    }

    /**
     * Returns the element at the specified index in the array list.
     *
     * @param index The index of the element to be returned.
     * @return The element at the specified index.
     * @throws IllegalArgumentException If the index is less than 0 or greater than the size of the array list.
     */
    @Override
    public T get(int index) {
        if ((index <= maxIndex) && (index >= 0)) {
            return array[index];
        } else throw new IllegalArgumentException("Illegal index: " + index);
    }

    /**
     * Removes the element at the specified index from the array list.
     *
     * @param index The index of the element to be removed.
     * @throws IllegalArgumentException If the index is less than 0 or greater than the size of the array list.
     */
    @Override
    public void removeElement(int index) {
        if ((index <= maxIndex) && (index >= 0)) {
            for (int i = index; i < size + 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
            maxIndex--;
        } else throw new IllegalArgumentException("Illegal index: " + index);
    }

    /**
     * Clears the array list, resetting its size to 0.
     */
    @Override
    public void clear() {
        array = createArray(DEFAULT_CAPACITY);
    }

    /**
     * Sorts the elements in the array list using the quick sort algorithm.
     *
     * @throws IndexOutOfBoundsException when an attempt is made to access an element at a specific index in an empty list
     */
    @Override
    public void sort() {
        if (size == 0){
            throw new IndexOutOfBoundsException("List is empty");
        }
        Arrays.sort(array, 0, size);
    }

    /**
     * Returns the size of the array list.
     *
     * @return The size of the array list.
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * @return Returns a comma separated string representation of our array list.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ArrayList { ");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                stringBuilder.append(array[i]);
            } else stringBuilder.append(array[i] + ", ");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    /**
     * @return Returns an iterator for our array list.
     */
    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex <= maxIndex;
            }

            @Override
            public T next() {
                return array[currentIndex++];
            }
        };
        return iterator;
    }

    private T[] createArray(int capacity) {
        size = 0;
        maxIndex = -1;
        return (T[]) new Object[capacity];
    }

    private void increaseArraySize() {
        int tempSize = size;
        int tempMaxIndex = maxIndex;
        T[] newArray = createArray(array.length * 2);
        for (int i = 0; i < tempSize; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        size = tempSize;
        maxIndex = tempMaxIndex;
    }
    public int getLength(){
        return array.length;
    }
}
