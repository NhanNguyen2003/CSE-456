package vn.edu.eiu.data;

public class BankTransferPayment implements PaymentMethod {
    @Override
    public void makePayment(double amount) {
        System.out.println("Processing bank transfer payment of $" + amount);
    }
}
