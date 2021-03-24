package com.cg.trg.serviceImpl;



import static com.cg.trg.exception.AppConstants.Email_Exist;
import static com.cg.trg.exception.AppConstants.OPERATION_FAILED;
import static com.cg.trg.exception.AppConstants.USER_NOT_FOUND;
import static com.cg.trg.exception.AppConstants.WRONG_PASSWORD;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cg.trg.dao.UserDAO;
import com.cg.trg.entity.User;
import com.cg.trg.exception.EmailAlreadyExistException;
import com.cg.trg.exception.OperationFailedException;
import com.cg.trg.exception.ResourceNotFound;
import com.cg.trg.exception.UserException;
import com.cg.trg.exception.UserNameException;
import com.cg.trg.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserDAO userDaoImpl;

	@Override
	public Integer addUser(User user) throws UserException {
		try {

			Optional<User> userEx=userDaoImpl.findByEmailId(user.getUserEmail());
			if(!userEx.isPresent())
			{
				userDaoImpl.save(user);
				return 1;
			}
			else
			{
				throw new EmailAlreadyExistException(Email_Exist);
			}


		}catch(DataAccessException dataAccessException) {
			throw new UserException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new UserException(exception.getMessage(),exception);
		}
	}
	
	@Override
	public User getUserByUserName(String userName) throws UserException {
		try {
			Optional<User> optional= 
					userDaoImpl.findByUserName(userName);
			if(optional.isPresent()) {
				System.out.println(optional.get());
				return optional.get();
			}else {
				return null;
			}			
		}catch(DataAccessException dataAccessException) {
			throw new UserException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new UserException(exception.getMessage(),exception);
		}
	}
	
	@Override
	public Integer deleteUser(Integer userId) throws UserException {
		try {
			userDaoImpl.deleteById(userId);
			return 1;
		}catch(DataAccessException dataAccessException) {
			throw new UserException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new UserException(exception.getMessage(),exception);
		}
	}
	
	
	@Override
	public String updatePassword(User user, String new_password) {
		String str = null;
		Optional<User> userObj = userDaoImpl.findByEmailId(user.getUserEmail());
		if (!userObj.isPresent()) {
			throw new ResourceNotFound(USER_NOT_FOUND);
		} else {
			String pwd = userObj.get().getUserPassword();
			if (!pwd.equals(user.getUserPassword())) {
				throw new ResourceNotFound(WRONG_PASSWORD);
			}
			try {
				userObj.get().setUserPassword(new_password);
				userDaoImpl.saveAndFlush(userObj.get());
				str = "Password changed sucessfully";
			} catch (Exception e) {
				throw new OperationFailedException(OPERATION_FAILED);
			}
		}
		return str;
	}
	
	@Override
	public List<User> getAllUser() throws UserException {
		try {
			List<User> userList=
					userDaoImpl.findAll();
			return userList;
		}catch(DataAccessException dataAccessException) {
			throw new UserException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new UserException(exception.getMessage(),exception);
		}
	}
	
	@Override
	public User updateUser(User user) throws UserException {
		try {
			User u= 
					userDaoImpl.save(user);
			return u;
		}catch(DataAccessException dataAccessException) {
			throw new UserException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new UserException(exception.getMessage(),exception);
		}
	}
	
	
	
	

}
