package com.capgemini.eWallet.service;

import java.util.LinkedHashSet;
import java.util.TreeMap;

import com.capgemini.eWallet.Exception.EWalletException;
import com.capgemini.eWallet.beans.CustomerAccountClass;

public interface IEWalletService {

	public boolean validateFirstName(String name);
	public boolean validateMiddleName(String mname);
	public boolean validateLastName(String lname);
	public boolean validateAge(int age);
	public String addCustomerDetails(CustomerAccountClass customer);
	public boolean validateAmount(long amount);
	public boolean validateCity(String city);
	public boolean validateState(String state);
	public boolean validateCountry(String country);
	public boolean validateAreaPinCode(String areaPinCode);
	public boolean validateMobileNumber(String mobileNumber);
	public boolean validateGovtIDNumberLong(String govtIDNumber);
	public boolean validateGovtIDNumberString(String govtIDNumber);
	public boolean validatePinCode(String pinCode);	
	public boolean isEnteredPinCodeIsValid(String pinCode, CustomerAccountClass temp);
	public boolean isAmountValid(long amount, CustomerAccountClass temp);
	public boolean isDepositAmountValid(long amount, CustomerAccountClass temp);
	public CustomerAccountClass isCustomerIDEnteredAvailable(String customerID) throws EWalletException;
	public void readFromFile();
	public void updateSetFile(String customerID, CustomerAccountClass temp);
	public boolean customerAvailable(String customerID);
	public CustomerAccountClass getCustomerDataFromSet(String customerID) throws EWalletException;
	public void printFileData();
	public void writeToFile() throws Exception;
}
