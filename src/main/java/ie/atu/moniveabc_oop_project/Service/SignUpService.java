package ie.atu.moniveabc_oop_project.Service;

import ie.atu.moniveabc_oop_project.ExceptionHandler.MemberAlreadyExistsException;
import ie.atu.moniveabc_oop_project.ExceptionHandler.MemberNotFoundException;
import ie.atu.moniveabc_oop_project.Model.userModlel;
import ie.atu.moniveabc_oop_project.repositiory.MemberRepo;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class SignUpService {


    private List<userModlel> members;
    private final MemberRepo memberRepo;

    public SignUpService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;

    }

    public String registerUser(userModlel member) {

        members = memberRepo.findAll();

    for(userModlel currentMember:members){
        if(currentMember.getEmail().equals(member.getEmail())){
            throw new MemberAlreadyExistsException("Member with this email already exists");
        }
    }

        memberRepo.save(member);


        return "Sign up successful";

    }

    public List<userModlel> getUser() {
        return memberRepo.findAll();
    }

    public userModlel getById(Long id) {

          return memberRepo.findById(id).orElseThrow(()-> new MemberNotFoundException("Member" +id+" not found"));
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

