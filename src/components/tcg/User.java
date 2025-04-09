package components.tcg;

public class User {
    private String userId;
    private String userName;

    //Constructor to initialize user attributes
    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    //Getter methods to retrive user information
    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }
}
