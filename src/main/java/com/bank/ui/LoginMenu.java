package com.bank.ui;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.bank.service.AuthService;
import com.bank.exception.InvalidPassword;
import com.bank.exception.UserNotFound;
import com.bank.pojo.User;

public class LoginMenu implements Menu {

	private AuthService authService;
	private Scanner scan;
	private Menu nextMenu;

	Menu depositMenu = new DepositMenu();

	public AuthService getuserService() {
		return authService;
	}

	public void setuserService(AuthService userService) {
		this.authService = userService;
	}

	public LoginMenu(AuthService authService) {
		super();
		this.authService = authService;

	}

	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		System.out.println("Please enter your username:");
		String username = scan.nextLine();
		System.out.println("Please enter your password:");
		String password = scan.nextLine();

		User user = new User(username, password);

		try {
			authService.authenticateUser(user);
			System.out.println("You have logged in successfully");
			System.out.println("================================");
			System.out.println("1. View balance");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdraw amount");
			System.out.println("4. Log out");

			String sel = scan.nextLine();
			if ("2".equals(sel)) {
				depositMenu.displayOptions();
			}

		} catch (FileNotFoundException e) {
System.out.println("User not found");
		} catch (UserNotFound e) {
			System.out.println("Username doesn't exist. Please register");
		} catch (InvalidPassword e) {
			System.out.println("Your credentials didn't match our database. Please enter correct credentials");
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

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
		this.scan = scan;

	}

	public LoginMenu(Menu depositMenu) {
		super();
		this.depositMenu = depositMenu;

	}

}
