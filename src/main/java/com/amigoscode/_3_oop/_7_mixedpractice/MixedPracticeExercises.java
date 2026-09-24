package com.amigoscode._3_oop._7_mixedpractice;

import java.util.ArrayList;
import java.util.HashMap;
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

    public static String classify(Object o) {
        if (o instanceof Integer) {
            return "Integer: " + Math.sqrt(((Integer) o).doubleValue());
        }
        if (o instanceof String) {
            return "String: lenght= " + ((String) o).length();
        }
        return "Unknown type";
    }

    static void main(String[] args) {
        System.out.println("=== Mixed Practice Exercises ===");
        System.out.println("Implement each TODO above, then test it here in main.");

        // TODO: 1 - Test all 4 Polymorphism exercises (P1-P4) here.
//        Animal dog = new Dog();
//        Animal cat = new Cat();
//        Stream.of(dog, cat).forEach(Animal::describe);
//
//        CarProps petrolCar = new PetrolCar();
//        CarProps electricCar = new ElectricCar();
//
//        CarProps maxEfficency = Stream.of(petrolCar, electricCar)
//                .max(Comparator.comparing(CarProps::fuelEfficency)
//        ).orElse(null);
//
//        System.out.println(String.valueOf(maxEfficency));
//
//        Manager manager = new Manager(100.00);
//        Developer developer = new Developer(50.0);
//
//        List.of(manager, developer).forEach(e -> System.out.println(e.totalPay()));
//
//        List.of("test", 11, 55.5)
//                .forEach(e ->
//                                System.out.println(classify(e))
//                );
//


        // TODO: 2 - Test all 4 Dependency Injection exercises (D1-D4) here.
//        ConsoleLogger consoleLogger = new ConsoleLogger();
//        FileLogger fileLogger = new FileLogger();
//
//        ReportService consoleReportService = new ReportService(consoleLogger);
//        ReportService fileReportService = new ReportService(fileLogger);
//
//        consoleReportService.generate();
//        fileReportService.generate();
//
//        StandardPricing standardPricing = new StandardPricing();
//        DiscountPricing discountPricing = new DiscountPricing();
//
//        Checkout checkout = new Checkout(standardPricing);
//        Checkout discountCheckout = new Checkout(discountPricing);
//
//        System.out.println(checkout.total(50.00));
//        System.out.println(discountCheckout.total(50.00));

//
//        InMemoryCache inMemoryCache = new InMemoryCache();
//        UserService userService = new UserService(inMemoryCache);
//        userService.getUser("1");
//        inMemoryCache.put("2", "test");
//        userService.getUser("2");
//
//        ConsoleAuditLogger consoleAuditLogger = new ConsoleAuditLogger();
//        SimpleValidator simpleValidator = new SimpleValidator();
//
//        RegistrationService registrationService = new RegistrationService(simpleValidator, consoleAuditLogger);
//        registrationService.registerUser("");
//        registrationService.registerUser("okok");
//

        Penguin penguin = new Penguin();
        Sparrow sparrow = new Sparrow();

        List<Bird> birds = new ArrayList<>();
        birds.add(penguin);
        birds.add(sparrow);



        // TODO: 3 - Test all 4 SOLID exercises (S1-S4) here.
    }

    // TODO: P1 - Create an interface Animal with:
    //   - String makeSound()
    //   - default String describe() that returns "This animal says: " + makeSound()
    //   Create Dog and Cat classes implementing Animal, returning "Woof" and "Meow".
    //   In main, put both in a List<Animal> and print describe() for each,
    //   showing that the correct makeSound() runs for each concrete type.
    public interface Animal {
        String makeSound();

        default String describe() {
            System.out.println("This animal says " + makeSound());
            return "This animal says " + makeSound();
        }
    }

    // TODO: P2 - Create an interface Vehicle with:
    //   - double fuelEfficiency() (returns km per liter)
    //   Create ElectricCar and PetrolCar implementing Vehicle with different
    //   values. Write a method: Vehicle mostEfficient(List<Vehicle> vehicles)
    //   that returns the vehicle with the highest fuelEfficiency() using streams.

    interface CarProps {
        double fuelEfficency();
    }

    interface Logger {
        void log(String message);
    }

    interface PriceCalculator {
        double calculate(double base);
    }

    // TODO: P3 - Create an abstract class Employee with:
    //   - protected double baseSalary
    //   - abstract double calculateBonus()
    //   - a method double totalPay() that returns baseSalary + calculateBonus()
    //   Create Manager (bonus = 20% of baseSalary) and Developer
    //   (bonus = 10% of baseSalary) subclasses. In main, create a
    //   List<Employee> with both types and print totalPay() for each —
    //   demonstrate that the same totalPay() method produces different
    //   results depending on the actual runtime type.

    // TODO: D3 - Create an interface Cache with:
    //   - void put(String key, String value)
    //   - String get(String key)
    //   Create an InMemoryCache implementation backed by a HashMap.
    //   Create a UserService class that receives a Cache via constructor
    //   injection with a method getUser(String id) that checks the cache
    //   first and prints "Cache hit" or "Cache miss" accordingly
    //   (on a miss, just put a dummy value and return it).
    interface Cache {
        void put(String key, String value);

        String get(String key);
    }

    interface Validator {
        boolean isValid(String input);
    }

    interface AuditLogger {
        void record(String action);
    }

    // TODO: P4 - Use instanceof pattern matching (Java 16+): write a method
    //   String classify(Object obj) that returns:
    //   - "Integer: <value squared>" if obj is an Integer
    //   - "String: <length>" if obj is a String
    //   - "Unknown type" otherwise
    //   Test it in main with a List<Object> containing an Integer, a String,
    //   and a Double, and print the classification of each.

    interface Calculator {
        double calculate(List<Double> items);
    }


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

    interface Printer {
        void print(String msg);
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
    interface Bird {
        void move();
    }

    interface FlyingBird extends Bird {
        void fly();
    }

    interface Startable {
        void start();
    }
    // TODO: D2 - Create a PriceCalculator interface with: double calculate(double base).
    //   Create StandardPricing (returns base unchanged) and
    //   DiscountedPricing (returns base * 0.9). Create a Checkout class that
    //   receives a PriceCalculator via constructor injection and a method
    //   double total(double base) delegating to the calculator.
    //   Show both pricing strategies produce different totals for the same
    //   Checkout class.

    interface Stopable {
        void stop();
    }

    interface ShippingStrategy {
        double cost(double weight);
    }

    static class Dog implements Animal {

        @Override
        public String makeSound() {
            return "dog dog";
        }
    }

    static class Cat implements Animal {

        @Override
        public String makeSound() {
            return "cat";
        }
    }

    static class PetrolCar implements CarProps {

        @Override
        public double fuelEfficency() {
            return 1.0;
        }

        @Override
        public String toString() {
            return "PetrolCar{}";
        }
    }

    static class ElectricCar implements CarProps {

        @Override
        public double fuelEfficency() {
            return 2.5;
        }

        @Override
        public String toString() {
            return "ElectricCar{}";
        }
    }

    static abstract class Employee {
        protected double baseSalary;

        protected abstract double calculateBonus();

        public double totalPay() {
            return baseSalary + calculateBonus();
        }
    }
    // TODO: D4 - Create two dependencies injected into ONE class:
    //   - interface Validator with: boolean isValid(String input)
    //   - interface AuditLogger with: void record(String action)
    //   Create SimpleValidator (valid if input is not blank) and
    //   ConsoleAuditLogger (prints "[Audit] <action>").
    //   Create a RegistrationService that takes both via constructor
    //   injection and a method register(String username): validates the
    //   username, logs "Registered: <username>" on success via the audit
    //   logger, or logs "Rejected: <username>" on failure.

    static class Manager extends Employee {

        Manager(double salary) {
            this.baseSalary = salary;
        }

        @Override
        protected double calculateBonus() {
            return baseSalary * 0.2;
        }
    }

    public static class Developer extends Employee {

        Developer(double salary) {
            this.baseSalary = salary;
        }

        @Override
        protected double calculateBonus() {
            return this.baseSalary * 0.1;
        }
    }

    static class ConsoleLogger implements Logger {

        @Override
        public void log(final String message) {
            System.out.println("[Console] message: " + message);
        }
    }

    static class FileLogger implements Logger {
        @Override
        public void log(final String message) {
            System.out.println("[File] message: " + message);
        }
    }

    static class ReportService {
        private final Logger logger;

        ReportService(final Logger logger) {
            this.logger = logger;
        }

        public void generate() {
            logger.log("report generated");
        }


    }
    // =========================================================================
    // SOLID (4 tasks)
    // =========================================================================

    static class StandardPricing implements PriceCalculator {

        @Override
        public double calculate(final double base) {
            return base;
        }
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

    static class DiscountPricing implements PriceCalculator {

        @Override
        public double calculate(final double base) {
            return base * 0.9;
        }
    }

    static class Checkout {
        private final PriceCalculator priceCalculator;

        Checkout(final PriceCalculator priceCalculator) {
            this.priceCalculator = priceCalculator;
        }

        public double total(double base) {
            return priceCalculator.calculate(base);
        }
    }

    static class InMemoryCache implements Cache {
        HashMap<String, String> cache = new HashMap<>();

        @Override
        public void put(final String key, final String value) {
            cache.put(key, value);
        }

        @Override
        public String get(final String key) {
            return cache.get(key);
        }
    }

    static class UserService {
        private final Cache cache;

        UserService(final Cache cache) {
            this.cache = cache;
        }

        void getUser(String id) {
            if (cache.get(id) == null) {
                System.out.println("cache miss");
            }
            System.out.println("cache pass");

        }
    }

    static class SimpleValidator implements Validator {

        @Override
        public boolean isValid(final String input) {
            return input.isBlank();
        }
    }

    static class ConsoleAuditLogger implements AuditLogger {

        @Override
        public void record(final String action) {
            System.out.println("[Audit]: " + action);
        }
    }

    static class RegistrationService {
        private final Validator validator;
        private final AuditLogger auditLogger;


        RegistrationService(final Validator validator, final AuditLogger auditLogger) {
            this.validator = validator;
            this.auditLogger = auditLogger;
        }

        public void registerUser(String userName) {
            boolean valid = validator.isValid(userName);
            if (!valid) {
                auditLogger.record("userName invalid.");
                return;
            }
            auditLogger.record("userName valid. Registering user");
        }
    }

    static class Sparrow implements FlyingBird {

        @Override
        public void fly() {
            System.out.println("fruuu");
        }

        @Override
        public void move() {
            System.out.println("tup tup");
        }
    }

    static class Penguin implements Bird {

        @Override
        public void move() {
            System.out.println("tup tup pingwin");
        }
    }
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

    class InvoiceCalculator implements Calculator {

        @Override
        public double calculate(final List<Double> items) {
            return items.stream().mapToDouble(Double::doubleValue).sum();
        }
    }

    class InvoicePrinter implements Printer {

        @Override
        public void print(final String msg) {
            System.out.println("[Invoice printer] : " + msg);
        }
    }

    class InvoicePrinterFixed {
        private final Calculator calculator;
        private final Printer printer;

        InvoicePrinterFixed(final Calculator calculator, final Printer printer) {
            this.calculator = calculator;
            this.printer = printer;
        }

        void processInvoices(List<Double> items) {
            double calculated = calculator.calculate(items);
            printer.print("invoices sume: " + calculated);
        }
    }

    class RunnerService implements Startable, Stopable {

        @Override
        public void start() {
            System.out.println("start");
        }

        @Override
        public void stop() {
            System.out.println("stop");
        }
    }

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

    class ServiceRunner implements Startable {

        private final Startable startable;

        ServiceRunner(final Startable startable) {
            this.startable = startable;
        }

        @Override
        public void start() {
            startable.start();
        }
    }

    class StandardShipping implements ShippingStrategy {

        @Override
        public double cost(final double weight) {
            return weight * 2;
        }
    }

    class ExpressShipping implements ShippingStrategy {

        @Override
        public double cost(final double weight) {
            return weight * 5;
        }
    }

    class ShippingCalculator {
        private final ShippingStrategy shippingStrategy;

        ShippingCalculator(final ShippingStrategy shippingStrategy) {
            this.shippingStrategy = shippingStrategy;
        }

        public double calculate(double weight) {
            return shippingStrategy.cost(weight);
        }
    }
}
