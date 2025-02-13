package com.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 通过API的方式进行配置 网关配置 - builder.routes().route(routeId,Function<PredicateSpec, Buildable<Route>> fn)
 *
 */
@SpringBootApplication
public class GateWay9001 {

    public static void main(String[] args) {
        SpringApplication.run(GateWay9001.class, args);
    }


    /**
     * 第一种方式 全局过滤 - 不添加条件
     * @param builder
     * @return
     */
  /*
    @Bean
    public RouteLocator someRouteLocator(RouteLocatorBuilder builder) {
        RouteLocator baiduRoute = builder.routes().route("baidu_route", predicateSpec ->
                predicateSpec.path("/**").uri("https://www.baidu.com")
        ).build();
        return baiduRoute;
    }*/



    /**
     * 计算当前时间减去两天的时间点。
     * 使用RouteLocatorBuilder创建一个路由规则，匹配时间在计算出的时间点之后的请求，并将其转发到指定的URI。
     * 返回配置好的RouteLocator对象。
     * @param builder
     * @return
     */
  /*  @Bean
    public RouteLocator someRouteLocator(RouteLocatorBuilder builder) {

        // 当前时间减两天 minusDays(2) 正常访问， 当前时间+5天 无法访问 minusDays(-5)  - 也可以after 改为before
        ZonedDateTime zonedDateTime = LocalDateTime.now().minusDays(-5).atZone(ZoneId.systemDefault());
        RouteLocator afterRoute = builder.routes().
                route("after_route", predicateSpec -> predicateSpec.after(zonedDateTime).
                        uri("https://www.baidu.com")).build();

        return afterRoute;
    }*/

    /**
     * 进行cookie验证
     * predicateSpec.header("city","xian") 则为Header验证
     *
     * @param builder
     * @return
     */
   /* @Bean
    public RouteLocator someRouteLocator(RouteLocatorBuilder builder) {

        // cookie验证
        RouteLocator afterRoute = builder.routes().
                route("after_route", predicateSpec -> predicateSpec.cookie("city","xian").
                        uri("https://www.baidu.com")).build();

        return afterRoute;
    }*/

    /**
     * predicateSpec.host(host1,host2) host验证
     * method("GET","POST") 方法验证
     * @param builder
     * @return
     */
   /* @Bean
    public RouteLocator someRouteLocator(RouteLocatorBuilder builder) {

        // cookie验证
        RouteLocator afterRoute = builder.routes().
                route("after_route", predicateSpec -> predicateSpec.host("127.0.0.1","192.168.3.54").
                        uri("https://www.baidu.com")).build();

        return afterRoute;
    }*/


    /**
     * 路径验证
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator someRouteLocator(RouteLocatorBuilder builder) {

        // 路径验证
        RouteLocator afterRoute = builder.routes().
                route("provider_route", predicateSpec -> predicateSpec.path("/provider/**").
                        uri("https://www.baidu.com")).
                route("consumer_route", predicateSpec -> predicateSpec.path("/consumer/**").
                        uri("https://www.baidu.com")).
                build();

        return afterRoute;

    }








}
