package Controller;

import Model.Payment;
import Model.User;

public class RefundController {

    private Payment payment;
    private User user;

    //Constructor
    public RefundController(User user, Payment payment){
        setUser(user);
        setPayment(payment);
    }

    //Perform the refund
    public double performRefund(String bookingReference){
        double refundAmount = payment.performRefund(user, bookingReference);
        return refundAmount;
    }

    //Getters and Setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
