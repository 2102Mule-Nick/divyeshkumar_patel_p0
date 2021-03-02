package com.bank.ui;

import java.util.Scanner;

import com.bank.exception.InvalidPassword;
import com.bank.exception.UserNotFound;
import com.bank.pojo.AccountInfo;
import com.bank.pojo.User;
import com.bank.service.AuthService;
import com.bank.service.DepositService;

public class DepositMenu implements Menu {

	private Menu welcomeMenu;
	private Menu nextMenu;
	private Scanner scan;
	private AuthService authService;
	private DepositService depositService;
	private Menu loginMenu;

	public DepositMenu() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return nextMenu;
	}

	@Override
	public void displayOptions() {

		AccountInfo info = new AccountInfo();

		System.out.println("Enter the amount you want to deposit:");
		int depositAmount = scan.nextInt();
		info.setTotalBalance(depositAmount);

		System.out.println("Enter remarks:");
		String str = scan.nextLine();
		info.setTransactionRemarks(str);

		System.out.println("Confirm username");
		String uname = scan.nextLine();
		info.setUsername(uname);
		try {
			depositService.depositAmt(info);
			nextMenu = loginMenu;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public DepositService getDepositService() {
		return depositService;
	}

	public void setDepositService(DepositService depositService) {
		this.depositService = depositService;
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
		this.scan = scan;
	}

	public Menu getWelcomeMenu() {
		return welcomeMenu;
	}

	public void setWelcomeMenu(Menu welcomeMenu) {
		this.welcomeMenu = welcomeMenu;
	}

	public Menu getNextMenu() {
		return nextMenu;
	}

	public Menu getLoginMenu() {
		return loginMenu;
	}
	public DepositMenu(DepositService depositService, Menu welcomeMenu) {
		super();
		this.depositService = depositService;
		this.welcomeMenu = welcomeMenu;
	}
}
