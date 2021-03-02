package com.bank.dao;

import java.util.LinkedList;
import java.util.List;

import com.bank.exception.UserNameTaken;
import com.bank.exception.UserNotFound;
import com.bank.pojo.AccountInfo;

public interface AccountInfoDao {

	public void enterInfo(AccountInfo info) throws UserNotFound;
	public AccountInfo getInfo(String username);
	public void updateInfo(AccountInfo info);
	public void deleteInfo(AccountInfo info);
}
