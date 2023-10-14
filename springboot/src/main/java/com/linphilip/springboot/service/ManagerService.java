package com.linphilip.springboot.service;

import com.linphilip.springboot.dto.ManagerLoginRequest;
import com.linphilip.springboot.dto.ManagerRegisterRequest;
import com.linphilip.springboot.model.Manager;

public interface ManagerService {
    boolean register(ManagerRegisterRequest managerRegisterRequest);

    boolean login(ManagerLoginRequest managerLoginRequest);

    Manager getManagerById(Integer id);
}
