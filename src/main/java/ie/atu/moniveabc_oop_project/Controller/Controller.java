package ie.atu.moniveabc_oop_project.Controller;

import ie.atu.moniveabc_oop_project.Model.UserModel;

import ie.atu.moniveabc_oop_project.Service.SignUpService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/members")
public class Controller {

    private final SignUpService signUpService;

    public Controller(SignUpService signUpService) {
        this.signUpService = signUpService;
    }


    @PostMapping("/register")
    public String registerMember(@Valid @RequestBody UserModel member) {
        return signUpService.registerUser(member);
    }

    @GetMapping
    public List<UserModel> displayMembers() {
        return signUpService.getUser();
    }
    @GetMapping("/{id}")
    public UserModel getMember(@PathVariable Long id) {
        return signUpService.getById(id);
    }

    @PutMapping("/{id}")
    public UserModel updateMember(@PathVariable Long id,
                                  @RequestBody UserModel member) {
        return signUpService.updateUser(id, member);
    }

    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable Long id) {
        signUpService.deleteUser(id);
        return "Member deleted successfully";
    }
}