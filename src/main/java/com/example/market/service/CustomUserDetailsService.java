package com.example.market.service;

import com.example.market.model.User;
import com.example.market.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username));

        System.out.println("DB에서 로드된 사용자 비밀번호: " + user.getPassword());

        // 테스트: 입력 비밀번호와 DB 비밀번호 매칭
        String testRawPassword = "@Polytech2301110323"; // 테스트용 비밀번호
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean isMatch = encoder.matches(testRawPassword, user.getPassword());
        System.out.println("비밀번호 매칭 결과 (테스트): " + isMatch);

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList())
        );
    }
}