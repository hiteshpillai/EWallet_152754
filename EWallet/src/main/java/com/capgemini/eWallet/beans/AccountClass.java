package com.capgemini.eWallet.beans;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public interface AccountClass {

	public long amount = 0;
	public int customerID = 0;
	public int dateOfOpening = 0;
	public int monthOfOpening = 0;
	public int yearOfOpening = 0;
	public long accountNumber = 0;
	public String pinCode = null;
	public LinkedHashSet<String> transactions = new LinkedHashSet<String>();
	
	public void setAmount(long amount);
	public void setDateOfOpening(int dateOfOpening);
	public void setMonthOfOpening(int monthOfOpening);
	public void setYearOfOpening(int yearOfOpening);
	public int getDateOfOpening();
	public int getMonthOfOpening();
	public int getYearOfOpening();
	public void setAccountNumber(long accountNumber);
	public void setPinCode(String pinCode);
	public void setTransactions(LinkedHashSet<String> transaction);
	public LinkedHashSet<String> getTransactions();
	
}
