package com.shopsaree.stock.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shopsaree.stock.bean.request.AuthReqBean;
import com.shopsaree.stock.bean.response.RestResponse;
import com.shopsaree.stock.constants.UrlConstants;

@RestController
public class AuthenticationAuthorizationController {

	@PostMapping(UrlConstants.AUTHENTICATE_URL)
	public RestResponse authenticateAndGenerateJwtToken(@RequestBody AuthReqBean authReqBean) throws JsonProcessingException{
		RestResponse restResponse = new RestResponse(UUID.randomUUID().toString());
		return restResponse;
	}
}
