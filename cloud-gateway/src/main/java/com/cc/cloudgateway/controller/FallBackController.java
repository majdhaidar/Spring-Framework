package com.cc.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author MajdHaidar
 * @date 4/20/22
 */
public class FallBackController {

    @GetMapping("/user-service-fallback")
    public String userServiceFallBack(){
        return "User service is taking longer than expected";
    }

    @GetMapping("/department-service-fallback")
    public String departmentServiceFallBack(){
        return "Department service is taking longer than expected";
    }
}
