package com.bank.dao;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.bank.exception.UserNameTaken;
import com.bank.exception.UserNotFound;
import com.bank.pojo.User;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;



public class UserDaoKryo implements UserDao {
	private Kryo kryo = new Kryo();

	private Logger log = Logger.getRootLogger();

	//private static final String FOLDER_NAME = "users\\";

	private static final String FILE_EXTENSION = ".dat";

	@Override
	public void createUser(User user) throws UserNameTaken {
		// Creates a new file with the new user credentials
		log.info("Created a new user");

		try (FileOutputStream outputStream = new FileOutputStream(user.getUsername() + FILE_EXTENSION)) {
			Output output = new Output(outputStream);
			kryo.writeObject(output, user);
			output.close();
		} catch (FileNotFoundException e) {
			log.error("could not open file", e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUserByUsername(String username) throws UserNotFound {
		// returns the details of the user if it exists
		String filename  = username+ FILE_EXTENSION;
		File file= new File(filename);
		if(!file.exists()) {
			return null;
		}
		try (FileInputStream inputStream = new FileInputStream(username + FILE_EXTENSION)) {
			Input input = new Input(inputStream);
			User user = kryo.readObject(input, User.class);
			input.close();
			System.out.println(user);
			return user;

		} catch (FileNotFoundException e) {
			// runs if user is not found
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub

	}

	public UserDaoKryo() {
		super();
		kryo.register(User.class);
	}

}
