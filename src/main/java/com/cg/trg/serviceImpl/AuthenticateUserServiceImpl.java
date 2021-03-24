package com.cg.trg.serviceImpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.trg.dao.AuthenticateUserDAO;
import com.cg.trg.entity.AuthenticateUser;
import com.cg.trg.entity.User;
import com.cg.trg.exception.OperationFailedException;
import com.cg.trg.exception.ResourceNotFound;
import com.cg.trg.exception.UserException;
import com.cg.trg.service.AuthenticateUserService;

import static com.cg.trg.exception.AppConstants.OPERATION_FAILED;
import static com.cg.trg.exception.AppConstants.USER_NOT_FOUND;
import static com.cg.trg.exception.AppConstants.WRONG_PASSWORD;

@Service
public class AuthenticateUserServiceImpl implements AuthenticateUserService{
@Autowired 
 private AuthenticateUserDAO authenticateUserDAO;
	@Override
	public String authenticate(AuthenticateUser user) throws UserException {
		String str=null;
		Optional<User> userObj=authenticateUserDAO.findByEmailId(user.getEmail());
		if (!userObj.isPresent()) {
			System.out.println(userObj);
			throw new ResourceNotFound(USER_NOT_FOUND);
		} else {
			String pwd = userObj.get().getUserPassword();
			if (!pwd.equals(user.getPassword())) {
				throw new ResourceNotFound(WRONG_PASSWORD);
			}
			try {
				str = "Authentication sucessfull";
				authenticateUserDAO.saveAndFlush(userObj.get());
			} catch (Exception e) {
				throw new OperationFailedException(OPERATION_FAILED);
			}
		}
		return str;
	}

}
