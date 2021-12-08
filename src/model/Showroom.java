package model;

import java.util.ArrayList;

/**
 * Showroom object that stores the seats
 * @author Amir Abbaspour, Brandon Attai
 */
public class Showroom {

    private ArrayList<Seat> seatList;
    private int showroomNumber;

    //Constructor
    public Showroom(int showroomNumber, ArrayList<Seat> seatList) {
        this.showroomNumber = showroomNumber;
        this.seatList = seatList;
    }

    /**
     * Book a seat and change the seat state
     * @param seatNumber the number of the seat that will be booked
     */
    public void bookASeat(int seatNumber){
        seatList.get(seatNumber-1).bookSeat(); // -1 for the 0 index on the seatList
        System.out.println("Seat " + seatNumber + " booked!");
    }

    /**
     * Unbook a seat and change the seat state
     * @param seatNumber the number of the seat to un book
     */
    public void unbookASeat(int seatNumber){
        seatList.get(seatNumber-1).unbookSeat(); // -1 for the 0 index on the seatList
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

    public void setSeatList(ArrayList<Seat> seatList) {
        this.seatList = seatList;
    }

    public int getNumberOfSeats(){
        return seatList.size();
    }

    public ArrayList<Seat> getSeatList() {
        return seatList;
    }
}
