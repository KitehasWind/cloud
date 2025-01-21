package com.cloud.consumer.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DepartConfig {

    @Bean
    @LoadBalanced
    public ReactorLoadBalancer<ServiceInstance> randomServiceInstance(Environment environment, LoadBalancerClientFactory factory) {
        // 获取服务提供者名称
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        // 从所有provider实例中 指定名称的实力列表 - 随机选择一个实例
        return new RandomLoadBalancer(factory.getLazyProvider(name, ServiceInstanceListSupplier.class),name);
    }
}
