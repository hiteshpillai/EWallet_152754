package com.capgemini.eWallet.DAO;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;

import com.capgemini.eWallet.Exception.EWalletException;
import com.capgemini.eWallet.beans.CustomerAccountClass;

public interface IEWalletCustomerDataDao {

	
	public String addCustomerDetails(CustomerAccountClass customer);
	public String getCustomerID(CustomerAccountClass customer);
	public void writeToFile() throws IOException;
	public CustomerAccountClass getCustomerAccountClass(String customerID) throws EWalletException;
	public void readFromFile();
	public void printFileData();
	public boolean customerAvailable(String customerID);
	public void updateSetFile(String customerID, CustomerAccountClass temp);
	public Integer getAccountNumber(CustomerAccountClass customer);
}
