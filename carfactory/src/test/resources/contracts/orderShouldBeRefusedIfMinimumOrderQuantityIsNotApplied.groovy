package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return refused when order quantity is less than minimum required"
    request {
        method POST()
        url("/orders/check") {
            body(
                    "id": "order-id",
                    "quantity": 20
            )
            headers {
                contentType(applicationJson())
            }
        }
    }
    response {
        body("refused")
        status 200
    }
}
