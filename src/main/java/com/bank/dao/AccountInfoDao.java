package com.bank.dao;

import java.util.LinkedList;
import java.util.List;

import com.bank.pojo.AccountInfo;

public class AccountInfoDao {
	
	private final static List<AccountInfo> BALANCE_LIST = new LinkedList<>();
	
	private String accountDetails;
	
	public String getAccountDetails() {
		System.out.println(BALANCE_LIST);
		return accountDetails;
	}
	public void setAccountDetails(String accountDetails) {
		this.accountDetails=accountDetails;
	}
	
	public static List<AccountInfo> getBalanceList(){
		return BALANCE_LIST;
	}
	
		public static String print() {
			String disp = "";
			for(AccountInfo accountinfo : BALANCE_LIST) {
				disp+= accountinfo.getTotalBalance();
				disp+=";";
	
			}
			return disp;
			
		}
	

}
