package com.jfs.security;


import com.jfs.dao.PermissionMapper;
import com.jfs.dao.UserMapper;
import com.jfs.domain.Permission;
import com.jfs.domain.User;
import com.jfs.exception.UserNotExistException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;


public class MyUserDetailService implements UserDetailsService{

    private Logger logger = LogManager.getLogger(MyUserDetailService.class);


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //更据用户名查询用户信息
        User user = userMapper.findByUsername(username);
        if(user!=null){

            //根据用户名查询当前用户的所有权限
            List<Permission> permissionList = permissionMapper.selectByUserId(user.getUserId(),true);
            //authotities：存放所有用户权限
            List<GrantedAuthority> authorities = new ArrayList<>();
            for(Permission permission:permissionList){

                GrantedAuthority authority = new SimpleGrantedAuthority(permission.getPermtag());
                authorities.add(authority);

            }
            //把所有权限赋值给user
            user.setAuthorities(authorities);

            logger.info("当前用户:"+user);

        }
        if(user==null){
            throw new UserNotExistException("帐号不存在，请重新输入");
        }

        return user;
    }
}
