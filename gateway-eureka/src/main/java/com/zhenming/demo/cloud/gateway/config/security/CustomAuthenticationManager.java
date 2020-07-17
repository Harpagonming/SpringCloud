package com.zhenming.demo.cloud.gateway.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationManager implements ReactiveAuthenticationManager {
  private static final Logger log = LoggerFactory.getLogger(CustomAuthenticationManager.class);

  @Override
  public Mono<Authentication> authenticate(Authentication authentication) {
    log.info("认证………………………………………………………………");
    CustomAuthenticationToken token = (CustomAuthenticationToken) authentication;

    checkPassword(token);
    String username = (String) authentication.getPrincipal();
    String password = (String) authentication.getCredentials();
    String type = (String) ((CustomAuthenticationToken) authentication).getType();

    //读取用户信息
//    UserDetails user = userService.loadUserByUsername(username);
    List<Role> authoritiesList = new ArrayList<>();
    authoritiesList.add(new Role("administrator"));
    CustomAuthenticationToken result = new CustomAuthenticationToken(authoritiesList, username, password, type);
    result.setDetails(token);

    return Mono.just(result);
  }

  private void checkPassword(CustomAuthenticationToken token) {

  }

  class Role implements GrantedAuthority{
    private static final long serialVersionUID = 2452277189049663853L;

    private String roleName;

    public String getRoleName() {
      return roleName;
    }

    public void setRoleName(String roleName) {
      this.roleName = roleName;
    }

    public Role() {
    }

    public Role(String roleName) {
      this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
      return roleName;
    }
  }
}
