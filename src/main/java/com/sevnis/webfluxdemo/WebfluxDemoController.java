package com.sevnis.webfluxdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WebfluxDemoController {

  @Autowired
  private WebfluxDemoService service;


  @GetMapping("/normal")
  public DemoResponse invokeNormal() {

    return service.getUsingNormal();
  }

  @GetMapping("/webflux")
  public Mono<DemoResponse> invokeCorrectWebflux() {

    return service.getUsingWebflux();
  }

  @GetMapping("/wrongwebflux")
  public DemoResponse invokeWrongwebflux() {

    return service.getUsingWrongWebflux();
  }

}
