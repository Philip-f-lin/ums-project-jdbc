package com.linphilip.springboot.service;

import com.linphilip.springboot.dto.ManagerRegisterRequest;

public interface ManagerService {
    boolean register(ManagerRegisterRequest managerRegisterRequest);
}
