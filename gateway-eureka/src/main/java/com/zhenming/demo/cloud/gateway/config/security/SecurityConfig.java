package com.zhenming.demo.cloud.gateway.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationEntryPoint;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.security.web.server.context.WebSessionServerSecurityContextRepository;
import org.springframework.web.server.WebFilter;

import javax.annotation.Resource;

@EnableWebFluxSecurity
public class SecurityConfig {
//  @Value("${parameter.security.loginPoint}")
//  private String loginPoint;
  @Resource
  private CustomAuthenticationManager authenticationManager;
  @Resource
  private CustomServerFormLoginAuthenticationConverter converter;
  @Resource
  private CustomAuthenticationSuccessHandler successHandler;

  @Bean
  public SecurityWebFilterChain webFluxSecurityFilterChain(ServerHttpSecurity http) throws Exception {
    //默认登录页
    RedirectServerAuthenticationEntryPoint loginPoint = new RedirectServerAuthenticationEntryPoint("/login.html");

    //认证过滤器
    AuthenticationWebFilter authenticationWebFilter = new AuthenticationWebFilter(authenticationManager);
    authenticationWebFilter.setServerAuthenticationConverter(converter);
    SecurityWebFilterChain chain =
        http
            //无需进行权限过滤的请求路径
            .authorizeExchange().pathMatchers("*.js", "/login.html").permitAll()
            .and().formLogin(formLogin ->
                formLogin
                    .authenticationManager(new CustomAuthenticationManager())
                    .loginPage("/login")
                    .authenticationEntryPoint(loginPoint)
                    .authenticationSuccessHandler(successHandler)
//            .authenticationFailureHandler()
        )
            //登出接口需为POST
            .logout().logoutUrl("/logout")
            .and()
            .authorizeExchange().anyExchange().authenticated()
            //支持跨域
            .and().csrf().disable()
            .build();
    for (WebFilter f : chain.getWebFilters().toIterable()) {
      if (f instanceof AuthenticationWebFilter) {
        AuthenticationWebFilter webFilter = (AuthenticationWebFilter) f;
        //将自定义的AuthenticationConverter添加到过滤器中
        webFilter.setServerAuthenticationConverter(converter);
        break;
      }
    }
    return chain;
  }

  /**
   * 将登陆后的用户及权限信息存入session中
   */
  @Bean
  ServerSecurityContextRepository serverSecurityContextRepository() {
    return new WebSessionServerSecurityContextRepository();
  }
}
