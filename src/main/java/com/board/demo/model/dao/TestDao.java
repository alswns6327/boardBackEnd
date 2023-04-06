package com.board.demo.model.dao;

import com.board.demo.model.dto.TestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestDao {

    List<TestDto> selectTest() throws Exception;
}
