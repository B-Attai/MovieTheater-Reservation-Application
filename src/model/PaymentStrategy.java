package model;

public interface PaymentStrategy {
    boolean makePayment(long accountID, double amount);
}
