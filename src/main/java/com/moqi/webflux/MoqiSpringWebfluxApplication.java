package com.moqi.webflux;

import com.moqi.client.GreetingClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.moqi"})
@Slf4j
public class MoqiSpringWebfluxApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MoqiSpringWebfluxApplication.class, args);
        GreetingClient greetingClient = context.getBean(GreetingClient.class);
        // We need to block for the content here or the JVM might exit before the message is logged
        log.info(">> message = {}", greetingClient.getMessage().block());
    }

}
