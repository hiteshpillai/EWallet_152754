package com.capgemini.eWallet.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.eWallet.Exception.EWalletException;
import com.capgemini.eWallet.beans.CustomerAccountClass;
import com.capgemini.eWallet.util.DBUtil;

public class EWalletCustomerDataTransferJPA implements IEWalletCustomerDataDao{

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = factory.createEntityManager();
	static HashMap<String, CustomerAccountClass> set = new HashMap();
	
	int max = 99999;
	int min = 10000;
	int range = max - min + 1;
	int maxAcc = 99999999;
	int minAcc = 10000000;
	int rangeAcc = maxAcc - minAcc +1;
	
	@Override
	public String addCustomerDetails(CustomerAccountClass customer) {
		em.getTransaction().begin();
		CustomerAccountClass ref = null;
		customer.setCustomerID(getCustomerID(customer));
		customer.setAccountNumber(getAccountNumber(customer));
		em.merge(customer);
		em.getTransaction().commit();
		return customer.getCustomerID();
		
	}

	@Override
	public String getCustomerID(CustomerAccountClass customer) {
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
	public void writeToFile() throws IOException {
		em.getTransaction().commit();
		em.close();
		factory.close();
		
	}

	@Override
	public CustomerAccountClass getCustomerAccountClass(String customerId)
			throws EWalletException {
		//CustomerAccountClass customer = em.find(CustomerAccountClass.class, customerID);
		Query qry = em.createQuery("SELECT c FROM CustomerAccountClass c WHERE c.customerID =:customerId1", CustomerAccountClass.class);
		qry.setParameter("customerId1", customerId);
		
		CustomerAccountClass customer = (CustomerAccountClass) qry.getSingleResult();
		if(customer == null) {
			throw new EWalletException("There is no account linked to this customer");
		}
		return customer;
	}

	@Override
	public void readFromFile() {
		List customerList = new ArrayList();
		Query qry = em.createQuery("SELECT c FROM CustomerAccountClass c", CustomerAccountClass.class);
		customerList = qry.getResultList();
		Iterator itr = customerList.iterator();
		CustomerAccountClass ref = new CustomerAccountClass();
		while(itr.hasNext()) {
			ref = (CustomerAccountClass) itr.next();
			set.put(ref.getCustomerID(), ref);
		}
	}

	@Override
	public void printFileData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean customerAvailable(String customerID) {
		em.getTransaction().begin();
		CustomerAccountClass temp = em.find(CustomerAccountClass.class, customerID);
		if(temp !=  null)return true;
		return false;
	}

	@Override
	public void updateSetFile(String customerID, CustomerAccountClass temp) {
		em.getTransaction().begin();
		em.merge(temp);
		em.getTransaction().commit();
	}

	@Override
	public Integer getAccountNumber(CustomerAccountClass customer) {
		Integer accNo = (int)(Math.random() * rangeAcc) + minAcc;
		return accNo;
	}
	
}
