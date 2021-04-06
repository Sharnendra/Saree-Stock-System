package com.shopsaree.stock.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopsaree.stock.constants.GenericConstants;
import com.shopsaree.stock.vo.StockDetails;

@RestController
@RequestMapping("/service")
public class StockDetailsController {
	
	@PostMapping("/getStockDetails")
	public StockDetails getStockDetails(@RequestHeader(GenericConstants.AUTHORIZATION) String jwtToken) {
		return new StockDetails.Builder("Benarasi", 50, 1250).build();
	}
}
