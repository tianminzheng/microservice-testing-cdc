import org.springframework.cloud.contract.spec.Contract
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

Contract.make {
    description "return all accounts"

    request {
        url "/api/accounts/v1"
        method GET()
    }

    response {
        status 200
        headers {
            header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
        }
        body("data": [[id: 1L, username: "tianyalan1", firstName: "tianmin", lastName: "zheng", email: "tianyalan@email.com"], 
                      [id: 2L, username: "tianyalan2", firstName: "tianmin", lastName: "zheng", email: "tianyalan@email.com"]])

    }
}







