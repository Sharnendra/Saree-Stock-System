package com.shopsaree.stock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopsaree.stock.vo.StockDetails;

@RestController
@RequestMapping("/stock-service")
public class StockDetailsController {
	
	@GetMapping("/getStockDetails")
	public StockDetails getStockDetails() {
		return new StockDetails.StockBuilder("Benarasi", 50, 1250).build();
	}
}
