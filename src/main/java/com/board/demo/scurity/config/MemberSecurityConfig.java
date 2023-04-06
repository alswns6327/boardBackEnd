package com.board.demo.scurity.config;

import com.board.demo.scurity.auth.MemberDtailService;
import com.board.demo.scurity.provider.MemberAuthenticatorProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class MemberSecurityConfig {

    @Autowired
    MemberAuthenticatorProvider memberAuthenticatorProvider;

    @Autowired
    MemberDtailService memberDtailService;

    @Autowired
    public void configure (AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(memberAuthenticatorProvider);
    }

    @Bean
    public SecurityFilterChain memberSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeHttpRequests(authorize -> {
           try{
               authorize.requestMatchers("/" ,"/**")
                       .permitAll()
//                       .hasRole("AA")

               .and()
                       .formLogin()
                       .loginPage("/member/login")
                       .loginProcessingUrl("/api/login/action")
                       .defaultSuccessUrl("/member/login-success-default")
                       .successHandler(new MemberAuthSuccessHandler())
                       .failureHandler(new MemberAuthFailureHandler())
                       .permitAll()

               .and()
                       .logout()
                       .logoutUrl("/api/login/logout")
                       .logoutSuccessUrl("/member/login/logout")
                       .deleteCookies("JSESSIONID");
           }catch (Exception e){
               throw new RuntimeException(e);
           }
        });

        http.rememberMe()
                .key("minjunKey")
                .tokenValiditySeconds(60 * 60 * 2)
                .userDetailsService(memberDtailService)
                .rememberMeParameter("remember-me");
        return http.build();
    }
}
