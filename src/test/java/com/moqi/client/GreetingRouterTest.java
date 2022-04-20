package com.moqi.client;

import com.moqi.bean.Greeting;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author moqi
 * @date 4/20/22 23:23
 */
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.moqi"})
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = GreetingRouterTest.class
)
class GreetingRouterTest {

    // Spring Boot will create a `WebTestClient` for you,
    // already configure and ready to issue requests against "localhost:RANDOM_PORT"
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testHello() {
        webTestClient
                // Create a GET request to test an endpoint
                .get().uri("/hello")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                // and use the dedicated DSL to test assertions against the response
                .expectStatus().isOk()
                .expectBody(Greeting.class).value(greeting -> {
                    assertThat(greeting.getMessage()).isEqualTo("Hello, Spring!");
                });
    }
}