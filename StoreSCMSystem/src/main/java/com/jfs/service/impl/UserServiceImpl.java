package com.jfs.service.impl;

import com.jfs.dao.UserMapper;
import com.jfs.domain.User;
import com.jfs.exception.UserExistException;
import com.jfs.service.IUserService;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;




@Service
public class UserServiceImpl implements IUserService {

    private Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;


    @Override
    public int updateUser(User user,String username,String password) throws UserExistException {


        User u = userMapper.findByUsername(username);

        if(user.getUserId()!=u.getUserId()){
            throw new UserExistException("用户名重复！");
        }

        user.setUsername(username);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(password));
        int i = userMapper.updateByExample(user);

        return i;

    }

    @Override
    public User findUser(Integer id) {
        User user = userMapper.selectById(id);
        logger.info(user);

        return user;
    }
}
