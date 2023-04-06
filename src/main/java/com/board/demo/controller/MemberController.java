package com.board.demo.controller;

import com.board.demo.scurity.auth.MemberDetails;
import com.board.demo.scurity.auth.MemberDtailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class MemberController {

    @Autowired
    MemberDtailService memberDtailService;

    @PostMapping("/api/member/save")
    public String save(@RequestBody Map<String, Object> userInfo){
        String url = "aa";
        if(memberDtailService.save(userInfo) > 0){
            url = "good";
        }

        return url;
    }

    @PostMapping("/api/member/count-email")
    public String countByEmailAndDropYn(Model model, MemberDetails member){
        return "aaa";
    }
}
