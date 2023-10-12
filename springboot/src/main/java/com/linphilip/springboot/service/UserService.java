package com.linphilip.springboot.service;


import com.linphilip.springboot.dto.UserQueryParams;
import com.linphilip.springboot.dto.UserRequest;
import com.linphilip.springboot.model.User;

import java.util.List;


public interface UserService{

    List<User> getUsers(UserQueryParams userQueryParams);

    User getUserById(Integer id);

    Integer countUser(UserQueryParams userQueryParams);

    boolean saveUser(UserRequest userRequest);
}
