package com.zhenming.demo.cloud.gateway.config.security;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import javax.security.auth.Subject;
import java.util.Collection;

public class CustomAuthenticationToken extends AbstractAuthenticationToken {
  private static final long serialVersionUID = 1661498566355639041L;

  private final Object principal;
  private final Object type;
  private final Object credentials;
  private final JSONObject user;

  public CustomAuthenticationToken(Object principal, Object credentials, Object type) {
    super(null);
    this.principal = principal;
    this.type = type;
    this.credentials = credentials;
    this.user = null;
    setAuthenticated(false);
  }

  public CustomAuthenticationToken(Collection<? extends GrantedAuthority> authorities, Object principal, Object credentials, Object type, JSONObject user) {
    super(authorities);
    this.principal = principal;
    this.type = type;
    this.credentials = credentials;
    this.user = user;
    super.setAuthenticated(true);
  }

  public Object getType() {
    return type;
  }

  @Override
  public Object getPrincipal() {
    return principal;
  }

  @Override
  public Object getCredentials() {
    return credentials;
  }

  @Override
  public boolean implies(Subject subject) {
    return false;
  }

  @Override
  public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    if (isAuthenticated) {
      throw new IllegalArgumentException(
          "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
    }

    super.setAuthenticated(false);
  }
}
