package com.board.demo.scurity.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class MemberAuthenticatorProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        System.out.println("authentication : " + authentication);
        System.out.println("authentication.id : " + authentication.getName());
        System.out.println("authentication.password : " + authentication.getCredentials());



        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
