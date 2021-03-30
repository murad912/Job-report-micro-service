package com.gateway.gatewayservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

//we use this method when our routing failes configuration will be in the application.yml
    @GetMapping("/studentServiceFallBack")
    public  String userServiceFallBackMethod(){
        return "User Service is taking longer than Expected. " +
                "Please try agin later";
    }

    @GetMapping("/jobServiceFallBack")
    public  String jobServiceFallBackMethod(){
        return "Job Service is taking longer than Expected. " +
                "Please try agin later";
    }
}
