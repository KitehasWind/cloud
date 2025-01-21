package com.cloud.consumer;

import com.cloud.consumer.config.DepartConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
// 指定负载均衡策略
@LoadBalancerClients(defaultConfiguration = DepartConfig.class)
public class ConsumerFeign8004 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign8004.class, args);
    }

}
