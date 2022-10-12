package com.nick.playground.services;

import com.nick.playground.mapper.TblTestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@Service
@Transactional
public class PropagationServiceA {
    private static final Logger logger = LoggerFactory.getLogger(PropagationServiceA.class);
    @Autowired
    private TblTestMapper mapper;

    @Autowired
    private PropagationServiceB serviceB;

    public void insert() throws SQLException {
        try{
            mapper.insertDumbData();
            serviceB.insert();
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

    }
}
