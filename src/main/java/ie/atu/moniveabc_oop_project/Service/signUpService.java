package ie.atu.moniveabc_oop_project.Service;

import ie.atu.moniveabc_oop_project.Model.userModlel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class signUpService {

    private List<userModlel> users = new ArrayList<>();

    public String registerUser(userModlel user) {

        users.add(user);

        return("Account created successfully!");
    }

    public List<userModlel> getUsers() {
        return users;
        }

}

