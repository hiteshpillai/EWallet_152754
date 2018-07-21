package com.capgemini.eWallet.Exception;

public class EWalletException extends Exception{

	String message;
	
	public EWalletException(String msg)	{
		message=msg;
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}
	
}
