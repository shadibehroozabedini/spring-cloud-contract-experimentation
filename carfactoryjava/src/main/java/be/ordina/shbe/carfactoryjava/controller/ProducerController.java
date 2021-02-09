package be.ordina.shbe.carfactoryjava.controller;


import be.ordina.shbe.carfactoryjava.domain.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class ProducerController {
    private static final int MINIMUM_ORDER_QUANTITY = 500;

    @PostMapping(value = "/check", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String checkOrderQuantity(@RequestBody Order order) {
        return order.getQuantity() >= MINIMUM_ORDER_QUANTITY ? "accepted" : "refused";
    }
}
