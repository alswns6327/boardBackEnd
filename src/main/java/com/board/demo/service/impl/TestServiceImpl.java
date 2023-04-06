package com.board.demo.service.impl;

import com.board.demo.model.dao.TestDao;
import com.board.demo.model.dto.TestDto;
import com.board.demo.service.TestService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestDao testDao;


    @Override
    public List<TestDto> selectTest() throws Exception {
        return testDao.selectTest();
    }
}
