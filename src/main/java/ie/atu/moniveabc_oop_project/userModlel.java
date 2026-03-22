package ie.atu.moniveabc_oop_project;

public class userModlel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public void userModel(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public userModlel(String firstName, String lastName, String email, String password) {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User Registered: " + firstName + " " + lastName + " (" + email + ")";
    }
}