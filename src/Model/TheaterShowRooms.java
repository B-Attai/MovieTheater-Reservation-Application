package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class TheaterShowRooms {

    // Showroom and their numbers
    private HashMap<Integer, Showroom> theaterShowRooms = new HashMap<>();
    private Integer hour;

    public TheaterShowRooms(int hour) {
        this.hour = hour;
        this.theaterShowRooms = new HashMap<>();
    }

    public TheaterShowRooms(int hour, ArrayList<Showroom> showrooms){
        this.hour = hour;
        this.theaterShowRooms = new HashMap<>();
        for (Showroom s:showrooms){
            theaterShowRooms.put(s.getShowroomNumber(), s);
        }
    }

    public void addShowRoom(Showroom showroom){
        theaterShowRooms.put(showroom.getShowroomNumber(), showroom);
    }

    public Showroom getShowRoomsByNumber(Integer hour){
        return theaterShowRooms.get(hour);
    }

    public Integer getHour() {
        return hour;
    }

    public ArrayList<Integer> getShowRoomsNumbers(){
        ArrayList<Integer> roomNumbers = new ArrayList<>();
        roomNumbers.addAll(theaterShowRooms.keySet());
        System.out.println(roomNumbers);
        return roomNumbers;
    }

    public ArrayList<Integer> getShowRoomNumbers(int showRoomNumber){
        ArrayList<Integer> seatNumbers = new ArrayList<>();
        for (Seat s:theaterShowRooms.get(showRoomNumber).getSeatList()){
            seatNumbers.add(s.getSeatNumber());
        }
        return seatNumbers;
    }
}
