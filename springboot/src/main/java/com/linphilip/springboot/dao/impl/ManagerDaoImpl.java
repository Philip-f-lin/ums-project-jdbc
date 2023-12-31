package com.linphilip.springboot.dao.impl;

import com.linphilip.springboot.dao.ManagerDao;
import com.linphilip.springboot.dto.ManagerRegisterRequest;
import com.linphilip.springboot.model.Manager;
import com.linphilip.springboot.rowmapper.ManagerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ManagerDaoImpl implements ManagerDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public boolean createManager(ManagerRegisterRequest managerRegisterRequest) {
        String sql = "INSERT INTO manager (username, password, created_date, last_modified_date) " +
                "VALUES (:username, :password, :createdDate, :lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("username", managerRegisterRequest.getUsername());
        map.put("password", managerRegisterRequest.getPassword());

        map.put("createdDate", new Date());
        map.put("lastModifiedDate", new Date());

        int i = namedParameterJdbcTemplate.update(sql, map);
        return i > 0;
    }

    @Override
    public Manager getManagerByUsername(String username) {
        String sql = "SELECT id, username, password, created_date, last_modified_date " +
                "FROM manager WHERE username = :username";

        Map<String, Object> map = new HashMap<>();
        map.put("username", username);

        List<com.linphilip.springboot.model.Manager> managerList = namedParameterJdbcTemplate.query(sql, map, new ManagerRowMapper());

        if (managerList.size() > 0){
            return managerList.get(0);
        }else {
            return null;
        }

    }

    @Override
    public Manager getManagerById(Integer id) {
        String sql = "SELECT id, username, password, created_date, last_modified_date " +
                "FROM manager WHERE id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);

        List<Manager> managerList = namedParameterJdbcTemplate.query(sql, map, new ManagerRowMapper());

        if (managerList.size() > 0){
            return managerList.get(0);
        }else {
            return null;
        }

    }
}
