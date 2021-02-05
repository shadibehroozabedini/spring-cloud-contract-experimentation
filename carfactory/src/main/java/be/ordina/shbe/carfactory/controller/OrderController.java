package be.ordina.shbe.carfactory.controller;

import be.ordina.shbe.carfactory.controller.resource.CarResource;
import be.ordina.shbe.carfactory.controller.resource.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    private static final int MINIMUM_ORDER_QUANTITY = 500;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CarResource>> getCars() {

        return new ResponseEntity<>(List.of(CarResource.builder().id("car_random_id").make("Nissan").model("Murano").year(2004).build(),
                CarResource.builder().id("car_random_id").make("Nissan").model("LEAF").year(2008).build()), HttpStatus.OK);
    }

    @PostMapping(value = "/check", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String checkOrderQuantity(@RequestBody Order order) {
        return order.getQuantity() >= MINIMUM_ORDER_QUANTITY ? "accepted" : "refused";
    }
}
