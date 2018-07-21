package com.capgemini.eWallet.Exception;

public class DatabaseException {

String message;
	
	public DatabaseException(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return message;
	}
	
}
