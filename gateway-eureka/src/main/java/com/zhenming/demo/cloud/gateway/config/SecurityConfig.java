package com.zhenming.demo.cloud.gateway.config;

import com.zhenming.demo.cloud.gateway.config.security.CustomAuthenticationManager;
import com.zhenming.demo.cloud.gateway.config.security.CustomSecurityContextRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import javax.annotation.Resource;

@EnableWebFluxSecurity
public class SecurityConfig {
  @Resource
  private CustomAuthenticationManager authenticationManager;
  @Resource
  private CustomSecurityContextRepository securityContextRepository;

  @Bean
  public SecurityWebFilterChain webFluxSecurityFilterChain(ServerHttpSecurity http) throws Exception {
    http
        //无需进行权限过滤的请求路径
        .authorizeExchange().pathMatchers("*.js", "/login").permitAll()
        //OPTION请求默认放行
        .pathMatchers(HttpMethod.OPTIONS).permitAll()
        .and().formLogin().authenticationManager(authenticationManager)
        .securityContextRepository(securityContextRepository)
        .and()
        .authorizeExchange().anyExchange().authenticated()
        //支持跨域
        .and().csrf().disable();
    return http.build();
  }
}