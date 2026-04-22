package ie.atu.moniveabc_oop_project.Service;

import ie.atu.moniveabc_oop_project.ExceptionHandler.MemberAlreadyExistsException;
import ie.atu.moniveabc_oop_project.ExceptionHandler.MemberNotFoundException;
import ie.atu.moniveabc_oop_project.Model.userModlel;
import ie.atu.moniveabc_oop_project.repositiory.MemberRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignUpService {

    private final MemberRepo memberRepo;

    // Constructor injection
    public SignUpService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }
    // Register User
    public String registerUser(userModlel member) {

        List<userModlel> members = memberRepo.findAll();

        for (userModlel currentMember : members) {
            if (currentMember.getEmail().equals(member.getEmail())) {
                throw new MemberAlreadyExistsException("Member with this email already exists");
            }
        }

        memberRepo.save(member);
        return "Sign up successful";
    }

    // GET ALL USERS
    public List<userModlel> getUser() {
        return memberRepo.findAll();
    }

    // GET USER BY ID
    public userModlel getById(Long id) {
        return memberRepo.findById(id)
                .orElseThrow(() ->
                        new MemberNotFoundException("Member " + id + " not found"));
    }

    // Update User
    public userModlel updateUser(Long id, userModlel updatedMember) {

        userModlel existingMember = memberRepo.findById(id)
                .orElseThrow(() ->
                        new MemberNotFoundException("Member " + id + " not found"));

        existingMember.setFirstName(updatedMember.getFirstName());
        existingMember.setLastName(updatedMember.getLastName());
        existingMember.setEmail(updatedMember.getEmail());
        existingMember.setPassword(updatedMember.getPassword());

        return memberRepo.save(existingMember);
    }

    // Delete User
    public void deleteUser(Long id) { //method that declares a user from the database using their ID

        if (!memberRepo.existsById(id)) {   //checks if a user with the given ID exists in the database. "!" means Not
            throw new MemberNotFoundException("Member " + id + " not found"); // If user is not found, throw a custom exception and stop execution
        }

        memberRepo.deleteById(id); // If user exists, delete the user from the database using their ID
    }
}