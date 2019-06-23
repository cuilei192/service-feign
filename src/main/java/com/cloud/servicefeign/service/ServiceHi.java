package com.cloud.servicefeign.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eurekaClient",fallback = ServiceHiHystric.class)
public interface ServiceHi {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}

@Component
class ServiceHiHystric implements  ServiceHi{

      @Override
      public String sayHiFromClientOne(String name) {
          return "断路器返回";
      }
  }
