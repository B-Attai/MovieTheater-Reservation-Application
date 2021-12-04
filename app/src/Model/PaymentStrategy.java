package Model;

public interface PaymentStrategy {

    public boolean makePayment(long accountID, double amount);

}
