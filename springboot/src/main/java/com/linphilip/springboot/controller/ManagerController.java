package com.linphilip.springboot.controller;

import com.linphilip.springboot.dto.ManagerLoginRequest;
import com.linphilip.springboot.dto.ManagerRegisterRequest;
import com.linphilip.springboot.model.Manager;
import com.linphilip.springboot.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/managers")
public class ManagerController{

    @Autowired
    private ManagerService managerService;

    @GetMapping("{id}")
    public Manager getManagerById(@PathVariable Integer id){
        Manager manager = managerService.getManagerById(id);

        if(manager != null){
            return manager;
        }else {
            return null;
        }
    }


    @PostMapping("/register")
    public boolean register(@RequestBody @Valid ManagerRegisterRequest managerRegisterRequest){
        return managerService.register(managerRegisterRequest);

    }

    @PostMapping("login")
    public boolean login(@RequestBody @Valid ManagerLoginRequest managerLoginRequest){
        return managerService.login(managerLoginRequest);
    }
}
