package com.linphilip.springboot.service.impl;

import com.linphilip.springboot.dao.ManagerDao;
import com.linphilip.springboot.dto.ManagerLoginRequest;
import com.linphilip.springboot.dto.ManagerRegisterRequest;
import com.linphilip.springboot.model.Manager;
import com.linphilip.springboot.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

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

        // 使用 MD5 生成密碼的雜湊值
        String hashedPassword = DigestUtils.md5DigestAsHex(managerRegisterRequest.getPassword().getBytes());
        managerRegisterRequest.setPassword(hashedPassword);

        // 創建帳號
        return managerDao.createManager(managerRegisterRequest);
    }

    @Override
    public boolean login(ManagerLoginRequest managerLoginRequest) {
        Manager manager = managerDao.getManagerByUsername(managerLoginRequest.getUsername());

        // 檢查 manager 是否存在
        if (manager == null){
            return false;
        }

        // 使用 MD5 生成密碼的雜湊值
        String hashedPassword = DigestUtils.md5DigestAsHex(managerLoginRequest.getPassword().getBytes());


        // 比較密碼
        if (manager.getPassword().equals(hashedPassword)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Manager getManagerById(Integer id) {
        return managerDao.getManagerById(id);
    }
}
