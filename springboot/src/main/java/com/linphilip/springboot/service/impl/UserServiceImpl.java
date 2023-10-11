package com.linphilip.springboot.service.impl;

import com.linphilip.springboot.dao.UserDao;
import com.linphilip.springboot.dto.UserQueryParams;
import com.linphilip.springboot.model.User;
import com.linphilip.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers(UserQueryParams userQueryParams) {
        return userDao.getUsers(userQueryParams);
    }

    @Override
    public Integer countUser(UserQueryParams userQueryParams) {
        return userDao.countUser(userQueryParams);
    }
}
