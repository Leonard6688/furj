package com.fuj;

import org.springframework.stereotype.Component;

@Component
public class Test implements DcClient {

  @Override
  public String dc() {
   
    return "15125125125";
  }

}
