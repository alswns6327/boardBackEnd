package com.board.demo.model.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MemberDao {

    int save(Map<String, Object> userInfo);
    Map<String, Object> findByEmail(String email);
}
