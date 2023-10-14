package com.linphilip.springboot.dao;

import com.linphilip.springboot.dto.ManagerRegisterRequest;
import com.linphilip.springboot.model.Manager;

public interface ManagerDao {
    boolean createManager(ManagerRegisterRequest managerRegisterRequest);

    Manager getManagerByUsername(String username);

    Manager getManagerById(Integer id);
}
