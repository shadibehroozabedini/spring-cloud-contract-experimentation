package contracts;

import org.springframework.cloud.contract.spec.Contract;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class OrderShouldBeAcceptedIfMinimumOrderQuantityIsApplied implements Supplier<Contract> {


    @Override
    public Contract get() {
        Map<String, Object> bodyRequest = new HashMap<>();
        bodyRequest.put("model", "LEAF");
        bodyRequest.put("quantity", 1000);

        return Contract.make(c -> {
            c.request(rqs -> {
                rqs.method("POST");
                rqs.url("/orders/check");
                rqs.body(bodyRequest);
                rqs.headers(h -> {
                    h.contentType(h.applicationJson());
                });
            });
            c.response(resp -> {
                resp.status(resp.OK());
                resp.body("accepted");
            });
        });
    }
}
