package model;

import java.util.ArrayList;

public class Showroom {

    private ArrayList<Seat> seatList;
    private int showroomNumber;

    //Constructor
    public Showroom(int showroomNumber, ArrayList<Seat> seatList) {
        this.showroomNumber = showroomNumber;
        this.seatList = seatList;
    }

    //Temporary method to get the seat mapping formatted in a string
//    public String getSeatList() {
//        StringBuilder sb = new StringBuilder();
//        StringBuilder sb2 = new StringBuilder();
//        int counter = 0;
//        for(int i = 0; i < sqrt(seatList.size()); i++){
//            for (int j = 0; j < sqrt(seatList.size()); j++){
//                sb.append(seatList.get(counter));
//                counter++;
//            }
//            sb2.append("\n" + sb);
//            sb.setLength(0);
//        }
//        return sb2.toString();
//    }


    //Always check seat state before setting a new seat state
    public boolean getSeatState(int seatNumber){
        if(seatList.get(seatNumber).getState() == 0){
            return false;
        }
        else return true;
    }

    //Book a seat and change the seat state
    public void bookASeat(int seatNumber){
        seatList.get(seatNumber-1).bookSeat(); // -1 for the 0 index on the seatList
        System.out.println("Seat " + seatNumber + " booked!");
    }

    //Unbook a seat and change the seat state
    //TODO: Needs to be implemented in Payment/Theater
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
