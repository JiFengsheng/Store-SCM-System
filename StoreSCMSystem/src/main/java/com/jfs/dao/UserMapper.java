package com.jfs.dao;

import com.jfs.domain.User;
import java.util.List;

public interface UserMapper {

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User findByUsername(String username);


    User selectById(Integer userId);

    List<User> selectByUsername(String username);

    List<User> selectByRealname(String realname);

    int updateByExample(User user);


}