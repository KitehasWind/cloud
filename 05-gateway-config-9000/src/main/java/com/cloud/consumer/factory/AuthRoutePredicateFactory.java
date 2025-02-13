package com.cloud.consumer.factory;

import lombok.Data;
import org.springframework.cloud.gateway.handler.AsyncPredicate;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebExchangeDecorator;
import org.springframework.web.server.adapter.DefaultServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Component
public class AuthRoutePredicateFactory extends AbstractRoutePredicateFactory<AuthRoutePredicateFactory.Config> {

    public AuthRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public ShortcutType shortcutType() {
        return super.shortcutType();
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("username","password");
    }

    @Override
    public String shortcutFieldPrefix() {
        return super.shortcutFieldPrefix();
    }

    @Override
    public Predicate<ServerWebExchange> apply(Consumer<Config> consumer) {
        return super.apply(consumer);
    }

    @Override
    public AsyncPredicate<ServerWebExchange> applyAsync(Consumer<Config> consumer) {
        return super.applyAsync(consumer);
    }

    @Override
    public void beforeApply(Config config) {
        super.beforeApply(config);
    }

    /**
     * 断言判断
     * @param config
     * @return
     */
    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return serverWebExchange -> {
            HttpHeaders headers = serverWebExchange.getRequest().getHeaders();
            List<String> pwds = headers.get(config.getUsername());
            if (pwds!=null && pwds.contains(config.getPassword())){
                return true;
            }
            return false;
        };
    }

    @Override
    public AsyncPredicate<ServerWebExchange> applyAsync(Config config) {
        return super.applyAsync(config);
    }

    @Override
    public String name() {
        return super.name();
    }

    @Data
    public static class Config{
        private String username;
        private String password;
    }

}
