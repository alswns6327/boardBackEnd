package com.board.demo.controller;

import com.board.demo.model.dto.MemberRequestDto;
import com.board.demo.model.dto.MemberResponseDto;
import com.board.demo.model.dto.TestDto;
import com.board.demo.model.entity.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TestController {


    private final com.board.demo.service.Test test;


    @GetMapping("/test")
    public ResponseEntity<List<Test>> setMemberNickname() {
        System.out.println(111);
        return ResponseEntity.ok(test.find());
    }

}
