package com.amigoscode._3_oop._4_polymorphism;

import java.util.List;

/**
 * Exercise: Polymorphism - Payment Processing
 *
 * Build a payment processing system using interfaces and polymorphism.
 * Multiple payment methods implement the same interface, allowing
 * the processor to handle any payment type without knowing the details.
 *
 * Key concepts:
 * - Defining interfaces
 * - Multiple classes implementing the same interface
 * - Runtime polymorphism (method dispatch)
 * - Programming to an interface, not an implementation
 * - Default methods in interfaces
 */

// TODO: 1 - Create a Payment interface with:
//   - A method: boolean processPayment(double amount)
//   - A method: String getPaymentMethod()
//   - A default method: void printReceipt(double amount) that prints:
//     "Receipt: $<amount> paid via <getPaymentMethod()>"
//     Default methods provide a body in the interface itself.
interface Payment {
    boolean processPayment(double amount);

    String getPaymentMethod();

    default void printReceipt(double amount) {
        System.out.println("Receipt: $<amount> paid via" + getPaymentMethod());
    }
}

// TODO: 5 - Create a PaymentProcessor class with a method:
//   void processAllPayments(List<Payment> payments, double amount)
//   Iterate over the list and call processPayment(amount) on each.
//   After each payment, call printReceipt(amount).
interface IPaymentProcessor {
    void processAllPayments(List<Payment> payments, double amount);
}

// TODO: 2 - Create a CreditCardPayment class that implements Payment.
//   - Add a private field: cardNumber (String)
//   - Create a constructor that takes the cardNumber
//   - Implement processPayment() to print:
//     "Processing credit card payment of $<amount> with card <cardNumber>"
//     and return true
//   - Implement getPaymentMethod() to return "Credit Card"
class CreditCardPayment implements Payment {

    private final String cardNumber;
    private final String PAYMENT_METHOD = "Credit Card";

    CreditCardPayment(final String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean processPayment(final double amount) {
        System.out.println("Processing credit card payment of " + amount + " with card " + cardNumber);
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return PAYMENT_METHOD;
    }
}

// TODO: 3 - Create a PayPalPayment class that implements Payment.
//   - Add a private field: email (String)
//   - Create a constructor that takes the email
//   - Implement processPayment() to print:
//     "Processing PayPal payment of $<amount> from <email>"
//     and return true
//   - Implement getPaymentMethod() to return "PayPal"
class PayPalPayment implements Payment {
    private final String email;
    private final String PAYMENT_METHOD = "Paypal";

    PayPalPayment(final String email) {
        this.email = email;
    }

    @Override
    public boolean processPayment(final double amount) {
        System.out.println("Processing PayPal payment of " + amount + "from " + email);
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return PAYMENT_METHOD;
    }
}

// TODO: 4 - Create a BankTransferPayment class that implements Payment.
//   - Add a private field: bankAccountId (String)
//   - Create a constructor that takes the bankAccountId
//   - Implement processPayment() to print:
//     "Processing bank transfer of $<amount> from account <bankAccountId>"
//     and return true
//   - Implement getPaymentMethod() to return "Bank Transfer"
class BankTransferPayment implements Payment {
    private final String bankAccountId;
    private final String PAYMENT_METHOD = "Bank transfer";

    BankTransferPayment(final String bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    @Override
    public boolean processPayment(final double amount) {
        System.out.println("Processing bank transfer of " + amount + " from account " + bankAccountId);
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return PAYMENT_METHOD;
    }
}

class PaymentProcessor implements IPaymentProcessor {

    @Override
    public void processAllPayments(final List<Payment> payments, final double amount) {
        for (Payment payment : payments) {
            payment.processPayment(amount);
            payment.printReceipt(amount);
        }
    }
}


class PaymentDemo {
    static void main(String[] args) {
        // TODO: 6 - Create a List<Payment> containing one of each payment type:
        //   CreditCardPayment, PayPalPayment, BankTransferPayment.
        //   Then create a PaymentProcessor and call processAllPayments().

        List<Payment> paymentList = List.of(new CreditCardPayment("12432424"),
                new PayPalPayment("okok@ok.pl"),
                new BankTransferPayment("id1332524")
        );

        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processAllPayments(paymentList, 67453.98);


        // TODO: 7 - Demonstrate runtime polymorphism:
        //   Create a Payment variable and assign different implementations to it.
        //   Call processPayment() each time and observe that the correct
        //   implementation runs based on the actual object type.
        //   Example:
        //     Payment payment = new CreditCardPayment("1234-5678");
        //     payment.processPayment(100.0);
        //     payment = new PayPalPayment("user@email.com");
        //     payment.processPayment(200.0);

        System.out.println("/n");
        System.out.println("/n");
        System.out.println("/n");
        System.out.println("/n");

        Payment ccPayment = new CreditCardPayment("24141");
        Payment ppPayment = new PayPalPayment("paypal@fdsf.com");
        Payment bpPayment = new BankTransferPayment("id878787");

        List.of(ccPayment, ppPayment, bpPayment)
                .forEach(p -> p.processPayment(44.67));

    }
}
