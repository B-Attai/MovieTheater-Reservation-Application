package Model;

public class RegularUserRefund implements UserRefundInterface{

    @Override
    public double refund(double amount) {
            return amount*0.85; //Applying 15% penalty
    }
}
