package com.linphilip.springboot.service;


import com.linphilip.springboot.dto.*;
import com.linphilip.springboot.model.Manager;
import com.linphilip.springboot.model.User;

import java.util.List;


public interface UserService{

    List<User> getUsers(UserQueryParams userQueryParams);

    User getUserById(Integer id);

    Integer countUser(UserQueryParams userQueryParams);

    boolean saveUser(UserRequest userRequest);

    boolean deleteUserById(Integer id);

    boolean deleteBatchByIds(List<Integer> ids);
}
