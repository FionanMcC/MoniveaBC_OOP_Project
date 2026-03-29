package ie.atu.moniveabc_oop_project.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;





@NoArgsConstructor
@Entity
public class userModlel {
    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @Email(message="Invalid email")
    @NotBlank(message = "Email is required")
    private String email;

    private String password;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;



    public userModlel(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;

    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() { return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUserId(Long id){

        this.id=id;

    }

    @Override
    public String toString() {
        return "User Registered: " + firstName + " " + lastName + " (" + email + ")";
    }



}