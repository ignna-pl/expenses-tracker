package com.expenses.application;

import com.expenses.application.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                (requests) -> requests
                        .requestMatchers("/").permitAll() //Allows everyone to access the home page
                        .anyRequest().authenticated() //Allows only authenticated users access other pages
                )
                .formLogin((form) -> form
                        .defaultSuccessUrl("/home", true) //Successful login redirects to home page
                        .permitAll() //Allows everyone to access the login page
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

}
