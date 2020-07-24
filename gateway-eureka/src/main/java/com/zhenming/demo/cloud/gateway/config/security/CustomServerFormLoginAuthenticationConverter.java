package com.zhenming.demo.cloud.gateway.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authentication.ServerFormLoginAuthenticationConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class CustomServerFormLoginAuthenticationConverter extends ServerFormLoginAuthenticationConverter {
  private final String USERNAME_PARAMETER = "username";
  private final String PASSWORD_PARAMETER = "password";
  private final String TYPE_PARAMETER = "type";

  @Override
  public Mono<Authentication> convert(ServerWebExchange exchange) {
    return exchange.getFormData().map(this::createAuthentication);
  }

  private CustomAuthenticationToken createAuthentication(MultiValueMap<String, String> data) {
    String username = data.getFirst(this.USERNAME_PARAMETER);
    String password = data.getFirst(this.PASSWORD_PARAMETER);
    String type = data.getFirst(this.TYPE_PARAMETER);
    return new CustomAuthenticationToken(username, password, type);
  }
}
