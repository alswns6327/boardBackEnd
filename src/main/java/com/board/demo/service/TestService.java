package com.board.demo.service;

import com.board.demo.model.dto.TestDto;

import java.util.List;

public interface TestService {
    List<TestDto> selectTest() throws Exception;
}
