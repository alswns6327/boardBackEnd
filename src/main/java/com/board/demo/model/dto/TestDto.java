package com.board.demo.model.dto;

import com.board.demo.model.entity.Member;
import com.board.demo.model.entity.Test;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestDto {
    private String email;
    private String nickname;

    public static TestDto of(Test test) {
        return TestDto.builder()
                .email(test.getTest1())
                .nickname(test.getTest2())
                .build();
    }
}