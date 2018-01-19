package com.fuj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TestController {
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  @LoadBalanced
  private RestTemplate loadBalanced;
  @Autowired
  private DcClient dcClient;
  @GetMapping("/consumer")
  @HystrixCommand(fallbackMethod="142152152")
  public String dc() {
      return restTemplate.getForObject("http://eureka-client/dc", String.class);
  }
  
  @GetMapping("/consumers")
  public String consumers() {
      return dcClient.dc();
  }
  
}
