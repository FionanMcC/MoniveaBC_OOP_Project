package ie.atu.moniveabc_oop_project;

import java.util.ArrayList;
import java.util.List;

public class signUpService {
    private List<userModlel
            > users = new ArrayList<>();

    public boolean registerUser(String firstName, String lastName, String email, String password) {

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            System.out.println("All fields are required.");
            return false;
        }

        if (!email.contains("@")) {
            System.out.println("Invalid email format.");
            return false;
        }

        if (password.length() < 6) {
            System.out.println("Password must be at least 6 characters.");
            return false;
        }

        userModlel newUser = new userModlel(firstName, lastName, email, password);
        users.add(newUser);

        System.out.println("Account created successfully!");
        return true;
    }

    public void displayUsers() {
        for (userModlel user : users) {
            System.out.println(user);
        }
    }
}
