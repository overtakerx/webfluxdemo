package com.sevnis.webfluxdemo.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@SpringBootApplication
public class ReactiveApplication implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

  public static void main(String[] args) {
    SpringApplication.run(ReactiveApplication.class, args);
  }

  @Override
  public void customize(ConfigurableWebServerFactory factory) {
    factory.setPort(8082);
  }


  private final WebClient client = WebClient.create("http://localhost:8080");

  @GetMapping("/reactiveendpoint")
  public Mono<String> reactiveEndpoint() {
    return client.get()
        .uri("/slowendpoint")
        .retrieve()
        .bodyToMono(String.class);
  }

}
