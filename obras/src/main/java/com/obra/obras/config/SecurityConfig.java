package com.obra.obras.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                    .antMatchers("/api/obras/**")
                        .authenticated()
                    .antMatchers("/api/inspecoes/**")
                        .authenticated()
                    .antMatchers("/api/detalhesobra/**")
                        .authenticated()
                    .antMatchers("/api/obrainspecoes/**")
                        .authenticated()
                    .antMatchers("/api/obralocal/**")
                        .authenticated()
                    .antMatchers(HttpMethod.POST,"/api/usuarios/**")
                        .permitAll()
                    .antMatchers("/h2-console/**")
                        .permitAll()
                    .anyRequest().authenticated()
                .and()
                .httpBasic();
        return http.build();
    }

}
