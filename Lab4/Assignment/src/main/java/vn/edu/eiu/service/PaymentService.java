package vn.edu.eiu.service;

import vn.edu.eiu.data.PaymentMethod;

public class PaymentService {
    // Single Responsibility Principle: Handles only the payment processing logic
    private PaymentMethod paymentMethod;

    // Constructor Dependency Injection
    public PaymentService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(double amount) {
        paymentMethod.makePayment(amount);
    }
}
