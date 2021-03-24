package com.cg.trg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.trg.entity.AuthenticateUser;
import com.cg.trg.exception.BaseResponse;
import com.cg.trg.exception.UserException;
import com.cg.trg.service.AuthenticateUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/authenticate")

@Api(value = "User")

public class AuthenticateUserController {
	
	
	    @Autowired 
	    private AuthenticateUserService authenticateUserService;
	    /**
	     * 
	     * @param user
	     * @return
	     * @throws UserException
	     */
	    @PostMapping("/user") 
	    @ApiOperation(value = "Authentication")
	    public ResponseEntity<?> authenticate( @RequestBody AuthenticateUser user) throws UserException {
	        String str = authenticateUserService.authenticate(user);
	        BaseResponse baseResponse = new BaseResponse();
	        baseResponse.setStatusCode(1);
	        baseResponse.setResponse(str);
	        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	    }

	
}
