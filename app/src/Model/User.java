package Model;

public class User {

    private String userName;
    private String userType;

    //Constructor for regular user
    public User(String userName) {
        this.userName = userName;
        userType = "regular"; //This is added to every regular user to determine the type
                              //Can also determine based on the class/object type (optional)
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
}
