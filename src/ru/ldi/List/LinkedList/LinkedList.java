package ru.ldi.List.LinkedList;

import ru.ldi.List.ArrayList.ArrayList;
import ru.ldi.List.Interface.List;

import java.util.Iterator;

/**
 * This class represents a linked list data structure.
 *
 * @param <T> The type of elements in the linked list.
 */
public class LinkedList<T> implements List<T> {

    private int size;
    private int maxIndex = -1;
    private Node<T> head;

    /**
     * Constructs a new linked list.
     */
    public LinkedList() {
        head = new Node<>(null);
        size = 0;
    }

    /**
     * Adds the specified element to the linked list.
     *
     * @param t The element to be added to the linked list.
     */
    @Override
    public void add(T t) {
        Node<T> node = new Node<>(t);
        Node<T> currentNode = head;

        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(node);
        size++;
        maxIndex++;
    }

    /**
     * Adds the specified element to the linked list at the specified index.
     *
     * @param t     The element to be added to the linked list.
     * @param index The index at which the element should be added.
     */
    @Override
    public void add(T t, int index) {
        if (index < 0){
            throw new IllegalArgumentException("Illegal index: " + index);
        }
        Node<T> node = new Node<>(t);
        if (index == size){
            this.add(t);
        } else {
            Node<T> previousNode = getPreviousNodeByIndex(index);
            previousNode.getNext().setElement(t);
        }

    }

    /**
     * Returns the element at the specified index in the linked list.
     *
     * @param index The index of the element to be returned.
     * @return The element at the specified index.
     */
    @Override
    public T get(int index) {
        return getPreviousNodeByIndex(index).getNext().getElement();
    }

    /**
     * Removes the element at the specified index from the linked list.
     *
     * @param index The index of the element to be removed.
     * @throws IllegalArgumentException If the index is less than 0 or greater than the size of the linked list.
     */
    @Override
    public void removeElement(int index) {
        if ((index < 0) || (index > maxIndex)) {
            throw new IllegalArgumentException("Illegal index: " + index);
        }

        Node<T> previousElement = getPreviousNodeByIndex(index);
        Node<T> elementToRemove = getPreviousNodeByIndex(index).getNext();
        previousElement.setNext(elementToRemove.getNext());
    }

    /**
     * Clears the linked list, resetting its size to 0.
     */
    @Override
    public void clear() {
        head = new Node<>(null);
        maxIndex = -1;
    }

    /**
     * Converts the linked list to an array list, applies a quick sort on it, then recreates the linked list.
     */
    @Override
    public void sort() {
        ArrayList<T> arrayList = new ArrayList<>(this);
        arrayList.sort();
        this.clear();
        for (int i = 0; i < arrayList.getSize(); i++) {
            this.add(arrayList.get(i));
        }
    }

    /**
     * Returns the size of the linked list.
     *
     * @return The size of the array list.
     */
    public int getSize() {
        return size;
    }

    private Node<T> getPreviousNodeByIndex(int index) {
        if (size == 0) {
            throw new IndexOutOfBoundsException("LinkedList is empty");
        }

        Node<T> currentNode = head;

        if (index == 0) {
            return head;
        }

        for (int i = 0; i < index; i++) {
            if (currentNode.getNext() == null) {
                throw new IndexOutOfBoundsException("Index is out of bounds");
            }
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }

    /**
     * Returns an iterator for our linked list.
     *
     * @return An iterator for our linked list.
     */
    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<>() {
            private Node<T> current = head.getNext();

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T element = current.getElement();
                current = current.next;
                return element;
            }
        };
        return iterator;
    }

    private static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    /**
     *
     * @return Returns a comma separated string representation of our linked list.
     */
    @Override
    public String toString() {
        Node<T> current = head.getNext();
        if (current == null){
            return "Linked list is empty";
        }
        StringBuffer stringBuffer = new StringBuffer("LinkedList { ");
        while (current.getNext() != null) {
            stringBuffer.append(current.getElement() + ", ");
            current = current.getNext();
        }
        stringBuffer.append(current.getElement());
        stringBuffer.append(" }");
        return stringBuffer.toString();
    }
}
