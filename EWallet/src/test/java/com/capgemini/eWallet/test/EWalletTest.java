package com.capgemini.eWallet.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.eWallet.DAO.EWalletCustomerDataTransferDAO;
import com.capgemini.eWallet.Exception.CustomerException;
import com.capgemini.eWallet.beans.CustomerAccountClass;
import com.capgemini.eWallet.beans.CustomerClass;

public class EWalletTest 
{
	static CustomerAccountClass temp;
	static EWalletCustomerDataTransferDAO dao = new EWalletCustomerDataTransferDAO();
	
	/*The Following Code will be executed before the Test Class is Loaded.*/
	/*@BeforeClass
	public static void BeforeClass(){
	temp = new CustomerAccountClass("Hitesh", "V", "Pillai");
	}*/
	
	/*The Following TEst Case is looking for any errors in the getNAme() function of the CustomerClass.*/
    @Test
    public void testingFirstName(){
    	System.out.println("Testing First Name..");
    	assertEquals("Hitesh", temp.getFirstName());
    }
    
    /*The following test case is testing the output of getLastName() of the Class Customer*/
    @Test
    public void testingLastName(){
    	System.out.println("Testing Last Name..");
    	assertEquals("Pillai", temp.getLastName());
    }
    
    /*The following test case is testing the output of getMiddleName() of the Class Customer*/
    @Test
    public void testingMiddleName(){
    	System.out.println("Testing Middle Name..");
    	assertEquals("V", temp.getMiddleName());
    }
    
    /*The Following test case checks the validations methods of the Service class on the First Name.*/
/*    @Test(expected = CustomerException.class)
    public void validateFirstName(){
    	System.out.println("Testing the Validations for the First Name..");
    	temp.validateFirstName();
    }*/
    
    @Test
    public void testingReadFromFile(){
    	System.out.println("Testing read from file method.");
    	dao.readFromFile();
    }
}
