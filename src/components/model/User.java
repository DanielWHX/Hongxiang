<<<<<<< HEAD:src/components/tcg/User.java
package components.tcg;
=======
package components.model;
>>>>>>> 4e98dc3ee1682ca2d6d468a484d88c61564e7a43:src/components/model/User.java

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
