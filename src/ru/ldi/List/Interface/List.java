package ru.ldi.List.Interface;

public interface List<T> extends Iterable<T> {
    void add(T t);

    void add(T t, int index);

    T get(int index);

    void removeElement(int index);

    void clear();

    void sort();

    int getSize();
}
