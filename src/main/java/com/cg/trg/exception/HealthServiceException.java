package com.cg.trg.exception;

	/**
	 * This class is used to handle exception
	 */
	import org.springframework.http.HttpStatus;
	import org.springframework.web.bind.annotation.ResponseStatus;

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public class  HealthServiceException extends Exception{
		
	
		private static final long serialVersionUID = 1L;

		public HealthServiceException() {
			super();
		}
		
		public HealthServiceException(String message) {
			super(message);
		}
		@Override
		public String toString() {
			return "HealthServiceException:" + super.getMessage();
		}

	}