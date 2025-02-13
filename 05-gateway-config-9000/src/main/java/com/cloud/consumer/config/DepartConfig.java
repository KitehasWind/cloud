package com.cloud.consumer.config;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DepartConfig {

    private static GpioController gpio;
    private static GpioPinDigitalOutput motorLeftForward;
    private static GpioPinDigitalOutput motorLeftBackward;
    private static GpioPinDigitalOutput motorRightForward;
    private static GpioPinDigitalOutput motorRightBackward;
    private static GpioPinPwmOutput servoLeft;
    private static GpioPinPwmOutput servoRight;



    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
