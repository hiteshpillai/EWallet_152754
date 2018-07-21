package com.capgemini.eWallet.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_Account")
public class CustomerAccountClass implements CustomerClass, AccountClass, Serializable{

	
	private String FirstName = null;
	private String MiddleName = null;
	private String LastName = null;
	private int age = 0;
	
	@Id
	private String customerID = null;
	private String city = null;
	private String country = null;
	private String areaPinCode = null;
	private String state = null;
	private String gender = null;
	private String addressLine = null;
	private String govtIDNumber = null;
	private String govtIDProof = null;
	private String mobileNumber = null;

	private long amount = 0;
	//private String customerID = null;
	private int dateOfOpening = 0;
	private int monthOfOpening = 0;
	private int yearOfOpening = 0;
	private long accountNumber = 0;
	private String pinCode = null;
	
	private LinkedHashSet<String> transactions = new LinkedHashSet<String>();
	
	@Override
	public void setAmount(long amount) {
		// TODO Auto-generated method stub
		this.amount = amount;
	}

	public long getAmount() {
		return amount;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	@Override
	public void setCustomerID(String customerID) {
		// TODO Auto-generated method stub
		this.customerID = customerID;
	}
	
	@Override
	public String getCustomerID(){
		return this.customerID;
	}

	@Override
	public void setDateOfOpening(int dateOfOpening) {
		// TODO Auto-generated method stub
		this.dateOfOpening = dateOfOpening;
	}

	@Override
	public void setMonthOfOpening(int monthOfOpening) {
		// TODO Auto-generated method stub
		this.monthOfOpening = monthOfOpening;
	}

	@Override
	public void setYearOfOpening(int yearOfOpening) {
		// TODO Auto-generated method stub
		this.yearOfOpening = yearOfOpening;
	}

	@Override
	public void setAccountNumber(long accountNumber) {
		// TODO Auto-generated method stub
		this.accountNumber = accountNumber;
	}

	

	@Override
	public void setPinCode(String pinCode) {
		// TODO Auto-generated method stub
		this.pinCode = pinCode;
	}
	
	public String getPinCode() {
		// TODO Auto-generated method stub
		return this.pinCode;
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return this.age;
	}

	@Override
	public void setAge(int age) {
		// TODO Auto-generated method stub
		this.age = age;
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return this.FirstName;
	}

	@Override
	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		this.FirstName = firstName;
	}

	@Override
	public String getMiddleName() {
		// TODO Auto-generated method stub
		return this.MiddleName;
	}

	@Override
	public void setMiddleName(String middleName) {
		// TODO Auto-generated method stub
		this.MiddleName = middleName;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return this.LastName;
	}

	@Override
	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		this.LastName = lastName;
	}

	@Override
	public String getCity() {
		// TODO Auto-generated method stub
		return this.city;
	}

	@Override
	public void setCity(String city) {
		// TODO Auto-generated method stub
		this.city = city;
	}

	@Override
	public String getCountry() {
		// TODO Auto-generated method stub
		return this.country;
	}

	@Override
	public void setCountry(String country) {
		// TODO Auto-generated method stub
		this.country = country;
	}

	@Override
	public String getAreaPinCode() {
		// TODO Auto-generated method stub
		return this.areaPinCode;
	}

	@Override
	public void setAreaPinCode(String pinCode) {
		// TODO Auto-generated method stub
		this.areaPinCode = pinCode;
	}

	@Override
	public String getState() {
		// TODO Auto-generated method stub
		return this.state;
	}

	@Override
	public void setState(String state) {
		// TODO Auto-generated method stub
		this.state = state;
	}

	@Override
	public String getGender() {
		// TODO Auto-generated method stub
		return this.gender;
	}

	@Override
	public void setGender(String gender) {
		// TODO Auto-generated method stub
		this.gender = gender;
	}

	@Override
	public String getAddressLine() {
		// TODO Auto-generated method stub
		return this.addressLine;
	}

	@Override
	public void setAddressLine(String addressLine) {
		// TODO Auto-generated method stub
		this.addressLine = addressLine;
	}

	@Override
	public String getGovtIDNumber() {
		// TODO Auto-generated method stub
		return this.govtIDNumber;
	}

	@Override
	public void setGovtIDNumber(String govtIDNumber) {
		// TODO Auto-generated method stub
		this.govtIDNumber = govtIDNumber;
	}

	@Override
	public String getGovtIDProof() {
		// TODO Auto-generated method stub
		return this.govtIDProof;
	}

	@Override
	public void setGovtIDProof(String govtIDProof) {
		// TODO Auto-generated method stub
		this.govtIDProof = govtIDProof;
	}

	@Override
	public String getMobileNumber() {
		// TODO Auto-generated method stub
		return this.mobileNumber;
	}

	@Override
	public void setMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "FirstName=" + FirstName + ", \nMiddleName="
				+ MiddleName + ", \nLastName=" + LastName + ", \nage=" + age
				+ ", \ncustomerID=" + customerID + ", \ncity=" + city
				+ ", \ncountry=" + country + ", \nareaPinCode=" + areaPinCode
				+ ", \nstate=" + state + ", \ngender=" + gender + ", \naddressLine="
				+ addressLine + ", \ngovtIDNumber=" + govtIDNumber
				+ ", \ngovtIDProof=" + govtIDProof + ", \nmobileNumber="
				+ mobileNumber + ", \namount=" + amount + ", \ndateOfOpening="
				+ dateOfOpening + ", \nmonthOfOpening=" + monthOfOpening
				+ ", \nyearOfOpening=" + yearOfOpening + ", \naccountNumber="
				+ accountNumber + ", \npinCode=" + pinCode;
	}
	
	public void toStringHelpDesk() {
		 System.out.println("\nFirstName=" + FirstName + ", \nMiddleName="
				+ MiddleName + ", \nLastName=" + LastName + ", \nage=" + age
				+ ", \ncustomerID=" + customerID + ", \ncity=" + city
				+ ", \ncountry=" + country + ", \nareaPinCode=" + areaPinCode
				+ ", \nstate=" + state + ", \ngender=" + gender + ", \naddressLine="
				+ addressLine + ", \ngovtIDNumber=" + govtIDNumber
				+ ", \ngovtIDProof=" + govtIDProof + ", \nmobileNumber="
				+ mobileNumber +  ", \ndateOfOpening="
				+ dateOfOpening + ", \nmonthOfOpening=" + monthOfOpening
				+ ", \nyearOfOpening=" + yearOfOpening + ", \naccountNumber="
				+ accountNumber);
	}

	@Override
	public int getDateOfOpening() {
		// TODO Auto-generated method stub
		return dateOfOpening;
	}

	@Override
	public int getMonthOfOpening() {
		// TODO Auto-generated method stub
		return monthOfOpening;
	}

	@Override
	public int getYearOfOpening() {
		// TODO Auto-generated method stub
		return yearOfOpening;
	}

	@Override
	public void setTransactions(LinkedHashSet<String> transactions) {
		this.transactions = transactions;
	}	

	@Override
	public LinkedHashSet<String> getTransactions() {
		return transactions;
	}
}
