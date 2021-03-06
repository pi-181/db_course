package com.invokegs.dbcoursework.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class SecurityUserDetails extends org.springframework.security.core.userdetails.User {
    private final Long userId;

    public SecurityUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, Long userId) {
        super(username, password, authorities);
        this.userId = userId;
    }

    public SecurityUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Long userId) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public boolean hasAuthority(String authority) {
        return getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(authority));
    }
}
