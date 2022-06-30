package com.apaza.citas.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
public class UserDetail implements UserDetails {

    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    public static UserDetail build(Users users){
        Set<GrantedAuthority> roles = new HashSet<>();
        for (RoleUser role : users.getRoles()){
            roles.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
        }
        return new UserDetail(users.getUsername(), users.getPassword(), roles);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
