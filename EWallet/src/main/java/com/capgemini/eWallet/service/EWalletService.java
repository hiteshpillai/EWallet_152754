package com.capgemini.eWallet.service;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.TreeMap;

import com.capgemini.eWallet.DAO.EWalletCustomerDataTransferDAO;
import com.capgemini.eWallet.DAO.EWalletCustomerDataTransferJPA;
import com.capgemini.eWallet.DAO.IEWalletCustomerDataDao;
import com.capgemini.eWallet.Exception.EWalletException;
import com.capgemini.eWallet.beans.*;
public class EWalletService implements IEWalletService{
	
	static IEWalletCustomerDataDao dao = new EWalletCustomerDataTransferJPA();
	
	String namePattern = "[A-Z]{1}[a-z]{2,}";		//name format pattern
	String namePattern1 = "[.]{1}";
	String mobileNumberPattern = "[0-9]{10}";				//phone no format pattern
	String areaPinCodePattern = "[0-9]{6}";
	String govtIDNumberLongPattern = "[0-9]{12}";
	String govtIDNumberStringPANPattern = "[0-9]{4}[A-Z]{6}";
	String govtIDNumberStringVoterIDCardPattern = "[0-9]{7}[A-Z]{3}";
	String pinCodePattern = "[0-9]{4}";
	
	LinkedHashSet<String> transactions = new LinkedHashSet<String>();
	
	public boolean validateFirstName(String fname){
		boolean isFnameValid = false;
		if(fname.matches(namePattern)){
			isFnameValid = true;
		}
		return isFnameValid;
	}
	
	public boolean validateMiddleName(String mname){
		boolean isMnameValid = false;
		if(mname.matches(namePattern) || mname.matches(namePattern1)){
			isMnameValid = true;
		}
		return isMnameValid;
	}
	
	public boolean validateLastName(String lname){
		boolean isLnameValid = false;
		if(lname.matches(namePattern) || lname.matches(namePattern1)){
			isLnameValid = true;
		}
		return isLnameValid;
	}
	
	public boolean validateAge(int age){
		boolean isAgeValid = false;
		if(age >= 16 && age <= 130){
			isAgeValid = true;
		}
		return isAgeValid;
	}

	public String addCustomerDetails(CustomerAccountClass customer) {
		
		return dao.addCustomerDetails(customer);
	}

	public boolean validateAmount(long amount) {
		if (amount >= 100 && amount <= 50000){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean validateCity(String city) {
		if(city.matches(namePattern))return true;
		return false;
	}

	public boolean validateState(String state) {
		if(state.matches(namePattern))return true;
		return false;
	}

	public boolean validateCountry(String country) {
		if(country.matches(namePattern))return true;
		return false;
	}
	
	public boolean validateAreaPinCode(String areaPinCode) {
		if(areaPinCode.matches(areaPinCodePattern))return true;
		return false;
	}

	public boolean validateMobileNumber(String mobileNumber) {
		if(mobileNumber.matches(mobileNumberPattern))return true;
		return false;
	}

	public boolean validateGovtIDNumberLong(String govtIDNumber) {
		if(govtIDNumber.matches(govtIDNumberLongPattern))return true;
		return false;
	}
	
	public boolean validateGovtIDNumberString(String govtIDNumber) {
		if(govtIDNumber.matches(govtIDNumberStringPANPattern) || govtIDNumber.matches(govtIDNumberStringVoterIDCardPattern))return true;
		return false;
	}

	public boolean validatePinCode(String pinCode) {
		if (pinCode.matches(pinCodePattern))return true;
		return false;
	}
	
	public boolean isEnteredPinCodeIsValid(String pinCode, CustomerAccountClass temp){
		if(pinCode.equals(temp.getPinCode()))return true;
		return false;
	}

	public boolean isAmountValid(long amount, CustomerAccountClass temp) {
		if((temp.getAmount()-amount) >= 1000)return true;
		return false;
	}
	
	public boolean isDepositAmountValid(long amount, CustomerAccountClass temp) {
		if(amount <= 50000)return true;
		return false;
	}
	
	public CustomerAccountClass isCustomerIDEnteredAvailable(String customerID) throws EWalletException{
		CustomerAccountClass customer = new CustomerAccountClass();
		customer = dao.getCustomerAccountClass(customerID);
		return customer;
	}

	public void writeToFile() throws Exception {
		dao.writeToFile();
	}

	public void printFileData() {
		dao.printFileData();
		return;
		
	}

	public CustomerAccountClass getCustomerDataFromSet(String customerID) throws EWalletException {
		return dao.getCustomerAccountClass(customerID);
	}

	public boolean customerAvailable(String customerID) {
		if(dao.customerAvailable(customerID))return true;
		return false;
	}

	public void updateSetFile(String customerID, CustomerAccountClass temp) {
		dao.updateSetFile(customerID, temp);
		return;
		
	}

	public void readFromFile() {
		dao.readFromFile();
		
	}
	
	
}
