package com.banking.creditcardapp.model;

public class CreditCard {
	private String number;
	private String expiration;
	private String holderName;
	private Double amount;

 
	
	public CreditCard(String number, String expiration, Double amount) {
		super();
		this.number = number;
		this.expiration = expiration;
		this.amount = amount;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getExpiration() {
		return expiration;
	}
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
