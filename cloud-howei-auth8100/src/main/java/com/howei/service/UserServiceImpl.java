package com.howei.service;

import com.howei.model.User;
import com.howei.mapper.UserMapper;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {


    private UserMapper userMapper;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = new User();
        System.out.println(username);
        return (UserDetails) user;
    }

}