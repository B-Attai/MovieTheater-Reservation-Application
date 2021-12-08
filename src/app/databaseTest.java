package app;

import database.DBManager;

public class databaseTest {
    public static void main(String[] args){
        DBManager myDBM = new DBManager();

        System.out.println(myDBM.loadSeats(1, 12, "07-12-2021"));
    }
}
