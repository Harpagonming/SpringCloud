package com.zhenming.demo.cloud.security.service.security;

import com.zhenming.demo.cloud.security.dao.UserMapper;
import com.zhenming.demo.cloud.security.entity.User;
import com.zhenming.demo.cloud.security.entity.UserExample;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
  @Resource
  private UserMapper userMapper;

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    UserExample example = new UserExample();
    example.createCriteria().andUsernameEqualTo(s);
    List<User> list = userMapper.selectByExample(example);
    if (list == null) {
      throw new UsernameNotFoundException("该用户不存在……");
    }
    User user = list.get(0);
//    List<Role> roleList = new ArrayList<>();
//    UserRoleExample userRoleExample = new UserRoleExample();
//    userRoleExample.createCriteria().andUserIdEqualTo(user.getUserId());
//    List<UserRole> roleIdList = userRoleMapper.selectByExample(userRoleExample);
//    for (UserRole ur : roleIdList) {
//      roleList.add(roleMapper.selectByPrimaryKey(ur.getRoleId()));
//    }
//    user.setRoles(roleList);
    return user;
  }
}
