package com.shopsaree.stock.service;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.shopsaree.stock.bean.request.AuthReqBean;
import com.shopsaree.stock.bean.response.AuthResBean;
import com.shopsaree.stock.bean.response.ResponseData;
import com.shopsaree.stock.security.JwtGenerator;
import com.shopsaree.stock.security.UserDetailsBean;

@Service
public class AuthenticationAuthorizationService {

	@Autowired
	private JwtGenerator jwtGenerator;
	
	/**
	 * This method will authenticate user and generate JWT_Token
	 * 
	 * @param AuthReqBean authReqBean
	 * @return ResponseData authRes
	 * @throws RestClientException
	 * @throws IOException
	 */
	public ResponseData authenticateAndGenerateToken(AuthReqBean authReqBean) throws RestClientException, IOException {
		final UserDetailsBean jwtUser = getAuthenticationData(authReqBean);
		AuthResBean authRes = new AuthResBean();
		authRes.setToken(jwtGenerator.generate(jwtUser));
		authRes.setUserInfo(jwtUser);
		return authRes;
	}

	private UserDetailsBean getAuthenticationData(AuthReqBean authReqBean) {
		UserDetailsBean userDetailsBean=new UserDetailsBean();
		userDetailsBean.setDeviceIdentifier(authReqBean.getDeviceIdentifier());
		userDetailsBean.setEmail(authReqBean.getEmail());
		userDetailsBean.setFcmToken(authReqBean.getFcmToken());
		userDetailsBean.setFristName(authReqBean.getFristName());
		userDetailsBean.setLastName(authReqBean.getLastName());
		userDetailsBean.setMobileNumber(authReqBean.getMobileNumber());
		userDetailsBean.setRole(Arrays.asList("Admin","Seller"));
		return userDetailsBean;
	}
}
