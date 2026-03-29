package ie.atu.moniveabc_oop_project.Service;

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

    public userModlel registeUser(userModlel member) {

        members = memberRepo.findAll();

    for(userModlel currentMember:members){
        if(currentMember.getEmail().equals(member.getEmail())){
            throw new MemberNotFoundException("Member with this email already exists");
        }
    }

        memberRepo.save(member);


        return member;

    }

    public List<userModlel> getUser() {
        return memberRepo.findAll();
    }

    public userModlel getById(Long id) {
        for (userModlel member : members) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
            throw new MemberNotFoundException("Member" +id+" not found");
        }

    }


