package ru.ldi.List.LinkedList;

import ru.ldi.List.Interface.List;

public class LinkedListRunner {
    public static void main(String[] args) {
        List<Integer> integers = new LinkedList<>();

        try {
            integers.get(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The linked List is empty");
        }

        System.out.println("\nAdd elements");

        integers.add(5);
        integers.add(8);
        integers.add(1);

        System.out.println("\nSelect elements using get method");

        System.out.print(integers.get(0) + " ");
        System.out.print(integers.get(1) + " ");
        System.out.print(integers.get(2) + " ");

        System.out.println("\n\nIterating over linked list");
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }

        System.out.println("\n\nAdd element at index 3");
        integers.add(9, 3);
        System.out.println("Element at index 3: " + integers.get(3));
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }

        System.out.println("\n\nDelete element at index 1");
        integers.removeElement(1);
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }

        System.out.println("\n\nSorting the collection in ascending order");
        integers.sort();
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }

        System.out.println("\n\nCall the toString method of the linked list");
        System.out.println(integers);

        System.out.println("\n\nClear the collection");
        integers.clear();

        System.out.println();
        System.out.println(integers);

    }
}
