package ie.atu.moniveabc_oop_project.Service;

import ie.atu.moniveabc_oop_project.Model.userModlel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SignUpService {

    private List<userModlel> users = new ArrayList<>();
    private long nextId = 1;

    public String registerUser(userModlel user) {

        user.setUserId(nextId++);

        users.add(user);

        return("Account created successfully!");
    }

    public List<userModlel> getUsers() {
        return users;
        }


}

