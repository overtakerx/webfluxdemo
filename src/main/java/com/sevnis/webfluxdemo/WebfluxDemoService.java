package com.sevnis.webfluxdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebfluxDemoService {


  public DemoResponse getUsingWrongWebflux() {

    return Mono.fromCallable(() -> {
      Thread.sleep(100);
      return DemoResponse.builder().key("key1").value("value2").build();
    }).block();

  }


  public Mono<DemoResponse> getUsingWebflux() {

    return Mono.fromCallable(() -> {
      // simulation of a load work which can be database connection, database retrieval, kafka retrieval,
      // or webclient call to external API
      Thread.sleep(100);
      return DemoResponse.builder().key("key1").value("value2").build();
    });

  }



  public DemoResponse getUsingNormal() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {

    }
    return DemoResponse.builder().key("key1").value("value2").build();
  }
}
