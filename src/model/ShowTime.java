package model;

import java.util.HashMap;

public class ShowTime {
    // format"dd-MM-yy"
    private final String date;
    // Showroom and hour are stored
    private HashMap<Integer, TheaterShowRooms> showDateSchedule = new HashMap<>();

    public ShowTime(String date, HashMap<Integer, TheaterShowRooms> showDateSchedule) {
        this.date = date;
        this.showDateSchedule = showDateSchedule;
    }

    public ShowTime(String date) {
        this.date = date;
        this.showDateSchedule = new HashMap<>();
    }

    public void addTimeSlot(TheaterShowRooms showrooms){
        showDateSchedule.put(showrooms.getHour(), showrooms);
    }

    public TheaterShowRooms getShowRoomByHour(Integer hour){
        return showDateSchedule.get(hour);
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Integer i:showDateSchedule.keySet()){
            result.append("\nShowTime: ").append(i);
        }
        return result.toString();
    }

    public HashMap<Integer, TheaterShowRooms> getShowDateSchedule() {
        return showDateSchedule;
    }
}
