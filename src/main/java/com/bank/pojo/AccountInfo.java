package com.bank.pojo;

public class AccountInfo {
	

	private int totalBalance= 0;
	private String TransactionRemarks;

	public float getTotalBalance() {
		return this.totalBalance;
	}

	public void setTotalBalance(int balance) {
		if(balance > 0 ) {
			this.totalBalance= balance;
		}
	}
	public String getTransactionRemarks() {
		return TransactionRemarks;

	}

	public void setTransactionRemarks(String remarks) {
		this.TransactionRemarks = remarks;
	}

	public AccountInfo() {
		this(200000, "Total amount in bank");
	}

	public AccountInfo(int balance, String remarks) {
		super();
		this.totalBalance = balance;

	}
}
