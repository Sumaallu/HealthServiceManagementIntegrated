package com.cg.trg.exception;

public class UserNameExceptionResponse 
{
  private String userName;

public UserNameExceptionResponse(String userName) {
	super();
	this.userName = userName;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}
  
}
