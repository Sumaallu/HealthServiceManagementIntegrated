package com.cg.trg.exception;
/**
 * This class is used to handle exception
 * @author kethu_greeshma
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HSMException extends RuntimeException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HSMException() {
		super();
	}
	
	public HSMException(String errMsg) {
		super(errMsg);
	}
}
