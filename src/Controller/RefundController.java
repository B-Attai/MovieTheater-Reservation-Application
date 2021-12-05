//package Controller;
//
//import Model.Payment;
//import Model.User;
//
//public class RefundController {
//
//    private Payment payment;
//    private User user;
//
//    //Constructor
//    public RefundController(User user, Payment payment){
//        setUser(user);
//        setPayment(payment);
//    }
//
//    //Perform the refund
//    public void performRefund(int bookingReference) throws Exception {
//        double amount = 15.;
//        payment.performRefund(bookingReference, amount);
//        System.out.println("Debugging: refund in RefundController called!");
//    }
//
//    //Getters and Setters
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Payment getPayment() {
//        return payment;
//    }
//
//    public void setPayment(Payment payment) {
//        this.payment = payment;
//    }
//}
