package Model;

public class RegisteredUser extends User{

    private String userName;
    private String address;
    private String accountNumber;
    private String email;

    //Default constructor for registered user
    public RegisteredUser(String userName, String address, String accountNumber, String email) {
        super(userName);
        setUserName(userName);
        setAddress(address);
        setAccountNumber(accountNumber);
        setEmail(email);
        setUserType("registered"); //Added to ever registered user to determine type
    }


    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
