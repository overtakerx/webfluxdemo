package com.sevnis.webfluxdemo.deferredresult;

import java.util.concurrent.CompletableFuture;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@SpringBootApplication
public class DeferredResultApplication implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

  public static void main(String[] args) {
    SpringApplication.run(DeferredResultApplication.class, args);
  }

  @Override
  public void customize(ConfigurableWebServerFactory factory) {
    factory.setPort(8084);
  }

  private RestTemplate restTemplate;

  public DeferredResultApplication(RestTemplateBuilder builder) {
    restTemplate = builder.build();
  }


  @GetMapping("/deferredendpoint")
  public DeferredResult<String> deferredEndpoint() {

    DeferredResult<String> deferredResult = new DeferredResult<>();
    CompletableFuture.supplyAsync(() -> restTemplate.getForObject("http://localhost:8080/slowendpoint", String.class))
        .whenCompleteAsync((result, throwable) -> deferredResult.setResult(result));

    return deferredResult;
  }
}
