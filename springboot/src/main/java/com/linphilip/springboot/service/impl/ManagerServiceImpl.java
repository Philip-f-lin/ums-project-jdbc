package com.linphilip.springboot.service.impl;

import com.linphilip.springboot.dao.ManagerDao;
import com.linphilip.springboot.dto.ManagerLoginRequest;
import com.linphilip.springboot.dto.ManagerRegisterRequest;
import com.linphilip.springboot.model.Manager;
import com.linphilip.springboot.service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

@Component
public class ManagerServiceImpl implements ManagerService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

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
    public Manager login(ManagerLoginRequest managerLoginRequest) {
        Manager manager = managerDao.getManagerByUsername(managerLoginRequest.getUsername());

        // 檢查 manager 是否存在
        if (manager == null){
            log.warn("該 username: {} 尚未註冊", managerLoginRequest.getUsername());
            return null;
        }

        // 使用 MD5 生成密碼的雜湊值
        String hashedPassword = DigestUtils.md5DigestAsHex(managerLoginRequest.getPassword().getBytes());


        // 比較密碼
        if (manager.getPassword().equals(hashedPassword)){
            return manager;
        }else {
            log.warn("username: {} 的密碼不正確", managerLoginRequest.getUsername());
            return null;
        }
    }

    @Override
    public Manager getManagerById(Integer id) {
        return managerDao.getManagerById(id);
    }
}
