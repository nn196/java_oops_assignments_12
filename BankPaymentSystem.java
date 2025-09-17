// ===================================================
// Bank Payment Processing System - Polymorphism Demo
// ===================================================

import java.util.*;

// ----- Abstract Base Class -----
abstract class Payment {
    protected double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    // Abstract method - must be overridden
    abstract void pay();

    // Compile-time Polymorphism (Overloading)
    void generateReceipt() {
        System.out.println("Receipt: Payment of $" + amount);
    }

    void generateReceipt(String customerName) {
        System.out.println("Receipt: " + customerName + " paid $" + amount);
    }
}

// ----- Derived Class 1 -----
class CreditCardPayment extends Payment {
    private String cardNumber;

    CreditCardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    @Override
    void pay() {
        System.out.println("💳 Credit Card Payment of $" + amount + " using card: " + cardNumber);
    }
}

// ----- Derived Class 2 -----
class PayPalPayment extends Payment {
    private String email;

    PayPalPayment(double amount, String email) {
        super(amount);
        this.email = email;
    }

    @Override
    void pay() {
        System.out.println("🅿️ PayPal Payment of $" + amount + " via account: " + email);
    }
}

// ----- Derived Class 3 -----
class UpiPayment extends Payment {
    private String upiId;

    UpiPayment(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }

    @Override
    void pay() {
        System.out.println("📱 UPI Payment of $" + amount + " via UPI ID: " + upiId);
    }
}

// ----- Interface for Hybrid Polymorphism -----
interface Refundable {
    void refund();
}

// ----- Class implementing interface + extending class -----
class RefundableCreditCardPayment extends CreditCardPayment implements Refundable {
    RefundableCreditCardPayment(double amount, String cardNumber) {
        super(amount, cardNumber);
    }

    @Override
    public void refund() {
        System.out.println("💰 Refund of $" + amount + " issued back to Credit Card.");
    }
}

// ----- Bank class using Polymorphism -----
class Bank {
    private List<Payment> transactions = new ArrayList<>();

    // Accepts any payment dynamically (Polymorphism)
    void processPayment(Payment p) {
        System.out.println("✅ Processing new transaction...");
        p.pay();              // Dynamic dispatch
        p.generateReceipt();  // Polymorphism (overloaded)
        transactions.add(p);
    }

    void processPayment(Payment p, String customerName) {
        System.out.println("✅ Processing new transaction...");
        p.pay();
        p.generateReceipt(customerName);
        transactions.add(p);
    }

    void showAllTransactions() {
        System.out.println("\n📊 Transaction History:");
        for (Payment p : transactions) {
            p.generateReceipt();
        }
    }
}

// ----- Super Keyword Demonstration -----
class LoggedCreditCardPayment extends CreditCardPayment {
    LoggedCreditCardPayment(double amount, String cardNumber) {
        super(amount, cardNumber);  // calling parent constructor
    }

    @Override
    void pay() {
        System.out.println("📝 Logging transaction before payment...");
        super.pay();  // calling parent method
    }
}

// ----- Main Application -----
public class BankPaymentSystem {
    public static void main(String[] args) {

        // Create Bank
        Bank bank = new Bank();

        System.out.println("===== Compile-time Polymorphism (Overloading) =====");
        Payment p1 = new CreditCardPayment(5000, "1234-5678-9876-5432");
        p1.generateReceipt();
        p1.generateReceipt("Alice");

        System.out.println("\n===== Runtime Polymorphism (Overriding + Dynamic Dispatch) =====");
        Payment p2 = new PayPalPayment(2000, "bob@example.com");
        Payment p3 = new UpiPayment(1500, "charlie@upi");

        // Store all in parent reference
        Payment[] payments = {p1, p2, p3};
        for (Payment pay : payments) {
            pay.pay();  // runtime polymorphism
        }

        System.out.println("\n===== Hybrid Polymorphism (Class + Interface) =====");
        RefundableCreditCardPayment r1 = new RefundableCreditCardPayment(7000, "1111-2222-3333-4444");
        r1.pay();
        r1.refund();

        System.out.println("\n===== Using Bank Class with Polymorphism =====");
        bank.processPayment(p1, "Alice");
        bank.processPayment(p2, "Bob");
        bank.processPayment(p3, "Charlie");
        bank.processPayment(r1, "David");

        System.out.println("\n===== Super Keyword Example =====");
        Payment demo = new LoggedCreditCardPayment(999, "4321-9999-8888-7777");
        demo.pay();

        // Show all stored transactions
        bank.showAllTransactions();
    }
}
