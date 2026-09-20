package com.amigoscode._5_generics._4_genericmethods;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Exercise: Generic Methods
 *
 * This exercise focuses on writing static generic methods.
 * Generic methods declare their own type parameters independently
 * of any generic class. The type parameter appears before the return type.
 *
 * Complete the TODOs below.
 */
public class GenericMethods {

    // TODO: 1 - Create a static generic method: <T> void printArray(T[] array)
    //  It should print each element of the array on the same line separated
    //  by spaces, then print a newline at the end.
    static <T> void printArray(T[] array) {
        Arrays.stream(array).forEach(System.out::println);
    }


    // TODO: 2 - Create a static generic method: <T> T getFirst(List<T> list)
    //  It should return the first element of the list.
    //  If the list is empty, return null.
    static <T> T getFirst(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.getFirst();
    }

    // TODO: 3 - Create a static generic method: <T> T getLast(List<T> list)
    //  It should return the last element of the list.
    //  If the list is empty, return null.
    static <T> T getLast(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.getLast();
    }


    // TODO: 4 - Create a static generic method: <T> List<T> filterNulls(List<T> list)
    //  It should return a new list containing only the non-null elements
    //  from the original list. Do not modify the original list.
    static <T> List<T> filterNulls(List<T> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .toList();
    }


    // TODO: 5 - Create a static generic method: <T> boolean contains(T[] array, T target)
    //  It should return true if the target is found in the array.
    //  Use the equals() method for comparison (handle null target).
    static <T> boolean contains(T[] array, T target) {
        return Arrays.asList(array).contains(target);
    }


    static void main(String[] args) {

        // TODO: 6 - Call all five methods above:
        //  (a) printArray with a String[] and an Integer[]
        //  (b) getFirst and getLast with a List<String> of names
        //  (c) filterNulls with a list that contains some null values
        //  (d) contains to search for an element in an array

        String[] strings = new String[]{"d", "fsdfsdf", "dfs214", null};
        Integer[] integers = new Integer[]{null, 1, 3213, 545, 5643, null};
        GenericMethods.printArray(strings);
        GenericMethods.printArray(integers);
        System.out.println("-------------------------");
        System.out.println(GenericMethods.getFirst(Arrays.asList(strings)));
        System.out.println(GenericMethods.getFirst(Arrays.asList(integers)));
        System.out.println("-------------------------");
        System.out.println(GenericMethods.getLast(Arrays.asList(strings)));
        System.out.println(GenericMethods.getLast(Arrays.asList(integers)));
        System.out.println("-------------------------");
        System.out.println(GenericMethods.filterNulls(Arrays.asList(strings)));
        System.out.println(GenericMethods.filterNulls(Arrays.asList(integers)));
        System.out.println("-------------------------");
        System.out.println(GenericMethods.contains(strings, "d"));
        System.out.println(GenericMethods.contains(integers, 1));
        System.out.println("-------------------------");
        System.out.println(GenericMethods.contains(strings, "z"));
        System.out.println(GenericMethods.contains(integers, 10000));








        // TODO: 7 - Demonstrate type inference: call printArray and contains
        //  WITHOUT explicitly specifying the type parameter (i.e., just call
        //  printArray(myArray) instead of GenericMethods.<String>printArray(myArray)).
        //  Add a comment explaining that the compiler infers T from the arguments.

    }
}
