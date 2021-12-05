package Model;

public class RegisterUserRefund implements UserRefundInterface{

    @Override
    public double refund(double amount) {
        System.out.println("Refunded fully");
            return amount;
        }
}
