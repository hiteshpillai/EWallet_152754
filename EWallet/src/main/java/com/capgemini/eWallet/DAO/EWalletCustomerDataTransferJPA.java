package com.capgemini.eWallet.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.eWallet.Exception.EWalletException;
import com.capgemini.eWallet.beans.CustomerAccountClass;
import com.capgemini.eWallet.util.DBUtil;

public class EWalletCustomerDataTransferJPA implements IEWalletCustomerDataDao{

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = factory.createEntityManager();
	
	
	@Override
	public String addCustomerDetails(CustomerAccountClass customer) {
		em.getTransaction().begin();
		CustomerAccountClass ref = null;
		customer.setCustomerID("hello");
		
		em.persist(customer);
		em.getTransaction().commit();
		em.close();
		factory.close();
		return null;
	}

	@Override
	public String getCustomerID(CustomerAccountClass customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeToFile() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CustomerAccountClass getCustomerAccountClass(String customerID)
			throws EWalletException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void readFromFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printFileData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean customerAvailable(String customerID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateSetFile(String customerID, CustomerAccountClass temp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getAccountNumber(CustomerAccountClass customer) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
