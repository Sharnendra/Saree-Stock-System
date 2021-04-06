package com.shopsaree.stock.security;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

//import com.rnlic.hrapp.constant.MessagesConstants;

public class JwtSuccessHandler implements AuthenticationSuccessHandler{
	//private static final Logger log = LogManager.getLogger(JwtSuccessHandler.class);
	
	//@Autowired
	//private MessagesConstants messagesConstants;
	
	@Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
		//log.info(messagesConstants.getJWT_SUCCESSFUL_AUTHENTICATE());
    }
}
