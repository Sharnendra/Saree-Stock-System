package com.shopsaree.stock.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.shopsaree.stock.exception.JWTTokenException;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private JwtValidator validator;
    
    private static String autoritiesRole = "";

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    	JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
        String token = jwtAuthenticationToken.getToken();

        UserDetailsBean jwtUser = validator.validate(token);
        if (jwtUser == null) {
            throw new JWTTokenException(String.valueOf(HttpStatus.OK),"Incorrect JWT Token",false);
        }
        
        if(validator.isTokenExpired(token)) {
        	 throw new JWTTokenException(String.valueOf(HttpStatus.OK),"Token Expired",false);
        }

        List<GrantedAuthority> grantedAuthorities =AuthorityUtils.createAuthorityList(roleMapper(jwtUser.getRole()));
        return new JwtUserDetails(jwtUser,
                token,
                grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return (JwtAuthenticationToken.class.isAssignableFrom(aClass));
    }
    
    private static String roleMapper(List<String> list) {
		if (list != null && !list.isEmpty()) {
			list.stream().forEach(string -> {
				if (string == null) {
					autoritiesRole = "";
				} else {
					if (autoritiesRole.equalsIgnoreCase("")) {
						autoritiesRole = string;
					} else {
						autoritiesRole = autoritiesRole + "," + string;
					}
				}
			});
		}
		if (autoritiesRole.equalsIgnoreCase("")) {
			autoritiesRole = "null";
		}
		return autoritiesRole;
	}
}
