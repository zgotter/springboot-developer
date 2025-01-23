package me.sounghan.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Builder
    public User(String email, String password, String auth) {
        this.email = email;
        this.password = password;
    }

    @Override // 권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override // 사용자의 id를 반환 (고유한 값)
    public String getUsername() {
        return email;
    }

    @Override // 계정 만료 여부 반환
    public boolean isAccountNonExpired() {
        // 만료되었는 지 확인하는 로직
        return true; // true -> 만료되지 않았음
    }

    @Override // 계정 잠금 여부 반환
    public boolean isAccountNonLocked() {
        // 계정 잠금되었는 지 확인하는 로직
        return true; // true -> 잠금되지 않았음
    }

    @Override // 패스워드 만료 여부 반환
    public boolean isCredentialsNonExpired() {
        // 패스워드가 만료되었는 지 확인하는 로직
        return true; // true -> 만료되지 않았음
    }

    @Override // 계정 사용 가능 여부 반환
    public boolean isEnabled() {
        // 계정이 사용 가능한 지 확인하는 로직
        return true; // true -> 사용 가능
    }
}
