package com.linphilip.springboot.controller;

import com.linphilip.springboot.dto.UserQueryParams;
import com.linphilip.springboot.dto.UserRequest;
import com.linphilip.springboot.model.User;
import com.linphilip.springboot.service.UserService;
import com.linphilip.springboot.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 查詢
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

    // 單表查詢
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Integer id){
        User user = userService.getUserById(id);

        if(user != null){
            return user;
        }else {
            return null;
        }
    }

    // 新增、修改
    @PostMapping("/save")
    public boolean saveUser(@RequestBody @Valid UserRequest userRequest){
        return userService.saveUser(userRequest);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Integer id){
        return userService.deleteUserById(id);
    }

    // 多個刪除
    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return userService.deleteBatchByIds(ids);
    }

}
