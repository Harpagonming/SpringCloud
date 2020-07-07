package com.zhenming.demo.cloud.security.entity;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public UserExample() {
    oredCriteria = new ArrayList<>();
  }

  public String getOrderByClause() {
    return orderByClause;
  }

  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  public boolean isDistinct() {
    return distinct;
  }

  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }

  public Criteria createCriteria() {
    Criteria criteria = createCriteriaInternal();
    if (oredCriteria.size() == 0) {
      oredCriteria.add(criteria);
    }
    return criteria;
  }

  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  public void clear() {
    oredCriteria.clear();
    orderByClause = null;
    distinct = false;
  }

  protected abstract static class GeneratedCriteria {
    protected List<Criterion> criteria;

    protected GeneratedCriteria() {
      super();
      criteria = new ArrayList<>();
    }

    public boolean isValid() {
      return criteria.size() > 0;
    }

    public List<Criterion> getAllCriteria() {
      return criteria;
    }

    public List<Criterion> getCriteria() {
      return criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      criteria.add(new Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      criteria.add(new Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if (value1 == null || value2 == null) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      criteria.add(new Criterion(condition, value1, value2));
    }

    public Criteria andUserIdIsNull() {
      addCriterion("USER_ID is null");
      return (Criteria) this;
    }

    public Criteria andUserIdIsNotNull() {
      addCriterion("USER_ID is not null");
      return (Criteria) this;
    }

    public Criteria andUserIdEqualTo(Integer value) {
      addCriterion("USER_ID =", value, "userId");
      return (Criteria) this;
    }

    public Criteria andUserIdNotEqualTo(Integer value) {
      addCriterion("USER_ID <>", value, "userId");
      return (Criteria) this;
    }

    public Criteria andUserIdGreaterThan(Integer value) {
      addCriterion("USER_ID >", value, "userId");
      return (Criteria) this;
    }

    public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
      addCriterion("USER_ID >=", value, "userId");
      return (Criteria) this;
    }

    public Criteria andUserIdLessThan(Integer value) {
      addCriterion("USER_ID <", value, "userId");
      return (Criteria) this;
    }

    public Criteria andUserIdLessThanOrEqualTo(Integer value) {
      addCriterion("USER_ID <=", value, "userId");
      return (Criteria) this;
    }

    public Criteria andUserIdIn(List<Integer> values) {
      addCriterion("USER_ID in", values, "userId");
      return (Criteria) this;
    }

    public Criteria andUserIdNotIn(List<Integer> values) {
      addCriterion("USER_ID not in", values, "userId");
      return (Criteria) this;
    }

    public Criteria andUserIdBetween(Integer value1, Integer value2) {
      addCriterion("USER_ID between", value1, value2, "userId");
      return (Criteria) this;
    }

    public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
      addCriterion("USER_ID not between", value1, value2, "userId");
      return (Criteria) this;
    }

    public Criteria andUserNameIsNull() {
      addCriterion("USER_NAME is null");
      return (Criteria) this;
    }

    public Criteria andUserNameIsNotNull() {
      addCriterion("USER_NAME is not null");
      return (Criteria) this;
    }

    public Criteria andUserNameEqualTo(String value) {
      addCriterion("USER_NAME =", value, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameNotEqualTo(String value) {
      addCriterion("USER_NAME <>", value, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameGreaterThan(String value) {
      addCriterion("USER_NAME >", value, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameGreaterThanOrEqualTo(String value) {
      addCriterion("USER_NAME >=", value, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameLessThan(String value) {
      addCriterion("USER_NAME <", value, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameLessThanOrEqualTo(String value) {
      addCriterion("USER_NAME <=", value, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameLike(String value) {
      addCriterion("USER_NAME like", value, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameNotLike(String value) {
      addCriterion("USER_NAME not like", value, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameIn(List<String> values) {
      addCriterion("USER_NAME in", values, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameNotIn(List<String> values) {
      addCriterion("USER_NAME not in", values, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameBetween(String value1, String value2) {
      addCriterion("USER_NAME between", value1, value2, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameNotBetween(String value1, String value2) {
      addCriterion("USER_NAME not between", value1, value2, "userName");
      return (Criteria) this;
    }

    public Criteria andPasswordIsNull() {
      addCriterion("`PASSWORD` is null");
      return (Criteria) this;
    }

    public Criteria andPasswordIsNotNull() {
      addCriterion("`PASSWORD` is not null");
      return (Criteria) this;
    }

    public Criteria andPasswordEqualTo(String value) {
      addCriterion("`PASSWORD` =", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordNotEqualTo(String value) {
      addCriterion("`PASSWORD` <>", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordGreaterThan(String value) {
      addCriterion("`PASSWORD` >", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordGreaterThanOrEqualTo(String value) {
      addCriterion("`PASSWORD` >=", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordLessThan(String value) {
      addCriterion("`PASSWORD` <", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordLessThanOrEqualTo(String value) {
      addCriterion("`PASSWORD` <=", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordLike(String value) {
      addCriterion("`PASSWORD` like", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordNotLike(String value) {
      addCriterion("`PASSWORD` not like", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordIn(List<String> values) {
      addCriterion("`PASSWORD` in", values, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordNotIn(List<String> values) {
      addCriterion("`PASSWORD` not in", values, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordBetween(String value1, String value2) {
      addCriterion("`PASSWORD` between", value1, value2, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordNotBetween(String value1, String value2) {
      addCriterion("`PASSWORD` not between", value1, value2, "password");
      return (Criteria) this;
    }

    public Criteria andRoleIdIsNull() {
      addCriterion("ROLE_ID is null");
      return (Criteria) this;
    }

    public Criteria andRoleIdIsNotNull() {
      addCriterion("ROLE_ID is not null");
      return (Criteria) this;
    }

    public Criteria andRoleIdEqualTo(Integer value) {
      addCriterion("ROLE_ID =", value, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdNotEqualTo(Integer value) {
      addCriterion("ROLE_ID <>", value, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdGreaterThan(Integer value) {
      addCriterion("ROLE_ID >", value, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
      addCriterion("ROLE_ID >=", value, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdLessThan(Integer value) {
      addCriterion("ROLE_ID <", value, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
      addCriterion("ROLE_ID <=", value, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdIn(List<Integer> values) {
      addCriterion("ROLE_ID in", values, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdNotIn(List<Integer> values) {
      addCriterion("ROLE_ID not in", values, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdBetween(Integer value1, Integer value2) {
      addCriterion("ROLE_ID between", value1, value2, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
      addCriterion("ROLE_ID not between", value1, value2, "roleId");
      return (Criteria) this;
    }

    public Criteria andDeleteStatusIsNull() {
      addCriterion("DELETE_STATUS is null");
      return (Criteria) this;
    }

    public Criteria andDeleteStatusIsNotNull() {
      addCriterion("DELETE_STATUS is not null");
      return (Criteria) this;
    }

    public Criteria andDeleteStatusEqualTo(Integer value) {
      addCriterion("DELETE_STATUS =", value, "deleteStatus");
      return (Criteria) this;
    }

    public Criteria andDeleteStatusNotEqualTo(Integer value) {
      addCriterion("DELETE_STATUS <>", value, "deleteStatus");
      return (Criteria) this;
    }

    public Criteria andDeleteStatusGreaterThan(Integer value) {
      addCriterion("DELETE_STATUS >", value, "deleteStatus");
      return (Criteria) this;
    }

    public Criteria andDeleteStatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("DELETE_STATUS >=", value, "deleteStatus");
      return (Criteria) this;
    }

    public Criteria andDeleteStatusLessThan(Integer value) {
      addCriterion("DELETE_STATUS <", value, "deleteStatus");
      return (Criteria) this;
    }

    public Criteria andDeleteStatusLessThanOrEqualTo(Integer value) {
      addCriterion("DELETE_STATUS <=", value, "deleteStatus");
      return (Criteria) this;
    }

    public Criteria andDeleteStatusIn(List<Integer> values) {
      addCriterion("DELETE_STATUS in", values, "deleteStatus");
      return (Criteria) this;
    }

    public Criteria andDeleteStatusNotIn(List<Integer> values) {
      addCriterion("DELETE_STATUS not in", values, "deleteStatus");
      return (Criteria) this;
    }

    public Criteria andDeleteStatusBetween(Integer value1, Integer value2) {
      addCriterion("DELETE_STATUS between", value1, value2, "deleteStatus");
      return (Criteria) this;
    }

    public Criteria andDeleteStatusNotBetween(Integer value1, Integer value2) {
      addCriterion("DELETE_STATUS not between", value1, value2, "deleteStatus");
      return (Criteria) this;
    }
  }

  /**
   *
   */
  public static class Criteria extends GeneratedCriteria {
    protected Criteria() {
      super();
    }
  }

  public static class Criterion {
    private final String condition;

    private Object value;

    private Object secondValue;

    private boolean noValue;

    private boolean singleValue;

    private boolean betweenValue;

    private boolean listValue;

    private final String typeHandler;

    protected Criterion(String condition) {
      super();
      this.condition = condition;
      this.typeHandler = null;
      this.noValue = true;
    }

    protected Criterion(String condition, Object value, String typeHandler) {
      super();
      this.condition = condition;
      this.value = value;
      this.typeHandler = typeHandler;
      if (value instanceof List<?>) {
        this.listValue = true;
      } else {
        this.singleValue = true;
      }
    }

    protected Criterion(String condition, Object value) {
      this(condition, value, null);
    }

    protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
      super();
      this.condition = condition;
      this.value = value;
      this.secondValue = secondValue;
      this.typeHandler = typeHandler;
      this.betweenValue = true;
    }

    protected Criterion(String condition, Object value, Object secondValue) {
      this(condition, value, secondValue, null);
    }

    public String getCondition() {
      return condition;
    }

    public Object getValue() {
      return value;
    }

    public Object getSecondValue() {
      return secondValue;
    }

    public boolean isNoValue() {
      return noValue;
    }

    public boolean isSingleValue() {
      return singleValue;
    }

    public boolean isBetweenValue() {
      return betweenValue;
    }

    public boolean isListValue() {
      return listValue;
    }

    public String getTypeHandler() {
      return typeHandler;
    }
  }
}