package ie.atu.moniveabc_oop_project.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class RollCallClient {

    private final RestClient restClient;

    public RollCallClient(@Value("${rollcall.service.url}") String rollCallServiceUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(rollCallServiceUrl)
                .build();
    }

    public String getAttendanceList() {
        return restClient.get()
                .uri("/rollcall/PrintList")
                .retrieve()
                .body(String.class);
    }
}