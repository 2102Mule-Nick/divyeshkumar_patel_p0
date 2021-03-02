package com.bank.ui;

import java.util.Scanner;

import com.bank.exception.UserNameTaken;
import com.bank.pojo.User;
import com.bank.service.AuthService;

public class RegistrationMenu implements Menu {
	private Menu welcomeMenu;

	private Menu nextMenu;

	private Scanner scan;

	private AuthService authService;

	@Override
	public Menu advance() {
		// Will return the menu we need to advance to
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		User user = new User();
		System.out.println("Enter a username: ");
		user.setUsername(scan.nextLine());
		System.out.println("Enter password:");
		user.setPassword(scan.nextLine());
		if (!authService.existingUser(user)) {
			try {
				authService.registerUser(user);
				nextMenu = null;
			} catch (UserNameTaken e) {
				System.out.println("Username taken, please enter different username.");
				nextMenu = welcomeMenu;
			}
		} else {
			System.out.println("Username taken, try again");
			nextMenu = welcomeMenu;
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

	public void setWelcomeMenu(Menu welcomeMenu) {
		// TODO Auto-generated method stub
		this.welcomeMenu = welcomeMenu;
	}

	public RegistrationMenu(AuthService authService, Menu welcomeMenu) {
		super();
		this.authService = authService;
		this.welcomeMenu = welcomeMenu;
	}

	public AuthService getAuthService() {
		return authService;

	}

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	public RegistrationMenu() {
		super();
	}
	public Menu getWelcomeMenu() {
		return welcomeMenu;
	}
	public Menu getNextMenu() {
		return nextMenu;
	}
}
