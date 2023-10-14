package com.linphilip.springboot.service.impl;

import com.linphilip.springboot.dao.ManagerDao;
import com.linphilip.springboot.dto.ManagerRegisterRequest;
import com.linphilip.springboot.model.Manager;
import com.linphilip.springboot.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    @Override
    public boolean register(ManagerRegisterRequest managerRegisterRequest) {
        // 檢查註冊的 username
        Manager manager = managerDao.getManagerByUsername(managerRegisterRequest.getUsername());

        if (manager != null){
            return false;
        }

        // 創建帳號
        return managerDao.createManager(managerRegisterRequest);
    }
}
