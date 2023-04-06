package com.board.demo.scurity.auth;

import com.board.demo.model.dao.MemberDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class MemberDtailService implements UserDetailsService {

    @Autowired
    MemberDao memberDao;

    private final BCryptPasswordEncoder passwordEncoder;

    public int save(Map<String, Object> userInfo){

        userInfo.put("password", passwordEncoder.encode(String.valueOf(userInfo.get("password"))));

        return memberDao.save(userInfo);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("111 : " + username);


        return null;
    }
}
