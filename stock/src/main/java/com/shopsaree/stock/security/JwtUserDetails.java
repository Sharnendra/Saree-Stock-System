package com.shopsaree.stock.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class JwtUserDetails implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDetailsBean jwtUser;
    private String token;
    private Collection<? extends GrantedAuthority> authorities;


    public JwtUserDetails(UserDetailsBean jwtUser, String token, List<GrantedAuthority> grantedAuthorities) {

        this.jwtUser = jwtUser;
        this.token= token;
        this.authorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
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
    public String getToken() {
        return token;
    }

	@Override
	public String getUsername() {
		return jwtUser.getFristName();
	}

	public UserDetailsBean getJwtUser() {
		return jwtUser;
	}

	public void setJwtUser(UserDetailsBean jwtUser) {
		this.jwtUser = jwtUser;
	}
	
}
