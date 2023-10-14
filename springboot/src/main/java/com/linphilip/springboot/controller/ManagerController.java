package com.linphilip.springboot.controller;

import com.linphilip.springboot.dto.ManagerRegisterRequest;
import com.linphilip.springboot.model.Manger;
import com.linphilip.springboot.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/managers")
public class ManagerController{

    @Autowired
    private ManagerService managerService;


    @PostMapping("/register")
    public boolean register(@RequestBody @Valid ManagerRegisterRequest managerRegisterRequest){
        return managerService.register(managerRegisterRequest);

    }
}
