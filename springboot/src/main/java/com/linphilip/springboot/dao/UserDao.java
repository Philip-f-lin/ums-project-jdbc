package com.linphilip.springboot.dao;

import com.linphilip.springboot.dto.UserQueryParams;
import com.linphilip.springboot.dto.UserRequest;
import com.linphilip.springboot.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao{
    List<User> getUsers(UserQueryParams userQueryParams);

    User getUserById(Integer id);

    Integer createUser(UserRequest userRequest);

    Integer countUser(UserQueryParams userQueryParams);

    void updateUser(UserRequest userRequest);


}
