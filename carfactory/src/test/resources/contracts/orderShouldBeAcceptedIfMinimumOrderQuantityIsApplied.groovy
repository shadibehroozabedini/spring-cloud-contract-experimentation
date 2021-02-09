package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return accepted when order quantity is greater than minimum required"
    request {
        method POST()
        url("/orders/check") {
            body(
                    "quantity": 1000,
                    "model":"LEAF"
            )
            headers {
                contentType(applicationJson())
            }
        }
    }
    response {
        body("accepted")
        status 200
    }
}
