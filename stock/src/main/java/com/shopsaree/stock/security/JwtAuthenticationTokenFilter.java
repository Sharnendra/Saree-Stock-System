package com.shopsaree.stock.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.shopsaree.stock.constants.GenericConstants;
import com.shopsaree.stock.constants.UrlConstants;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

	
    public JwtAuthenticationTokenFilter() {
        super(UrlConstants.AUTH_ALL_SERVICE);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

        String header = httpServletRequest.getHeader(GenericConstants.AUTHORIZATION);

        if (header == null) {
            throw new RuntimeException("Security Token is Missing");
        }
        if(!header.startsWith(GenericConstants.BEARER))
        {
        	 throw new RuntimeException("Security Token doesn't have Bearer");
        }

        String authenticationToken = header.replace(GenericConstants.BEARER, "");
        JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
        return getAuthenticationManager().authenticate(token);
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}
