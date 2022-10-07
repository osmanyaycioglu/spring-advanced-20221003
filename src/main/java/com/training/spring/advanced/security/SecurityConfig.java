package com.training.spring.advanced.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public MyUserDetailService myUserDetailService() {
        return new MyUserDetailService(bCryptPasswordEncoder());
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http)
            throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                   .userDetailsService(myUserDetailService())
                   .passwordEncoder(bCryptPasswordEncoder())
                   .and()
                   .build();
    }

    @Bean
    public JWTRequestFilter jwtRequestFilter() {
        return new JWTRequestFilter();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
            .disable()
            .cors()
            .disable()
            .authorizeRequests()
            .antMatchers("/actuator/**","/token/**")
            .anonymous()
            .antMatchers("/api/**")
            .hasAnyRole("ADMIN",
                        "USER")
            .antMatchers("/greetings/**")
            .hasAnyRole("ADMIN")
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter(),
                             UsernamePasswordAuthenticationFilter.class);

        return http.build();
//            .antMatchers(HttpMethod.DELETE)
//                .hasRole("ADMIN")
//                .antMatchers("/admin/**")
//                .hasAnyRole("ADMIN")
//                .antMatchers("/user/**")
//                .hasAnyRole("USER",
//                            "ADMIN")
//                .antMatchers("/login/**")
//                .anonymous()

    }

}
