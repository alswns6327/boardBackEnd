package com.board.demo.controller;

import com.board.demo.model.dao.TestDao;
import com.board.demo.model.dto.TestDto;
import com.board.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/api/test")
    public @ResponseBody Map<String, Object> test() throws Exception{
        Map<String, Object> returnMap = new HashMap<>();

        List<TestDto> returnDto = testService.selectTest();

        returnMap.put("testValue", returnDto);

        return returnMap;
    }
}
