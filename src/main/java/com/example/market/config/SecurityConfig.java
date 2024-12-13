package com.example.market.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll() // 정적 리소스 허용
                        .requestMatchers("/auth/login", "/auth/register", "/error").permitAll() // 로그인, 회원가입, 에러 허용
                        .requestMatchers("/menu_announcement").authenticated() // 인증 필요한 경로
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/auth/login") // 로그인 페이지 경로
                        .loginProcessingUrl("/auth/login") // Spring Security가 로그인 요청을 처리할 경로
                        .defaultSuccessUrl("/", true) // 로그인 성공 시 이동 경로
                        .failureUrl("/auth/login?error=true") // 로그인 실패 시 이동 경로
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/auth/login?logout=true")
                        .permitAll()
                )
                .exceptionHandling(ex -> ex
                        .accessDeniedPage("/access-denied") // 권한 거부 시 이동할 페이지
                )
                .csrf().disable(); // CSRF 비활성화 (개발 중에만 사용)

        return http.build();
    }
}
