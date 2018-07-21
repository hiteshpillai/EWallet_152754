package com.capgemini.eWallet.Exception;

import java.io.ObjectInputStream.GetField;

public class CustomerException extends Exception{

	String message;
	
	public CustomerException(String message){
		this.message = message;
	}
	
	@Override
	public String getMessage(){
		return message;
	}
}
