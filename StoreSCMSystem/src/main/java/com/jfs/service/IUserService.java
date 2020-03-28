package com.jfs.service;

import com.jfs.domain.User;
import com.jfs.exception.UserExistException;

public interface IUserService {

    public int updateUser(User user, String username, String password) throws UserExistException;

    public User findUser(Integer id);
}
