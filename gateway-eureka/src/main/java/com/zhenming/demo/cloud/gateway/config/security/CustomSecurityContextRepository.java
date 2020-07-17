package com.zhenming.demo.cloud.gateway.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
public class CustomSecurityContextRepository implements ServerSecurityContextRepository {
  private static final Logger log = LoggerFactory.getLogger(CustomSecurityContextRepository.class);

  @Resource
  private CustomAuthenticationManager authenticationManager;

  @Override
  public Mono<Void> save(ServerWebExchange serverWebExchange, SecurityContext securityContext) {
    return Mono.empty();
  }

  @Override
  public Mono<SecurityContext> load(ServerWebExchange serverWebExchange) {
    ServerHttpRequest request = serverWebExchange.getRequest();
    String authHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

    Map<String, List<String>> map = request.getQueryParams();
    HttpCookie cookie = request.getCookies().getFirst("JSESSIONID");
    if (cookie != null) {
      System.out.println(cookie.getValue());
    }


//    log.info("username={}", username);
//    log.info("type={}", type);
//    log.info("password={}", password);

    CustomAuthenticationToken auth = new CustomAuthenticationToken(null, null, null);
    return this.authenticationManager.authenticate(auth).map(SecurityContextImpl::new);
  }
}
