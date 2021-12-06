package model;

public class RegisteredUser extends User{

    //Default constructor for registered user
    public RegisteredUser(String userName, String password) {
        super(userName, password);
        setUserType("Registered"); //Added to ever registered user to determine type
    }


    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
