package model;

public class RegularUserRefund implements UserRefundInterface{

    @Override
    public double refund(double amount) {
        System.out.println("refunded with 85%");
            return amount*0.85; //Applying 15% penalty
    }
}
