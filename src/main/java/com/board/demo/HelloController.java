package com.board.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController{

    @GetMapping("/api/con11")
    public List<String> hello(){
        return Arrays.asList("backend", "connection", "complete");
    }


}