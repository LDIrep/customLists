package ru.ldi.List.ArrayList;

import ru.ldi.List.Interface.List;

public class ArrayListRunner {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();

        try {
            integers.get(0);
        } catch (IllegalArgumentException e) {
            System.out.println("The array list is empty");
        }

        System.out.println("\nAdd elements");

        for (int i = 0; i < 24; i++) {
            integers.add(i);
        }

        System.out.println("\nSelect elements using get method");

        System.out.print(integers.get(0) + " ");
        System.out.print(integers.get(1) + " ");
        System.out.print(integers.get(2) + " ");

        System.out.println("\n\nIterating over array list");
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

        System.out.println("\n\nCall the toString method of the array list");
        System.out.println(integers);

        System.out.println("\nClear the collection");
        integers.clear();
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }

        System.out.println();
        System.out.println(integers);
    }
}
