package be.ordina.cardealer.controller;

import be.ordina.cardealer.domain.Order;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {


    private RestTemplate restTemplate;
    private static final String PORT = "8080";
    private static final String CAR_FACTORY_URI = "http://localhost:" + PORT + "/orders/check";

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping()
    public String checkOrderStatus(@RequestParam("quantity") int quantity) {

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                RequestEntity
                        .post(URI.create(CAR_FACTORY_URI))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(Order.builder().model("LEAF").quantity(quantity).build()),
                String.class);
        return responseEntity.getBody();
    }
}
