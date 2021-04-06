package com.shopsaree.stock.controller;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.shopsaree.stock.bean.request.AuthReqBean;
import com.shopsaree.stock.bean.response.RestResponse;
import com.shopsaree.stock.constants.UrlConstants;
import com.shopsaree.stock.service.AuthenticationAuthorizationService;

@RestController
public class AuthenticationAuthorizationController {
	
	@Autowired
	private AuthenticationAuthorizationService service;

	@PostMapping(UrlConstants.AUTHENTICATE_URL)
	public RestResponse authenticateAndGenerateJwtToken(@RequestBody AuthReqBean authReqBean) throws RestClientException, IOException{
		RestResponse restResponse = new RestResponse(UUID.randomUUID().toString());
		restResponse.setData(service.authenticateAndGenerateToken(authReqBean));
		return restResponse;
	}
}
