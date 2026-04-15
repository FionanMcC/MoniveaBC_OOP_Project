package ie.atu.moniveabc_oop_project.Service;

import ie.atu.moniveabc_oop_project.Model.userModlel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SignUpService {

    private List<userModlel> members;
    private final MemberRepo memberRepo;

    public String SignUpService(MemberRepo membersRepo) {
        this.memberRepo = memberRepo;

    }

    public String registerUser(userModlel member) {
        members = memberRepo.findAll();
    }
    for(userModlel currentMember:members){
        if (currentMember.getEmail().equals(member.getEmail())) {
            throw new MemberAlreadyExistsException("Members with this email already exists");
        }
    }

    memberRepo.save(member);

    return"Sign up successful";


}

public List<userModlel> getUser() {
    return memberRepo.findAll();
}

public userModlel getById(Long id) {
    return memberRepo.finalById(id).orElseThrow(() -> new MemberNotFoundException("Member" + id + "not found"));

    }
}

