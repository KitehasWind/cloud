package com.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

/**
 * 通过配置文件 配置网关信息
 */
@SpringBootApplication
public class GateWay9000 {

    public static void main(String[] args) {
        SpringApplication.run(GateWay9000.class, args);
    }


    /**
     * 限流配置
     * @return
     */
    @Bean
    public KeyResolver useKeyResolver() {
        KeyResolver key = exchange ->
            Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
        return key;
    }

}
