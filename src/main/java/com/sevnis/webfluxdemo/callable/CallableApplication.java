package com.sevnis.webfluxdemo.callable;

import java.util.concurrent.Callable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class CallableApplication implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

  public static void main(String[] args) {
    SpringApplication.run(CallableApplication.class, args);
  }

  @Override
  public void customize(ConfigurableWebServerFactory factory) {
    factory.setPort(8083);
  }

  private RestTemplate restTemplate;

  public CallableApplication(RestTemplateBuilder builder) {
    restTemplate = builder.build();
  }


  @GetMapping("/callableendpoint")
  public Callable<String> callableEndpoint() {

    return () -> restTemplate.getForObject("http://localhost:8080/slowendpoint", String.class);
  }
}
