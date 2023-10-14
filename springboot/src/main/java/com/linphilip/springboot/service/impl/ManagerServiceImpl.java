package com.linphilip.springboot.service.impl;

import com.linphilip.springboot.dao.ManagerDao;
import com.linphilip.springboot.dto.ManagerRegisterRequest;
import com.linphilip.springboot.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    @Override
    public boolean register(ManagerRegisterRequest managerRegisterRequest) {
        return managerDao.createManager(managerRegisterRequest);
    }
}
