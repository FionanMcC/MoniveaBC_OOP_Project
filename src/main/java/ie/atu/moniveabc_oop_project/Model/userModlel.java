package ie.atu.moniveabc_oop_project.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class userModlel {
    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @Email(message="Invalid email")
    private String email;
    private String password;

    public userModlel() {}

    public userModlel(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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