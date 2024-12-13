package com.example.market.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS") // USERS 테이블과 매핑
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "USER_ROLES", joinColumns = @JoinColumn(name = "USER_ID")) // USER_ROLES 테이블의 USER_ID 참조
    @Column(name = "ROLE") // USER_ROLES의 ROLE 컬럼과 매핑
    private Set<String> roles = new HashSet<>();
}

