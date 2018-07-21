package com.capgemini.eWallet.DAO;

import com.capgemini.eWallet.Exception.EWalletException;
import com.capgemini.eWallet.beans.CustomerAccountClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Math;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class EWalletCustomerDataTransferDAO implements IEWalletCustomerDataDao{
	
	int max = 99999;
	int min = 10000;
	int range = max - min + 1;
	int maxAcc = 99999999;
	int minAcc = 10000000;
	int rangeAcc = maxAcc - minAcc +1;
	@SuppressWarnings("rawtypes")
	static HashMap<String, CustomerAccountClass> set = new HashMap();
	LinkedHashSet<String> transactions = new LinkedHashSet<String>();
	
	@Override
	public String addCustomerDetails(CustomerAccountClass customer){
		String customerID = getCustomerID(customer);
		customer.setCustomerID(customerID);
		Integer accountNumber = getAccountNumber(customer);
		customer.setAccountNumber(accountNumber);
		set.put(customerID, customer);
		/*System.out.println();
		System.out.println(set);
		System.out.println();*/
		return customerID;
	}
	
	@Override
	public String getCustomerID(CustomerAccountClass customer){
		Integer customerID = (int)(Math.random() * range) + min;
		String customerIDString = customerID.toString();
		StringBuffer customerIDStringBuffer = new StringBuffer();
		customerIDStringBuffer.append(customer.getCountry().substring(0,2).toUpperCase());
		customerIDStringBuffer.append(customer.getState().substring(0,2).toUpperCase());
		customerIDStringBuffer.append(customer.getCity().substring(0,2).toUpperCase());
		customerIDStringBuffer.append(customerID.toString());
		customerIDString = customerIDStringBuffer.toString();
		return customerIDString;
	}
	
	@Override
	public Integer getAccountNumber(CustomerAccountClass customer){
		Integer accNo = (int)(Math.random() * rangeAcc) + minAcc;
		return accNo;
	}

	@Override
	public void writeToFile() throws IOException {
		File file = new File("CustomerDetials.txt");
		if(file.delete()){System.out.println("File deleted");}
		FileOutputStream fos =
				new FileOutputStream("CustomerDetials.txt");
		ObjectOutputStream oos
		= new ObjectOutputStream(fos);
		
		oos.writeObject(set);
		System.out.println("File Re-Written");
		oos.close();
	}
	
	@Override
	public void readFromFile(){
		try{
		FileInputStream fis = new FileInputStream("CustomerDetials.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		HashMap temp = new HashMap();
		
			
			temp = (HashMap<?, ?>) ois.readObject();ois.close();
			
			set.putAll(temp);
		ois.close();
		//System.out.println(customerDetailsMap);
		return;
		}
		catch(Exception e){
			System.out.println("Error reading from the file.. new database will be created..\n\n");
		}
		return;
	}
	
	@Override
	public CustomerAccountClass getCustomerAccountClass(String customerID) throws EWalletException{
		CustomerAccountClass customer = new CustomerAccountClass();
		if (set.containsKey(customerID)){
			customer = (CustomerAccountClass) set
					.get(customerID);
			set.remove(customerID);
		}
		else{
			throw new EWalletException("There is no account linked to this customer ID..");
		}
		return customer;
	}

	@Override
	public void printFileData() {
		System.out.println(set);
		return;
		
	}
	@Override
	public boolean customerAvailable(String customerID) {
		if(set.containsKey(customerID))return true;
		return false;
	}

	@Override
	public void updateSetFile(String customerID, CustomerAccountClass temp) {
		if(set.containsKey(customerID)){
			set.remove(customerID);
		}
		set.put(customerID, temp);
		return;
	}
}
