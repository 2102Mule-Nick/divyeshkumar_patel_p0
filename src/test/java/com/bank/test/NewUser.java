package com.bank.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bank.dao.UserDao;
import com.bank.exception.UserNameTaken;
import com.bank.pojo.User;
import com.bank.service.AuthServiceImpl;

class NewUser {
	
private static User user;
private static AuthServiceImpl service;
	@Test
	public void createUser() throws Exception {
		user = new User("test","test1");	
	
	}

}
