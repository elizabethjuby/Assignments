package com.test.accounts.models;

import java.util.Date;

public class Statement {
	
	private Date datefield;
	private String amount;
	private int account_id;
	private int ID;
	
	public Statement(int account_id,Date datefield,int ID,  String amount) {
		this.account_id = account_id;
		this.datefield = datefield;
		this.ID = ID;
		
		
		
		this.amount = amount;
		
		
	}
	public Date getDatefield() {
		return datefield;
	}
	public void setDatefield(Date datefield) {
		this.datefield = datefield;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	

}
