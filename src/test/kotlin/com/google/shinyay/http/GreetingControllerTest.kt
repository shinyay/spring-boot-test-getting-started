package com.google.shinyay.http

import com.google.shinyay.controller.GreetingController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest
import org.springframework.test.web.client.MockRestServiceServer

@RestClientTest(GreetingController::class)
class GreetingControllerTest(
    @Autowired val mockServer: MockRestServiceServer,
    val greetingController: GreetingController
) {
}