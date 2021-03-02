package com.bank.ui;

import java.util.Scanner;

public class WelcomeMenu implements Menu {

	private Scanner scan;
	private Menu loginMenu;
	private Menu registrationMenu;
	private Menu nextMenu;
	private Menu depositMenu;

	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to our Bank");
		System.out.println("1. Register for an account ");
		System.out.println("2. Log in to your account");
		String answer = scan.nextLine();

		if ("login".equals(answer)) {
			nextMenu = loginMenu;
		} else if ("register".equals(answer)) {
			nextMenu = registrationMenu;
		} else {
			System.out.println("invalid input");
			//redirect user to same welcome menu
			nextMenu = this;
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

	public WelcomeMenu() {
		super();
	}

	public WelcomeMenu(Menu loginMenu, Menu registrationMenu, Menu depositMenu) {
		super();
		this.loginMenu = loginMenu;
		this.registrationMenu = registrationMenu;
		this.depositMenu= depositMenu;
	}

}
