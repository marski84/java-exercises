package com.amigoscode._3_oop._4_polymorphism;

import com.amigoscode._3_oop._3_abstractclasses.Circle;
import com.amigoscode._3_oop._3_abstractclasses.Rectangle;
import com.amigoscode._3_oop._3_abstractclasses.Shape;

import java.util.Comparator;
import java.util.List;

/**
 * Exercise: Polymorphism - Shape Calculator
 *
 * Use polymorphism to write methods that work with any Shape.
 * Because Circle and Rectangle both extend Shape, a single method
 * can handle both — and any future Shape subclass — without modification.
 *
 * Key concepts:
 * - Methods that accept a supertype parameter
 * - Polymorphic collections (List<Shape>)
 * - instanceof with pattern matching (Java 16+)
 * - Open/closed principle in practice
 *
 * Prerequisites: Complete Shape.java, Circle.java, and Rectangle.java first.
 */
public class ShapeCalculator {

    static void main(String[] args) {
        // Complete TODO 6 here.
        List<Shape> shapes = List.of(
                new Circle(10.00),
                new Circle(90.00),
                new Rectangle(43.0, 80.0),
                new Rectangle(99.0, 21.0)
        );

        ShapeCalculator shapeCalculator = new ShapeCalculator();
        System.out.println("total area: " + shapeCalculator.totalArea(shapes));
        System.out.println("---------------------");
        System.out.println("summary: " + shapeCalculator.formatSummary(shapes));

        System.out.println("---------------------");
        System.out.println("largest: " + shapeCalculator.largestShape(shapes));
        System.out.println("---------------------");
        shapes.forEach(shapeCalculator::printShapeArea);
        System.out.println("---------------------");
        shapes.forEach(s -> System.out.println(shapeCalculator.describeShape(s)));
    }

    // TODO: 1 - Create a method: void printShapeArea(Shape shape)
    //   Print: "The <className> has an area of <area>"
    //   Use shape.getClass().getSimpleName() to get the class name.
    //   Use String.format("%.2f", shape.area()) for formatting.
    public void printShapeArea(Shape shape) {
        String shapeName = shape.getClass().getSimpleName();
        System.out.println("The " + shapeName + " has an area of " +
                String.format("%.2f", shape.area()));
    }

    // TODO: 2 - Create a method: double totalArea(List<Shape> shapes)
    //   Iterate over all shapes and return the sum of their areas.
    public double totalArea(List<Shape> shapes) {
        return shapes.stream()
                .map(Shape::area)
                .reduce(0.0, Double::sum);
    }

    // TODO: 3 - Create a method: Shape largestShape(List<Shape> shapes)
    //   Return the shape with the largest area.
    //   If the list is empty, return null.
    public Shape largestShape(List<Shape> shapes) {
        return shapes.stream()
                .max(Comparator.comparing(Shape::area))
                .orElse(null);
    }

    // TODO: 4 - Create a method: String describeShape(Shape shape)
    //   Use instanceof with pattern matching (Java 16+) to return
    //   specific descriptions:
    //   - If shape is a Circle c: return "Circle with radius info"
    //     (just return "Circle detected with area: " + c.area())
    //   - If shape is a Rectangle r: return "Rectangle detected with area: " + r.area()
    //   - Otherwise: return "Unknown shape with area: " + shape.area()
    public String describeShape(Shape shape) {
        if (shape instanceof Circle) {
            return "Circle detected with area: " + shape.area();
        }
        if (shape instanceof Rectangle) {
            return "Rectangle detected with area: " + shape.area();
        }
        return "Unknown shape with area: " + shape.area();
    }


    // TODO: 6 - In main, create a List<Shape> with at least two Circles
    //   and two Rectangles. Call all the methods above and print results.
    //   This demonstrates polymorphism: the same method handles
    //   different shape types seamlessly.

    // TODO: 5 - Create a method: String formatSummary(List<Shape> shapes)
    //   Return a formatted summary string like:
    //   "Summary: <N> shapes, total area: <totalArea>, largest area: <largestArea>"
    //   Use the totalArea() and largestShape() methods you already wrote.
    public String formatSummary(List<Shape> shapes) {
        double totalArea = this.totalArea(shapes);
        Shape max = this.largestShape(shapes);

        return shapes.size() + "shapes, total area: " + totalArea +
                ", largest area: " + max;
    }
}
