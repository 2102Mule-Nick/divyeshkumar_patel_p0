package com.bank.service;

import com.bank.dao.AccountInfoDao;
import com.bank.exception.InvalidPassword;
import com.bank.exception.UserNotFound;
import com.bank.pojo.AccountInfo;

public class DepositServiceImpl implements DepositService {
	private AccountInfoDao accountInfoDao;

	public AccountInfoDao getAccountInfoDao() {
		return accountInfoDao;
	}

	public void setAccountInfoDao(AccountInfoDao accountInfoDao) {
		this.accountInfoDao = accountInfoDao;
	}

	public DepositServiceImpl(AccountInfoDao info) {
		super();
		this.accountInfoDao = info;
	}

	@Override
	public AccountInfo depositAmt(AccountInfo info) throws InvalidPassword, UserNotFound {
		// TODO Auto-generated method stub

		accountInfoDao.enterInfo(info);
		return info;

	}

}
