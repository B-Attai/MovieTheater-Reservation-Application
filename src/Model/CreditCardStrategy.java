package Model;

public class CreditCardStrategy implements PaymentStrategy{

    @Override
    public boolean makePayment(long accountID, double amount) {
        //Simple checks for account id and amount
        if(accountID != 0 && amount > 0) {

            // This should send a message to payment object
            System.out.println("Credit Card Payment strategy successful!");
            return true;
        }else{
            System.out.println("Payment strategy unsuccessful.");
            return false;
        }
    }
}
