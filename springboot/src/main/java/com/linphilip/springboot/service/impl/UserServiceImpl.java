package com.linphilip.springboot.service.impl;

import com.linphilip.springboot.dao.UserDao;
import com.linphilip.springboot.dto.UserQueryParams;
import com.linphilip.springboot.dto.UserRequest;
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
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public Integer countUser(UserQueryParams userQueryParams) {
        return userDao.countUser(userQueryParams);
    }

    @Override
    public boolean saveUser(UserRequest userRequest) {
        if(userRequest.getId() == null){
            Integer i = userDao.createUser(userRequest);
            return i > 0;
        }else{
            userDao.updateUser(userRequest);
            return true;
        }

    }

    @Override
    public boolean deleteUserById(Integer id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public boolean deleteBatchByIds(List<Integer> ids) {
        return userDao.deleteBatchByIds(ids);
    }

}
