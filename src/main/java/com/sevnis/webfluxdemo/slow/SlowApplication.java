package com.sevnis.webfluxdemo.slow;

import java.time.Duration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@SpringBootApplication
public class SlowApplication implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

  public static void main(String[] args) {
    SpringApplication.run(SlowApplication.class, args);
  }

  @Override
  public void customize(ConfigurableWebServerFactory factory) {
    factory.setPort(8080);
  }

  @GetMapping("/slowendpoint")
  public Mono<String> slowEndpoint() {
    return Mono.just("OK").delayElement(Duration.ofMillis(300));
  }


}
