package com.cg.trg.service;

import java.util.List;


import com.cg.trg.entity.User;
import com.cg.trg.exception.UserException;

public interface UserService {


	/**
	 * Add User
	 * @param user
	 * @return 1 if user added
	 * else
	 * @throws UserException
	 */
	public Integer addUser(User user) throws UserException;
	
	/**
	 * get user by id
	 * @param user_id
	 * @return User
	 * @throws UserException
	 */
	public User getUserByUserName(String userName) throws UserException;
	
	/**
	 * delete user
	 * @param user_id
	 * @return 1 if user deleted
	 * else
	 * @throws UserException
	 */
	public Integer deleteUser(Integer userId) throws UserException;
	
	/**
	 * get all user
	 * @return list of all users
	 * @throws UserException
	 */
	public List<User> getAllUser() throws UserException;
	
	//public User authenticateUser(String user);
	
	public String updatePassword(User user, String new_password);
	
	/**
	 * update user
	 * @param user
	 * @return User
	 * @throws UserException
	 */
	public User updateUser(User user) throws UserException;
	
	
	
	
	
	
	
	
}