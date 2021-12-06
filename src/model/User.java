package model;

import java.util.Objects;

public class User {

    private String userName;
    private String userPass;
    private String userType;

    //Constructor for regular user
    public User(String userName, String userPass, String userType) {
        this.userName = userName;
        this.userPass = userPass;
        this.userType = userType;
    }

    public User(String username, String password) {
        this.userName = username;
        this.userPass = password;
        userType = "guest";
    }

    //Getters and setters
    public String getUserInfo(){
        return getUserName();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() && getClass() != RegisteredUser.class) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) && Objects.equals(userPass, user.userPass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userPass, userType);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
