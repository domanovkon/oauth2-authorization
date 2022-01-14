package com.domanov.gatewaycloud.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("api/v1/flights", "api/v1/privilege", "api/v1/me", "api/v1/tickets", "api/v1/tickets/{ticketUid}").permitAll()
                .and().authorizeRequests().antMatchers(HttpMethod.POST).permitAll()
                .anyRequest().authenticated()
                .and().oauth2Login();
        http.csrf().disable();
    }
}
