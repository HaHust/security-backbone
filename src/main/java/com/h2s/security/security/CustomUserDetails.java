/*
 * @created 30/09/2021 - 9:48 PM
 * @author vanha
 */

package com.h2s.security.security;

import com.h2s.security.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private Integer id;
    private String email;
    private String password;
    private Integer enabled;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(String email, String password, Integer enabled, Collection<? extends GrantedAuthority> authorities) {
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    public static UserDetails create(User user){
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role->{
            return new SimpleGrantedAuthority(role.getRoleName().name());
        }).collect(Collectors.toList());

        return new CustomUserDetails(
                user.getEmail(),
                user.getPassword(),
                user.getEnabled(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
