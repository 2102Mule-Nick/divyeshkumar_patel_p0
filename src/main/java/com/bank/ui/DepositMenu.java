package com.bank.ui;

import java.util.Scanner;

import com.bank.exception.InvalidPassword;
import com.bank.exception.UserNotFound;
import com.bank.pojo.AccountInfo;
import com.bank.pojo.User;
import com.bank.service.AuthService;

public class DepositMenu implements Menu{
	private Menu welcomeMenu;

	private Menu nextMenu;

	private Scanner scan;

	private AuthService authService;
	public DepositMenu() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		// TODO Auto-generated method stub
		AccountInfo acct = new AccountInfo();
		System.out.println("Enter the amount you want to deposit:");
		
		int depositAmount = scan.nextInt();
		
		
		acct.setTotalBalance(depositAmount);
		System.out.println("Enter remarks:");
		acct.setTransactionRemarks(scan.nextLine());
		try {
			authService.depositAmt(acct);
			nextMenu=null;
		}catch(Exception e) {
			
		}
		
	}

	@Override
	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scanner getScanner() {
		// TODO Auto-generated method stub
		return this.scan;
	}

	@Override
	public void setScanner(Scanner scan) {
		// TODO Auto-generated method stub
		this.scan=scan;
	}

}
