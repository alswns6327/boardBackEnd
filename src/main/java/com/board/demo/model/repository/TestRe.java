package com.board.demo.model.repository;


import com.board.demo.model.dto.TestDto;
import com.board.demo.model.entity.Member;
import com.board.demo.model.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRe extends JpaRepository<Test, Long> {

}