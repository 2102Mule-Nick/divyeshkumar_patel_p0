package com.bank.service;

import java.io.FileNotFoundException;

import com.bank.dao.AccountInfoDao;
import com.bank.dao.UserDao;
import com.bank.exception.InvalidPassword;
import com.bank.exception.UserNameTaken;
import com.bank.exception.UserNotFound;
import com.bank.pojo.AccountInfo;
import com.bank.pojo.User;

public class AuthServiceImpl implements AuthService {
	private UserDao userDao;
	private AccountInfoDao accountinfoDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean existingUser(User user) {
		// TODO Auto-generated method stub
		try {
			if (userDao.getUserByUsername(user.getUsername()) != null) {
				return true;
			}
		} catch (UserNotFound e) {
			return false;
		} catch (FileNotFoundException e) {
			return false;
		}
		return false;
	}

	@Override
	public User authenticateUser(User user) throws InvalidPassword, UserNotFound, FileNotFoundException {
		// TODO Auto-generated method stub

		User existingUser = userDao.getUserByUsername(user.getUsername());
		if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
			return existingUser;

		}
		throw new InvalidPassword();
	}

	@Override
	public User registerUser(User user) throws UserNameTaken {
		// TODO Auto-generated method stub
		userDao.createUser(user);
		return user;
	}

	public AuthServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;

		// TODO Auto-generated constructor stub
	}

	// @Override
	//public AccountInfo depositAmt(AccountInfo info) throws InvalidPassword, UserNotFound {
		// TODO Auto-generated method stub
		//accountinfoDao.enterInfo(info);
	//	return info;

//	}

	//public AuthServiceImpl(AccountInfoDao info) {
	//	super();
	//	this.accountinfoDao = info;
	//}

}
