package com.capgemini.eWallet.beans;

public interface CustomerClass {
	
	public String FirstName = null;
	public String MiddleName = null;
	public String LastName = null;
	public int age = 0;
	public String customerID = null;
	public String city = null;
	public String country = null;
	public String areaPinCode = null;
	public String state = null;
	public String gender = null;
	public String addressLine = null;
	public String govtIDNumber = null;
	public int govtIDProof = 0;
	public String mobileNumber = null;
		
	public int getAge();
	
	public void setAge(int age);
	public String getFirstName();
	public void setFirstName(String firstName);
	public String getMiddleName();
	public void setMiddleName(String middleName);
	public String getLastName();
	public void setLastName(String lastName);
	public String getCity();
	public void setCity(String city);
	public String getCountry();
	public void setCountry(String country);
	public String getAreaPinCode();
	public void setAreaPinCode(String pinCode);
	public String getState();
	public void setState(String state);
	public String getGender();
	public void setGender(String gender);
	public String getAddressLine();
	public void setAddressLine(String addressLine);
	public String getGovtIDNumber();
	public void setGovtIDNumber(String govtIDNumber);
	public String getGovtIDProof();
	public void setGovtIDProof(String govtIDProof);
	public String getMobileNumber();
	public void setMobileNumber(String mobileNumber);
	public String getCustomerID();
	public void setCustomerID(String customerID);
}
