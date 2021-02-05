package contracts

import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description "should return refused when order quantity is less than minimum required"
    request{
        method POST()
        url("/orders/check") {
            body(
                   // "id": $(consumer(regex(/[\p{ASCII}]*/)), producer("order-id")),
                    //"quantity": $(consumer(regex(/[\p{ASCII}]*/)), producer("1000"))*/
                    "id": "order-id",
                    "quantity":1000
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
