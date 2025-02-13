package com.cloud.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {


    @RequestMapping("/fb")
    public String fallbackHandle(){
        return "this is gateWay fallback";
    }

}
