package ie.atu.moniveabc_oop_project.repositiory;

import ie.atu.moniveabc_oop_project.Model.userModlel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepo extends JpaRepository<userModlel, Long> {
}
