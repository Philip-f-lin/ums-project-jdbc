package com.linphilip.springboot.dao;

import com.linphilip.springboot.dto.ManagerRegisterRequest;

public interface ManagerDao {
    boolean createManager(ManagerRegisterRequest managerRegisterRequest);
}
