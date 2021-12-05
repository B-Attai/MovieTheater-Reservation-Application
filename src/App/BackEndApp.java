//package App;
//
//import Controller.*;
//import Model.*;
//
//import java.util.Scanner;
//
//public class BackEndApp {
//
//    //Test methods to Command Line to check functionality
//    public static void main(String[] args) {
//
//        User user = new RegisteredUser("Test", "TestAddress", "TestAccountNumber", "test@test.com");
//
//        MovieController movieController = new MovieController();
//        System.out.println("Movie Search Test: " + movieController.searchMovieName("Home Alone") + "\n");
//
//        System.out.println("Movie Search List Test: " + movieController.searchMovieList() +"\n");
//
//        System.out.println("Movie Showtimes Search Test: " + movieController.searchMovieShowtimes() + "\n");
//
//        System.out.println("Movie Seats Search Test: " + movieController.searchTheaterSeats(1) + "\n");
//
////        TicketController ticketController = new TicketController(user);
//        ticketController.setUser(user);
//
//        System.out.println("Testing Payment...\n");
////        ticketController.makePayment(100, 100, "John Wick 3", 1, 1);
//
//        System.out.println("\nTesting Seats Search after Payment: " + movieController.searchTheaterSeats(1) + "\n");
//
//
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("\nEnter booking reference number");
//
//        String input = myObj.nextLine();  // Read user input
//        System.out.println(input);
////        System.out.println("\n" + "Booking Info: " + ticketController.getPayment().getTheater().getABooking(input));  // Output user input
//
//        RefundController refundController = new RefundController(user, ticketController.getPayment());
////        System.out.println(refundController.performRefund(input));
//
//        System.out.println("\nTesting Seats Search after Refund: " + movieController.searchTheaterSeats(1) + "\n");
//
//
//    }
//}
