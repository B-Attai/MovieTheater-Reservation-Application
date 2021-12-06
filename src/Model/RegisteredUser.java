package Model;

public class RegisteredUser extends User{

    private String accountNumber;
    private String email;

    //Default constructor for registered user
    public RegisteredUser(String userName, String password, String accountNumber, String email) {
        super(userName, password);
        setAccountNumber(accountNumber);
        setEmail(email);
        setUserType("Registered"); //Added to ever registered user to determine type
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

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
