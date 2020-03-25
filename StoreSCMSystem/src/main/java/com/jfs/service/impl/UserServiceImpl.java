package com.jfs.service.impl;

import com.jfs.dao.UserMapper;
import com.jfs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;





}
