package com.fuj;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="eureka-client",fallback=Test.class)
public interface DcClient {

  @GetMapping("/dc")
  public String dc();
}
