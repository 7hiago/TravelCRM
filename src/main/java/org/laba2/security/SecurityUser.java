package org.laba2.security;

import org.laba2.entities.Manager;
import org.laba2.entities.Status;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class SecurityUser implements UserDetails {

    private String login;
    private String password;
    private List<SimpleGrantedAuthority> authorities;
    private boolean isActive;

    public SecurityUser(String login, String password, List<SimpleGrantedAuthority> authorities, boolean isActive) {
        this.login = login;
        this.password = password;
        this.authorities = authorities;
        this.isActive = isActive;
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
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public static UserDetails fromUser(Manager manager) {
        return new User(
                manager.getLogin(),
                manager.getPassword(),
                manager.getStatus().equals(Status.ACTIVE),
                manager.getStatus().equals(Status.ACTIVE),
                manager.getStatus().equals(Status.ACTIVE),
                manager.getStatus().equals(Status.ACTIVE),
                manager.getRole().getAuthorities()
        );
    }
}
