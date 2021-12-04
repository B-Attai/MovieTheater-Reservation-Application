package Model;

public class Seat {

    private int state = 0; //Default state of the seat, 0 to represent empty
    private int seatNumber;
    private int seatRow;
    private int seatColumn;

    public Seat(int seatNumber, int seatRow, int seatColumn) {
        this.seatNumber = seatNumber;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "state=" + state +
                ", seatNumber=" + seatNumber +
                ", seatRow=" + seatRow +
                ", seatColumn=" + seatColumn +
                '}';
    }

    //Getters and Setters
    public int getSeatName() {
        return seatNumber;
    }

    public void setSeatName(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public long getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public long getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(int seatColumn) {
        this.seatColumn = seatColumn;
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
