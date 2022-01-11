package com.fanedesign.Vente.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    public void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();
    }
}
