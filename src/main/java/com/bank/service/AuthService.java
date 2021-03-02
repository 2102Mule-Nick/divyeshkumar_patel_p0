package com.bank.service;

import java.io.FileNotFoundException;

import com.bank.exception.InvalidPassword;
import com.bank.exception.UserNameTaken;
import com.bank.exception.UserNotFound;
import com.bank.pojo.AccountInfo;
import com.bank.pojo.User;

public interface AuthService {

	public boolean existingUser(User user);

	public User authenticateUser(User user) throws InvalidPassword, UserNotFound,FileNotFoundException;

	public User registerUser(User user) throws UserNameTaken;
	
	public AccountInfo depositAmt(AccountInfo amt) throws InvalidPassword;
}
