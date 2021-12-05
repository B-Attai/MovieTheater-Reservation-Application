//package Model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static java.lang.Math.sqrt;
//
//public class ShowTime {
//
//    private List<Showroom> showroomList;
//    DateTime showroomTime;
//
//    //Constructor
//    public ShowTime(DateTime showTime) {
//        this.showroomTime = showTime;
//        this.showroomList = loadFromShowroomDB();
//    }
//
//
//    //Book a seat and change the seat state
//    public void bookAShowroom(int seatNumber){
//        seatList.get(seatNumber-1).setState(1); // -1 for the 0 index on the seatList
//        System.out.println("Showroom " + seatNumber + " booked!");
//    }
//
//    //Unbook a seat and change the seat state
//    //TODO: Needs to be implemented in Payment/Theater
//    public void unbookAShowroom(int seatNumber){
//        seatList.get(seatNumber-1).setState(0); // -1 for the 0 index on the seatList
//        System.out.println("Showroom " + seatNumber + " unbooked!");
//    }
//
//    //Getters and Setters
//    public int getShowroomNumber() {
//        return showroomNumber;
//    }
//
//    public void setShowroomNumber(int showroomNumber) {
//        this.showroomNumber = showroomNumber;
//    }
//
//    //Overridden toString, can be formatted as required
//    @Override
//    public String toString() {
//        return "showroomNumber=" + showroomNumber;
//
//    }
//
//    public void setShowroomList(List<Showroom> showroomList) {
//        this.showroomList = showroomList;
//    }
//
//    //Temporary showroom database
//    private static List<Showroom> loadFromShowroomDB(){
//        List<Showroom> testShowroomDB = new ArrayList();
//
//        testShowroomDB.add(new Showroom(1, 0, 0));
//        testShowroomDB.add(new Showroom(2, 0, 1));
//        testShowroomDB.add(new Showroom(3, 0, 2));
//        testShowroomDB.add(new Showroom(4, 0, 3));
//        testShowroomDB.add(new Showroom(5, 1, 0));
//        testShowroomDB.add(new Showroom(6, 1, 1));
//        testShowroomDB.add(new Showroom(7, 1, 2));
//        testShowroomDB.add(new Showroom(8, 1, 3));
//        testShowroomDB.add(new Showroom(9, 2, 0));
//        testShowroomDB.add(new Showroom(10, 2, 1));
//        testShowroomDB.add(new Showroom(11, 2, 2));
//        testShowroomDB.add(new Showroom(12, 2, 3));
//        testShowroomDB.add(new Showroom(13, 3, 0));
//        testShowroomDB.add(new Showroom(14, 3, 1));
//        testShowroomDB.add(new Showroom(15, 3, 2));
//        testShowroomDB.add(new Showroom(16, 3, 3));
//        return testShowroomDB;
//    }
//}
