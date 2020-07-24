package com.zhenming.demo.cloud.gateway.config.security;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationManager implements ReactiveAuthenticationManager, Serializable {
  private static final long serialVersionUID = 920964500458773166L;

  private static final Logger log = LoggerFactory.getLogger(CustomAuthenticationManager.class);

  @Override
  public Mono<Authentication> authenticate(Authentication authentication) {
    log.info("认证………………………………………………………………");
    CustomAuthenticationToken token = (CustomAuthenticationToken) authentication;

    JSONObject user = checkPassword(token);
    String username = (String) authentication.getPrincipal();
    String password = (String) authentication.getCredentials();
    String type = (String) ((CustomAuthenticationToken) authentication).getType();

    List<Role> authoritiesList = new ArrayList<>();
    authoritiesList.add(new Role("Administrator"));
    CustomAuthenticationToken result = new CustomAuthenticationToken(authoritiesList, username, password, type,user);
    result.setDetails(token);

    return Mono.just(result);
  }

  private JSONObject checkPassword(CustomAuthenticationToken token) {
    String username = (String) token.getPrincipal();
    String password = (String) token.getCredentials();
    String type = (String) token.getType();
    JSONObject object = new JSONObject();
    object.put("username", username);
    object.put("password", password);
    object.put("type", type);
    if(!"admin".equals(username) || !"111".equals(password)){
      throw new BadCredentialsException("用户名密码错误");
    }
    return object;
  }

  class Role implements GrantedAuthority {
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
