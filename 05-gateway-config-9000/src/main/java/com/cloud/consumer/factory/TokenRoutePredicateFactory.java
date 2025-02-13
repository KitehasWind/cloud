package com.cloud.consumer.factory;

import lombok.Data;
import org.springframework.cloud.gateway.handler.AsyncPredicate;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Component
public class TokenRoutePredicateFactory extends AbstractRoutePredicateFactory<TokenRoutePredicateFactory.Config> {

    @Data
    public static class Config {
        private String token;
    }

    public TokenRoutePredicateFactory() {
        super(Config.class);
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

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return serverWebExchange -> {
            MultiValueMap<String, String> queryParams = serverWebExchange.getRequest().getQueryParams();
            List<String> list = queryParams.get("token");
            if (list.contains(config.getToken())){
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

    @Override
    public ShortcutType shortcutType() {
        return super.shortcutType();
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("token");
    }

    @Override
    public String shortcutFieldPrefix() {
        return super.shortcutFieldPrefix();
    }


}
