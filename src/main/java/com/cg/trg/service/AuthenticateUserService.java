package com.cg.trg.service;

import com.cg.trg.entity.AuthenticateUser;
import com.cg.trg.exception.UserException;

public interface AuthenticateUserService {

	
	String authenticate(AuthenticateUser user) throws UserException;

}
