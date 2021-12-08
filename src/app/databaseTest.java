package app;

import database.DBManager;

public class databaseTest {
    public static void main(String[] args){
        DBManager myDBM = new DBManager();

        System.out.println(myDBM.findMovie("James Bond"));
    }
}
