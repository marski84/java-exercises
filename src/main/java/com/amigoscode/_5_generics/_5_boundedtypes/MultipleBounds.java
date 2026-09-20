package com.amigoscode._5_generics._5_boundedtypes;

import java.util.Comparator;
import java.util.List;

/**
 * Exercise: Multiple Bounds
 *
 * This exercise demonstrates how a type parameter can have multiple bounds.
 * The syntax is: <T extends ClassBound & InterfaceBound1 & InterfaceBound2>
 * If a class is included, it must come first.
 *
 * Complete the TODOs below.
 */
public class MultipleBounds {

    // TODO: 2 - Create a static generic method:
    //  <T extends Comparable<T> & Printable> T findMin(List<T> list)
    //  It should return the smallest element using compareTo().
    //  If the list is empty, return null.
    //  This method requires T to be both Comparable AND Printable.
    static <T extends Comparable<T> & Printable> T findMin(List<T> list) {
        return list.stream()
                .min(Comparator.naturalOrder())
                .orElse(null);
    }

    static void main(String[] args) {

        // TODO: 4 - Create a List<Student> with at least 3 students having
        //  different grades. Call findMin() to find the student with the
        //  lowest grade. Print the result using the print() method.

        List<Student> students = List.of(
                new Student("okok", 4.6),
                new Student("zbzb", 3.7),
                new Student("foobar", 1.9)
        );

        System.out.println(findMin(students));
        students.forEach(Student::print);



        // TODO: 5 - Add a comment below explaining:
        //  (a) Why must a class bound come before interface bounds?
        //      e.g., <T extends SomeClass & SomeInterface> is valid
        //      but  <T extends SomeInterface & SomeClass> is NOT valid
//      we can extend only one class and multiple interfaces

        //  (b) Can you have multiple class bounds? Why or why not?
//      only on, because class can extend only one class
        //  (c) How many interface bounds can you have?
//        many
    }


    // TODO: 1 - Create an interface called Printable with a single method:
    //  void print();
    interface Printable {
        void print();
    }

    // TODO: 3 - Create a static inner class Student that implements both
    //  Comparable<Student> and Printable.
    //  Student should have a "name" (String) and "grade" (double) field,
    //  a constructor, compareTo() based on grade (ascending),
    //  and print() that prints "Student{name='...', grade=...}".
    //  Also override toString() with the same format as print().
    static class Student implements Comparable<Student>, Printable {
        private final String name;
        private final double grade;

        public Student(final String name, final double grade) {
            this.name = name;
            this.grade = grade;
        }

        @Override
        public void print() {
            System.out.println("Student{" +
                    "name='" + name + '\'' +
                    ", grade=" + grade +
                    '}');
        }

        @Override
        public int compareTo(final Student o) {
            return Double.compare(grade, o.grade);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", grade=" + grade +
                    '}';
        }
    }
}
