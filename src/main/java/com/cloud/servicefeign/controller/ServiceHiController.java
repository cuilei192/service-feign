package com.cloud.servicefeign.controller;

import com.cloud.servicefeign.service.ServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceHiController {


    @Autowired
    ServiceHi serviceHi;


    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return serviceHi.sayHiFromClientOne( name );
    }

}
