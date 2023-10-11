package com.linphilip.springboot.dao;

import com.linphilip.springboot.dto.UserQueryParams;
import com.linphilip.springboot.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao{
    List<User> getUsers(UserQueryParams userQueryParams);

    Integer countUser(UserQueryParams userQueryParams);
}
