package com.capgemini.eWallet.DAO;

import java.util.HashMap;

import com.capgemini.eWallet.beans.CustomerAccountClass;

public interface IEWalletCustomerDataTransferJDBC {

	public CustomerAccountClass addAccount(CustomerAccountClass customer);
	public CustomerAccountClass deleteCustomerData(String customerId);
	public CustomerAccountClass updateCustomerData(String customerId);
	public CustomerAccountClass getCustomerDataById(String customerId);
	public HashMap<String, CustomerAccountClass> getAllCustomer();
}
