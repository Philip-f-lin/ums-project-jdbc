package com.linphilip.springboot.rowmapper;

import com.linphilip.springboot.model.Manager;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerRowMapper implements RowMapper<Manager> {
    @Override
    public Manager mapRow(ResultSet resultSet, int i) throws SQLException {
        Manager manager = new Manager();

        manager.setUsername(resultSet.getString("username"));
        manager.setPassword(resultSet.getString("password"));
        manager.setCreated_date(resultSet.getTimestamp("created_date"));
        manager.setLast_modified_date(resultSet.getTimestamp("last_modified_date"));

        return manager;
    }
}
