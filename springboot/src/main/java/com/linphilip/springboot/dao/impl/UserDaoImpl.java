package com.linphilip.springboot.dao.impl;

import com.linphilip.springboot.dao.UserDao;
import com.linphilip.springboot.dto.UserQueryParams;
import com.linphilip.springboot.model.User;
import com.linphilip.springboot.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<User> getUsers(UserQueryParams userQueryParams) {
        String sql = "SELECT id, username, password, nickname, email," +
                " phone, address, create_time " +
                "FROM user WHERE 1=1";

        Map<String, Object> map = new HashMap<>();

        //査詢條件
        sql = addFilteringSql(sql, map, userQueryParams);

        sql = sql + " ORDER BY " + userQueryParams.getOrderBy() + " " + userQueryParams.getSort();

        // 分頁
        sql = sql + " LIMIT :pageSize OFFSET :pageNum";
        map.put("pageNum", userQueryParams.getPageNum());
        map.put("pageSize", userQueryParams.getPageSize());

        List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());

        return userList;
    }

    @Override
    public Integer countUser(UserQueryParams userQueryParams) {
        String sql = "SELECT count(*) FROM user WHERE 1=1";

        Map<String, Object> map = new HashMap<>();

        //査詢條件
        sql = addFilteringSql(sql, map, userQueryParams);

        Integer total = namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);

        return total;
    }

    private String addFilteringSql(String sql, Map<String, Object> map, UserQueryParams userQueryParams){
        if (userQueryParams.getUsername() != null) {
            sql = sql + " AND username LIKE :username";
            map.put("username", "%" + userQueryParams.getUsername() + "%");
        }

        if (userQueryParams.getEmail() != null) {
            sql = sql + " AND email LIKE :email";
            map.put("email", "%" + userQueryParams.getEmail() + "%");
        }

        if (userQueryParams.getAddress() != null) {
            sql = sql + " AND address LIKE :address";
            map.put("address", "%" + userQueryParams.getAddress() + "%");
        }

        return sql;
    }
}
