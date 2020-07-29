package com.zhenming.demo.cloud.gateway.config;

import com.zhenming.demo.cloud.gateway.filters.RoleGatewayFilterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfiguration {
//  @Bean
//  public RouteLocator routeLocator(RouteLocatorBuilder builder) {
//    return builder.routes()
//        .route(r ->
//            r.path("/producer-eureka/base/**").filters(f ->
//                f.stripPrefix(1).filter(new BaseGatewayFilter())
//            ).uri("lb://producer-eureka")
//        ).build();
//  }

  @Bean
  public RoleGatewayFilterFactory roleGatewayFilterFactory() {
    return new RoleGatewayFilterFactory();
  }
}
