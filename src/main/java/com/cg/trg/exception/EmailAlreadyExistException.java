package com.cg.trg.exception;
public class EmailAlreadyExistException extends RuntimeException {
    
        private static final long serialVersionUID = 1L;

 

        public EmailAlreadyExistException(String name) 
        {
            super(name);
        }

 

}