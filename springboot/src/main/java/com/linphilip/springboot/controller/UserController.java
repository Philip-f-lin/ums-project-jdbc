package com.linphilip.springboot.controller;

import com.linphilip.springboot.dto.UserQueryParams;
import com.linphilip.springboot.model.User;
import com.linphilip.springboot.service.UserService;
import com.linphilip.springboot.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/page")
    public Page<User> getUsers(
            // 查詢條件 Filtering
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String address,

            // 排序 Sorting
            @RequestParam(defaultValue = "create_time") String orderBy,
            @RequestParam(defaultValue = "desc") String sort,

            // 分頁 Pagination
            @RequestParam Integer pageNum,
            @RequestParam Integer pageSize
    ) {
        pageNum = (pageNum - 1) * pageSize;

        UserQueryParams userQueryParams = new UserQueryParams();
        userQueryParams.setUsername(username);
        userQueryParams.setEmail(email);
        userQueryParams.setAddress(address);
        userQueryParams.setOrderBy(orderBy);
        userQueryParams.setSort(sort);
        userQueryParams.setPageNum(pageNum);
        userQueryParams.setPageSize(pageSize);

        // 取得 user list
        List<User> userList = userService.getUsers(userQueryParams);

        // 取得 product 總數
        Integer total = userService.countUser(userQueryParams);

        // 分頁
        Page<User> page = new Page<>();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        page.setTotal(total);
        page.setResults(userList);

        return page;
    }
}
