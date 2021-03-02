package com.bank;

import java.util.Scanner;

import com.bank.dao.UserDao;
import com.bank.dao.UserDaoKryo;
import com.bank.service.AuthService;
import com.bank.service.AuthServiceImpl;
import com.bank.ui.DepositMenu;
import com.bank.ui.LoginMenu;
import com.bank.ui.Menu;
import com.bank.ui.RegistrationMenu;
import com.bank.ui.WelcomeMenu;

public class MainPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		UserDao userDao = new UserDaoKryo();

		AuthService authService = new AuthServiceImpl(userDao);

		Menu register = new RegistrationMenu();

		Menu login = new LoginMenu(authService);

		Menu welcomeMenu = new WelcomeMenu(login, register);
		Menu deposit = new DepositMenu();

		((RegistrationMenu) register).setWelcomeMenu(welcomeMenu);

		((RegistrationMenu) register).setAuthService(authService);

		login.setScanner(scan);
		register.setScanner(scan);
		deposit.setScanner(scan);

		welcomeMenu.setScanner(scan);

		Menu nextMenu = welcomeMenu;

		do {
			nextMenu.displayOptions();

			nextMenu = nextMenu.advance();

		} while (nextMenu != null);
	}

}
