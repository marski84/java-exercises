package com.amigoscode._3_oop._7_mixedpractice;

import java.util.List;

/**
 * Exercise: Mixed Practice - Polymorphism, Dependency Injection, SOLID
 * <p>
 * A combined set of exercises to reinforce the three previous topics.
 * 4 tasks on Polymorphism, 4 on Dependency Injection, 4 on SOLID.
 * Only skeletons/TODOs are provided — implement each one yourself.
 */
public class MixedPracticeExercises {

    // =========================================================================
    // POLYMORPHISM (4 tasks)
    // =========================================================================

    // TODO: P1 - Create an interface Animal with:
    //   - String makeSound()
    //   - default String describe() that returns "This animal says: " + makeSound()
    //   Create Dog and Cat classes implementing Animal, returning "Woof" and "Meow".
    //   In main, put both in a List<Animal> and print describe() for each,
    //   showing that the correct makeSound() runs for each concrete type.

    // TODO: P2 - Create an interface Vehicle with:
    //   - double fuelEfficiency() (returns km per liter)
    //   Create ElectricCar and PetrolCar implementing Vehicle with different
    //   values. Write a method: Vehicle mostEfficient(List<Vehicle> vehicles)
    //   that returns the vehicle with the highest fuelEfficiency() using streams.

    // TODO: P3 - Create an abstract class Employee with:
    //   - protected double baseSalary
    //   - abstract double calculateBonus()
    //   - a method double totalPay() that returns baseSalary + calculateBonus()
    //   Create Manager (bonus = 20% of baseSalary) and Developer
    //   (bonus = 10% of baseSalary) subclasses. In main, create a
    //   List<Employee> with both types and print totalPay() for each —
    //   demonstrate that the same totalPay() method produces different
    //   results depending on the actual runtime type.

    // TODO: P4 - Use instanceof pattern matching (Java 16+): write a method
    //   String classify(Object obj) that returns:
    //   - "Integer: <value squared>" if obj is an Integer
    //   - "String: <length>" if obj is a String
    //   - "Unknown type" otherwise
    //   Test it in main with a List<Object> containing an Integer, a String,
    //   and a Double, and print the classification of each.


    // =========================================================================
    // DEPENDENCY INJECTION (4 tasks)
    // =========================================================================

    // TODO: D1 - Create a Logger interface with: void log(String message).
    //   Create ConsoleLogger (prints "[Console] <message>") and
    //   FileLogger (prints "[File] <message>", simulating a file write).
    //   Create a class ReportService that receives a Logger via constructor
    //   injection and has a method generate() that logs "Report generated".
    //   In main, demonstrate swapping ConsoleLogger for FileLogger without
    //   changing ReportService.

    // TODO: D2 - Create a PriceCalculator interface with: double calculate(double base).
    //   Create StandardPricing (returns base unchanged) and
    //   DiscountedPricing (returns base * 0.9). Create a Checkout class that
    //   receives a PriceCalculator via constructor injection and a method
    //   double total(double base) delegating to the calculator.
    //   Show both pricing strategies produce different totals for the same
    //   Checkout class.

    // TODO: D3 - Create an interface Cache with:
    //   - void put(String key, String value)
    //   - String get(String key)
    //   Create an InMemoryCache implementation backed by a HashMap.
    //   Create a UserService class that receives a Cache via constructor
    //   injection with a method getUser(String id) that checks the cache
    //   first and prints "Cache hit" or "Cache miss" accordingly
    //   (on a miss, just put a dummy value and return it).

    // TODO: D4 - Create two dependencies injected into ONE class:
    //   - interface Validator with: boolean isValid(String input)
    //   - interface AuditLogger with: void record(String action)
    //   Create SimpleValidator (valid if input is not blank) and
    //   ConsoleAuditLogger (prints "[Audit] <action>").
    //   Create a RegistrationService that takes both via constructor
    //   injection and a method register(String username): validates the
    //   username, logs "Registered: <username>" on success via the audit
    //   logger, or logs "Rejected: <username>" on failure.


    // =========================================================================
    // SOLID (4 tasks)
    // =========================================================================

    static void main(String[] args) {
        System.out.println("=== Mixed Practice Exercises ===");
        System.out.println("Implement each TODO above, then test it here in main.");

        // TODO: 1 - Test all 4 Polymorphism exercises (P1-P4) here.

        // TODO: 2 - Test all 4 Dependency Injection exercises (D1-D4) here.

        // TODO: 3 - Test all 4 SOLID exercises (S1-S4) here.
    }

    // TODO: S1 - SRP: The class InvoicePrinterBroken below calculates an
    //   invoice total AND formats/prints it AND would also need to change
    //   if the print format changes. Refactor it into:
    //   - InvoiceCalculator with: double calculateTotal(List<Double> items)
    //   - InvoicePrinter with: void print(double total)
    //   - Invoice class that uses both via constructor injection and has
    //     a method process(List<Double> items)
    static class InvoicePrinterBroken {
        void printInvoice(List<Double> items) {
            double total = items.stream().mapToDouble(Double::doubleValue).sum();
            System.out.println("Invoice total: $" + total);
        }
    }

    // TODO: S3 - LSP: Create a Bird interface with: void move().
    //   The temptation is to make Penguin extend a base class that assumes
    //   flight (e.g. a fly() method every bird must implement, even though
    //   penguins can't fly). Instead design it correctly:
    //   - Bird interface with: void move()
    //   - FlyingBird interface (extends Bird or standalone) with: void fly()
    //   - Sparrow implements FlyingBird (move() walks/hops, fly() flies)
    //   - Penguin implements Bird only (move() means "waddle")
    //   Show in main that a List<Bird> can hold both without any class being
    //   forced to implement behavior it cannot support.

    // TODO: S4 - ISP + DIP combined: Design a small plugin system.
    //   - Create a narrow interface Startable with: void start()
    //   - Create a narrow interface Stoppable with: void stop()
    //   - Create a Service class implementing BOTH Startable and Stoppable
    //     (e.g. prints "Service started" / "Service stopped")
    //   - Create a ServiceRunner class that depends only on Startable in
    //     its constructor (DIP: depends on the abstraction it actually
    //     needs, not the full Service) and has a method run() that calls
    //     start(). This shows a class should depend only on the interface
    //     methods it actually uses, not a fat interface with everything.

    // TODO: S2 - OCP: The class ShippingCostBroken below uses if/else on a
    //   String type, requiring modification for every new shipping method.
    //   Refactor using a ShippingStrategy interface with: double cost(double weight).
    //   Create StandardShipping (weight * 2.0) and ExpressShipping (weight * 5.0).
    //   Create a ShippingCalculator that takes a ShippingStrategy via
    //   constructor injection and delegates to it — no more if/else needed
    //   to add a new shipping method.
    static class ShippingCostBroken {
        double cost(String type, double weight) {
            if ("STANDARD".equals(type)) return weight * 2.0;
            if ("EXPRESS".equals(type)) return weight * 5.0;
            return 0;
        }
    }
}
