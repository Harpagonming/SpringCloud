package com.zhenming.demo.cloud.gateway.filters;

import com.alibaba.fastjson.JSON;
import com.zhenming.demo.cloud.gateway.config.security.CustomAuthenticationToken;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RoleGatewayFilterFactory extends AbstractGatewayFilterFactory<RoleGatewayFilterFactory.Config> {
  private static final Logger log = LoggerFactory.getLogger(RoleGatewayFilterFactory.class);

  private static final String PARAMS = "paramName";

  @Resource
  private ServerSecurityContextRepository repository;

  public RoleGatewayFilterFactory() {
    super(Config.class);
  }

  @Override
  public List<String> shortcutFieldOrder() {
    return Collections.singletonList(PARAMS);
  }

  @Override
  public GatewayFilter apply(Config config) {
    return ((exchange, chain) -> {
      Mono<SecurityContext> mono = repository.load(exchange);
      SecurityContext context = mono.block();
      if (context == null || !(context.getAuthentication() instanceof CustomAuthenticationToken)) {
        return chain.filter(exchange);
      }
      CustomAuthenticationToken token = ((CustomAuthenticationToken) context.getAuthentication());
      log.error(JSON.toJSONString(token));
      URI uri = exchange.getRequest().getURI();
      String query = uri.getRawQuery();
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
    });
  }

  public static class Config {

    private String paramName;

    public String isMyParams() {
      return paramName;
    }

    public void setParamName(String paramName) {
      this.paramName = paramName;
    }
  }
}
