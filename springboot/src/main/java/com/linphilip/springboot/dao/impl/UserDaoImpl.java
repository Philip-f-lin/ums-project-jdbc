package com.linphilip.springboot.dao.impl;

import com.linphilip.springboot.dao.UserDao;
import com.linphilip.springboot.dto.UserQueryParams;
import com.linphilip.springboot.dto.UserRequest;
import com.linphilip.springboot.model.User;
import com.linphilip.springboot.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
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
    public User getUserById(Integer id) {
        String sql = "SELECT id, username, password, nickname, email," +
                " phone, address, create_time " +
                "FROM user WHERE id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);

        List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());
        if(userList.size() > 0){
            return userList.get(0);
        }else {
            return null;
        }

    }

    @Override
    public Integer createUser (UserRequest userRequest) {
        String sql = "INSERT INTO user (username, nickname, email, phone, address, create_time) " +
                "VALUES (:username, :nickname, :email, :phone, :address, :createTime)";

        Map<String, Object> map = new HashMap<>();
        map.put("username", userRequest.getUsername());
        map.put("nickname", userRequest.getNickname());
        map.put("email", userRequest.getEmail());
        map.put("phone", userRequest.getPhone());
        map.put("address", userRequest.getAddress());

        map.put("createTime", new Date());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int id = keyHolder.getKey().intValue();

        return id;
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

    @Override
    public void updateUser(UserRequest userRequest) {
        String sql = "UPDATE user SET username = :username, nickname = :nickname, email = :email," +
                " phone = :phone, address = :address where id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id",userRequest.getId());
        map.put("username", userRequest.getUsername());
        map.put("nickname", userRequest.getNickname());
        map.put("email", userRequest.getEmail());
        map.put("phone", userRequest.getPhone());
        map.put("address", userRequest.getAddress());

        namedParameterJdbcTemplate.update(sql, map);
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
