package com.myorg.imagehub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppSecurityConfig {
	
	
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

    	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    	.and().csrf().disable()
    	.authorizeHttpRequests().anyRequest().permitAll();
    	
    	return http.build();
    }
}
