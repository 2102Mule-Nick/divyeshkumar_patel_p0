package com.bank.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.bank.pojo.AccountInfo;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.minlog.Log;

public class AccountInfoKryo implements AccountInfoDao {
	private Kryo kryo = new Kryo();
	private Logger log = Logger.getRootLogger();
	private static final String FILE_EXTENSION = ".txt";

	public AccountInfoKryo() {
		// TODO Auto-generated constructor stub
		super();
		kryo.register(AccountInfo.class);
	}

	@Override
	public void enterInfo(AccountInfo info) {
		// Creates file with the account info
		Log.info("Records added");
		
		try (FileOutputStream outputStream = new FileOutputStream(info.getUsername() + FILE_EXTENSION)) {
			Output output = new Output(outputStream);
			kryo.writeObject(output, info);
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.error("Unable to open File",e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public AccountInfo getInfo(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInfo(AccountInfo info) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteInfo(AccountInfo info) {
		// TODO Auto-generated method stub

	}
	

}
