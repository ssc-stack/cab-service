package com.assignment.cabservice.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

import java.util.function.Function;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration  {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider
                = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return  provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests().requestMatchers("/car-request/**").hasAuthority("ADMIN").and()
                .authorizeHttpRequests().requestMatchers("/assign-car/**").hasAuthority("ADMIN").and()
                .authorizeHttpRequests().requestMatchers("/delete-driver/**").hasAuthority("ADMIN").and()
                .authorizeHttpRequests().requestMatchers("/delete-car/**").hasAuthority("ADMIN").and()
                .authorizeHttpRequests().requestMatchers("/book-car/**").hasAuthority("USER").and()
                .authorizeHttpRequests().requestMatchers("/cancel-car/**").hasAuthority("USER").and()
                .authorizeHttpRequests().requestMatchers("/swagger-ui.html").permitAll().and()
                .authorizeHttpRequests(
                auth->auth.anyRequest().authenticated());
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
        httpSecurity.headers().defaultsDisabled().cacheControl();
        return httpSecurity.build();
    }
}
