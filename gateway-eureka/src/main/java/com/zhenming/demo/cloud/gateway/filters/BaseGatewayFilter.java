package com.zhenming.demo.cloud.gateway.filters;

import com.alibaba.fastjson.JSON;
import com.zhenming.demo.cloud.gateway.GatewayApplication;
import com.zhenming.demo.cloud.gateway.config.security.CustomAuthenticationToken;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class BaseGatewayFilter implements GatewayFilter, Ordered {
  private static final Logger log = LoggerFactory.getLogger(BaseGatewayFilter.class);

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    URI uri = exchange.getRequest().getURI();
    String query = uri.getRawQuery();

    ServerSecurityContextRepository repository = GatewayApplication.context.getBean(ServerSecurityContextRepository.class);
    Mono<SecurityContext> mono = repository.load(exchange);
    SecurityContext context = mono.block();
    if (context == null || !(context.getAuthentication() instanceof CustomAuthenticationToken)) {
      return chain.filter(exchange);
    }
    CustomAuthenticationToken token = ((CustomAuthenticationToken) context.getAuthentication());

    log.error(JSON.toJSONString(token));
    Map<String, String> map;
    if (StringUtils.isNotBlank(query)) {
      map = Arrays.stream(query.split("&")).collect(Collectors.toMap(item -> item.split("=")[0], item -> item.split("=")[1]));
    } else {
      map = new HashMap<>();
    }
    map.put("id", "10");
    StringBuilder queryBuilder = new StringBuilder();
    for (String key : map.keySet()) {
      queryBuilder.append(key).append("=").append(map.get(key)).append("&");
    }
    String newQuery = queryBuilder.subSequence(0, queryBuilder.length() - 1).toString();
    log.info(newQuery);
    URI newUri = UriComponentsBuilder.fromUri(uri).replaceQuery(newQuery).build().toUri();

    ServerHttpRequest request = exchange.getRequest().mutate().uri(newUri).build();
    return chain.filter(exchange.mutate().request(request).build());
  }

  @Override
  public int getOrder() {
    return 0;
  }
}
