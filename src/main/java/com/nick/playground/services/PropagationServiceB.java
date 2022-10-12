package com.nick.playground.services;

import com.nick.playground.mapper.TblTestBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public class PropagationServiceB {

    @Autowired
    private TblTestBMapper mapper;

    public void insert() throws SQLException {
        mapper.insertDumbData();
        throw new SQLException("Test error");
    }
}
