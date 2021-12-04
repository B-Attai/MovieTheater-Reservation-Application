package Model;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class Showroom {

    private List<Seat> seatList;
    private int showroomNumber;

    //Constructor
    public Showroom(int showroomNumber) {
        this.showroomNumber = showroomNumber;
        this.seatList = loadFromSeatDB();
    }

    //Temporary method to get the seat mapping formatted in a string
    public String getSeatList() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int counter = 0;
        for(int i = 0; i < sqrt(seatList.size()); i++){
            for (int j = 0; j < sqrt(seatList.size()); j++){
                sb.append(seatList.get(counter));
                counter++;
            }
            sb2.append("\n" + sb);
            sb.setLength(0);
        }
        return sb2.toString();
    }


    //Always check seat state before setting a new seat state
    public boolean getSeatState(int seatNumber){
        if(seatList.get(seatNumber).getState() == 0){
            return false;
        }
        else return true;
    }

    //Book a seat and change the seat state
    public void bookASeat(int seatNumber){
        seatList.get(seatNumber-1).setState(1); // -1 for the 0 index on the seatList
        System.out.println("Seat " + seatNumber + " booked!");
    }

    //Unbook a seat and change the seat state
    //TODO: Needs to be implemented in Payment/Theater
    public void unbookASeat(int seatNumber){
        seatList.get(seatNumber-1).setState(0); // -1 for the 0 index on the seatList
        System.out.println("Seat " + seatNumber + " unbooked!");
    }

    //Getters and Setters
    public int getShowroomNumber() {
        return showroomNumber;
    }

    public void setShowroomNumber(int showroomNumber) {
        this.showroomNumber = showroomNumber;
    }

    //Overridden toString, can be formatted as required
    @Override
    public String toString() {
        return "showroomNumber=" + showroomNumber;

    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    //Temporary seat database
    private static List<Seat> loadFromSeatDB(){
        List<Seat> testSeatDB = new ArrayList();

        testSeatDB.add(new Seat(1, 0, 0));
        testSeatDB.add(new Seat(2, 0, 1));
        testSeatDB.add(new Seat(3, 0, 2));
        testSeatDB.add(new Seat(4, 0, 3));
        testSeatDB.add(new Seat(5, 1, 0));
        testSeatDB.add(new Seat(6, 1, 1));
        testSeatDB.add(new Seat(7, 1, 2));
        testSeatDB.add(new Seat(8, 1, 3));
        testSeatDB.add(new Seat(9, 2, 0));
        testSeatDB.add(new Seat(10, 2, 1));
        testSeatDB.add(new Seat(11, 2, 2));
        testSeatDB.add(new Seat(12, 2, 3));
        testSeatDB.add(new Seat(13, 3, 0));
        testSeatDB.add(new Seat(14, 3, 1));
        testSeatDB.add(new Seat(15, 3, 2));
        testSeatDB.add(new Seat(16, 3, 3));
        return testSeatDB;
    }
}
