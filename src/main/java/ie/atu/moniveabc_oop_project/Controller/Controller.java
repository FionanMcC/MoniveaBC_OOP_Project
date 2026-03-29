package ie.atu.moniveabc_oop_project.Controller;

import ie.atu.moniveabc_oop_project.Model.userModlel;

import ie.atu.moniveabc_oop_project.Service.SignUpService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@RestController
@RequestMapping("/users")
public class Controller {

    private final SignUpService signUpService;

    public Controller(SignUpService signUpService) {
        this.signUpService = signUpService;
    }


    @PostMapping("/register")
    public String registerUser(@Valid @RequestBody userModlel user) {

        return signUpService.registerUser(user);
    }

    @GetMapping
    public List<userModlel> displayUsers() {
        return signUpService.getUsers();
    }

}