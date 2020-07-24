package com.zhenming.demo.cloud.gateway.config.security;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
public class CustomAuthenticationFailureHandler implements ServerAuthenticationFailureHandler {
  private static final Logger log = LoggerFactory.getLogger(CustomAuthenticationFailureHandler.class);

  @Override
  public Mono<Void> onAuthenticationFailure(WebFilterExchange webFilterExchange, AuthenticationException exception) {
    log.info("登录失败");
    ServerHttpResponse response = webFilterExchange.getExchange().getResponse();

    response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
    response.setStatusCode(HttpStatus.OK);

    JSONObject responseMessage = new JSONObject();
    responseMessage.put("code",100);
    responseMessage.put("message", "登录失败");

    DataBuffer buffer = response.bufferFactory().wrap(responseMessage.toJSONString().getBytes(StandardCharsets.UTF_8));
    return response.writeWith(Mono.just(buffer));
  }
}