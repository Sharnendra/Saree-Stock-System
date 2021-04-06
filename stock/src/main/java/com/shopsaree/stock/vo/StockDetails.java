package com.shopsaree.stock.vo;

public class StockDetails {
	
	private String sareeType;
	private int quantity;
	private int costPerPice;
	private int profitMargin;
	private int totalCostToCustomer;
	
	public String getSareeType() {
		return sareeType;
	}
	public void setSareeType(String sareeType) {
		this.sareeType = sareeType;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCostPerPice() {
		return costPerPice;
	}
	public void setCostPerPice(int costPerPice) {
		this.costPerPice = costPerPice;
	}
	public int getProfitMargin() {
		return profitMargin;
	}
	public void setProfitMargin(int profitMargin) {
		this.profitMargin = profitMargin;
	}
	public int getTotalCostToCustomer() {
		return totalCostToCustomer;
	}
	public void setTotalCostToCustomer(int totalCostToCustomer) {
		this.totalCostToCustomer = totalCostToCustomer;
	}
	public StockDetails(Builder stockBuilder) {
		this.sareeType = stockBuilder.sareeType;
		this.quantity = stockBuilder.quantity;
		this.costPerPice = stockBuilder.costPerPice;
		this.profitMargin = stockBuilder.profitMargin;
		this.totalCostToCustomer = stockBuilder.totalCostToCustomer;
	}
	public static class Builder{
		
		private String sareeType;
		private int quantity;
		private int costPerPice;
		private int profitMargin;
		private int totalCostToCustomer;
		
		public Builder(String sareeType, int quantity, int costPerPice) {
			this.sareeType = sareeType;
			this.quantity = quantity;
			this.costPerPice = costPerPice;
		}

		public Builder setProfitMargin(int profitMargin) {
			this.profitMargin = profitMargin;
			return this;
		}

		public Builder setTotalCostToCustomer(int totalCostToCustomer) {
			this.totalCostToCustomer = totalCostToCustomer;
			return this;
		}
		
		public StockDetails build() {
			return new StockDetails(this);
		}
	}
	

}
