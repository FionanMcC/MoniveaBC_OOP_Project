package ie.atu.moniveabc_oop_project.Controller;

import ie.atu.moniveabc_oop_project.client.RollCallClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RollCallMainController {

    private final RollCallClient rollCallClient;

    public RollCallMainController(RollCallClient rollCallClient) {
        this.rollCallClient = rollCallClient;
    }

    @GetMapping("/attendance")
    public String getAttendanceFromRollCallService() {
        return rollCallClient.getAttendanceList();
    }
}