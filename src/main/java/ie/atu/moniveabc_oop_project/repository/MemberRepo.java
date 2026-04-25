package ie.atu.moniveabc_oop_project.repository;

import ie.atu.moniveabc_oop_project.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<UserModel, Long> {
}
