package com.zhenming.demo.security.dao;

import com.zhenming.demo.security.entity.User;
import com.zhenming.demo.security.entity.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
  long countByExample(UserExample example);

  int deleteByExample(UserExample example);

  int deleteByPrimaryKey(Integer userId);

  int insert(User record);

  int insertSelective(User record);

  List<User> selectByExample(UserExample example);

  User selectByPrimaryKey(Integer userId);

  int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

  int updateByExample(@Param("record") User record, @Param("example") UserExample example);

  int updateByPrimaryKeySelective(User record);

  int updateByPrimaryKey(User record);
}