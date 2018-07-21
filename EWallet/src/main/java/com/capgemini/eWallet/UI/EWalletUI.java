package com.capgemini.eWallet.UI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

import com.capgemini.eWallet.DAO.EWalletCustomerDataTransferDAO;
import com.capgemini.eWallet.Exception.EWalletException;
import com.capgemini.eWallet.beans.CustomerAccountClass;
import com.capgemini.eWallet.service.EWalletService;

public class EWalletUI {
/*==============================================================================MAIN START================================================================================*/
	@SuppressWarnings("resource")
	static
	EWalletService service = new EWalletService();
	public static void main(String[] args) throws Exception {
		
		service.readFromFile();

		System.out.println("************Welcome to the E-Wallet************\n\n");
		
		GregorianCalendar calender = new GregorianCalendar();
		
		int date = calender.get(Calendar.DAY_OF_MONTH);
		int month= calender.get(Calendar.MONTH);
		int year = calender.get(Calendar.YEAR);
		
		int choice = 0;
		
		again:
		do{
			
			try{
				Scanner scan = new Scanner(System.in);
				System.out.println("******MENU**************" +(month+1)+ "/" +date+ "/" +year+ "*******");
				System.out.println("1. Banking\n2. Administrator Use\n3. Help Desk\n\n9. Exit the application\n");
				System.out.print("Select from the above Options. Enter your Choice : ");
				choice = scan.nextInt();
				System.out.println("\n\n\n\n");
			}
			
			catch(InputMismatchException e){
				System.out.println("\n\nYou have entered a non integer value.\n Please retry......\n\n\n\n====================================================\n\n");
				choice = 0;
				continue again;
			}
			
			switch (choice){
			case 1:{
				Banking();
				break;
			}
			
			case 2:{
				AdminUse();
				break;
			}
			
			case 3:{
				HelpDesk();
				break;
			}
			
			case 9:{
				break;
			}
			
			default:{
				System.out.println("You have entered an incorrect option.....");
				System.out.println();
				System.out.println("Please retry...");
				System.out.println("\n\n========================================================================\n\n");
				break;
			}
			
			}
			
		}while(choice != 9);
		System.out.println();
		for(int i =0; i <= 20; i++){
			System.out.println("\n");
		}
		System.out.println("***********************************************************");
		System.out.println("Thank you for using HP E-Wallet. Have a nice day ahead....");
		service.writeToFile();
		System.exit(0);
		
	}
/*==============================================================================MAIN END==================================================================================*/
/*=========================================================================BANKING START==================================================================================*/
	@SuppressWarnings("resource")
	public static void Banking() throws Exception{
		
		for(int i =0; i <= 20; i++){
			System.out.println("\n");
		}
		
		GregorianCalendar calender = new GregorianCalendar();
		int date = calender.get(Calendar.DAY_OF_MONTH);
		int month= calender.get(Calendar.MONTH);
		int year = calender.get(Calendar.YEAR);
		
		int choice = 0;
		again:
		do{
			try{
				Scanner scan = new Scanner(System.in);
				System.out.println("************BANKING*******" +(month+1)+ "/" +date+ "/" +year+ "*****");
				System.out.println("Welcome to the banking Service of HP E-Wallet\n\n You have the following Options to choose from..");
				System.out.print("\n1. Create Account\t\t2. Withdraw Amount\n3. Deposite Amount\t\t4. Check Balance\n5. Funds Transfer\t\t6. Get Statement\n\t\t\t\t8. Go back to the Previous Menu.\n\tEnter your Choice : ");
				choice = scan.nextInt();
			}
			catch(InputMismatchException e){
				System.out.println("\n\nYou have entered a non integer value.\n Please retry......\n\n\n\n====================================================\n\n");
				choice = 0;
				continue again;
			}
			
			switch (choice){
			case 1:{
				choice = 0;
				for(int i =0; i <= 20; i++){
					System.out.println("\n");
				}
				createAccount();
				break;
			}
			
			case 2:{
				choice = 0;
				for(int i =0; i <= 20; i++){
					System.out.println("\n");
				}
				withdrawAmount();
				break;
			}
			
			case 3:{
				depositAmount();
				break;
			}
			
			case 4:{
				checkBalance();
				break;
			}
			
			case 5:{
				fundsTransfer();
				break;
			}
			
			case 6:{
				getStatement();
				break;
			}
			
			case 8:{
				//get back to the main menu
				for(int i =0; i <= 60; i++){
					System.out.println("\n");
				}
				main(null);
				break;
			}
			
			case 9:{
				break;
			}
			
			default:{
				System.out.println("\n\n You have entered an incorrect option please try again..\n");
				System.out.println("=============================================================");
				choice = 0;
				continue again;
			}
			}
			
		}while(choice != 9);
	}

	/*===========================================================================BANKING END==================================================================================*/
/*=======================================================================ADMIN USE START==================================================================================*/
	public static void AdminUse() throws Exception{
		try{Scanner scan = new Scanner(System.in);
		System.out.print("Enter the PIN code in order to delete the file else enter 9 to go back : ");
		int pinCode = scan.nextInt();
		if(pinCode == 1469){
			File file= new File("CustomerDetials.text");
			System.out.println("\nThe File data is as follows : ");
			service.printFileData();
			System.out.println("\nIf you wish to delete the file then press * else 9 to exit");
			String tmp = scan.next();
			if(tmp.equals("*")){
			file.delete();System.out.println("File successfully deleted....");}
			else if (tmp.equals("9")){
				main(null);
			}
			
			
		}
		else if (pinCode == 9)
		{
			main(null);
		}
		else{
			System.out.println("Incorrect pin");
			System.out.println("\n\n");
		}}
		catch(Exception e){
			main(null);
		}
	}
/*=========================================================================ADMIN USE END==================================================================================*/
/*=========================================================================HELP DESK START================================================================================*/
	public static void HelpDesk() throws Exception{
		for(int i = 0; i<=20;i++){
			System.out.println();
		}
		Scanner scan = new Scanner(System.in);
		CustomerAccountClass temp;
		
		do {
			try {
				System.out
				.print("Enter the password to access the database fro customer support : ");
				int pascode = scan.nextInt();
				if(pascode == 891996){
					System.out.println("\n\nThe password is accepted\n");
					System.out.print("Enter the customer ID : ");
					String customerID = scan.next();
					try {
						temp = service.getCustomerDataFromSet(customerID);
						
						System.out.println("Hi, " + temp.getFirstName() + " " + temp.getLastName() + ", customer Id : " + temp.getCustomerID()+".\n\n");
						temp.toStringHelpDesk();
						main(null);
						break;
					}
					catch(EWalletException e){
						System.out.print("\nThere is no account linked to this customer ID..\nPlease verify your customer ID or press 9 to exit \n\t\tor press 1 to start again : " );
						String tmp = scan.next();
						if(tmp == "9")Banking();
						else if (tmp == "1"){
							continue;
						}
					}
				}} catch (InputMismatchException e) {
					System.out.println("Invalid Input retry.\n\n");
				}
			} while (true);
		
	}
/*=========================================================================HELP DESK END==================================================================================*/	
/*=========================================================================CREATE ACCOUNT START===========================================================================*/
	@SuppressWarnings("resource")
	private static void createAccount() throws Exception{

		CustomerAccountClass customer = new CustomerAccountClass();
		GregorianCalendar calender = new GregorianCalendar();
		Scanner scan = new Scanner(System.in);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int date = calender.get(Calendar.DAY_OF_MONTH);
		int month= calender.get(Calendar.MONTH);
		int year = calender.get(Calendar.YEAR);
		
		customer.setDateOfOpening(date);
		customer.setMonthOfOpening(month + 1);
		customer.setYearOfOpening(year);
		
		boolean isFnameValid = false;
		boolean isMnameValid = false;
		boolean isLnameValid = false;
		boolean isAgeValid = false;
		boolean isAmountValid = false;
		boolean isCityValid = false;
		boolean isStateValid = false;
		boolean isCountryValid = false;
		boolean isMobileNumberValid = false;
		boolean isAreaPinCodeValid = false;
		boolean isGovtCodeValid = false;
		boolean isGovtIDNumberLongValid = false;
		boolean isGovtIDNumberStringValid = false;
		boolean isPinCodeValid = false;
		
		String fname, mname, lname, address, city, state, areaPinCode, country, mobileNumber, govtIDProof, govtIDNumber, pinCode, customerID;
		int age, gender, choice =0, govtIDProofChoice = 0;
		long amount;
		
		System.out.println("\n\n\n******************Account Creation*****" +(month+1)+ "/" +date+ "/" +year+ "*****\n\n");
		System.out.println("\nThe Following will guide you throw the process of account creation.\nPlease read the instructions clearfully.");
		System.out.print("\nPlease Enter your FIRST NAME : ");
		
		againFname:
		do{
			
			fname = scan.next();
			isFnameValid = service.validateFirstName(fname);
			if (isFnameValid == true)break;
			else if(isFnameValid == false){
				System.out.print("\tThe name you entered is inValid..\nPlease re-enter : ");
				continue againFname;
			}
		}while(choice != 9);
		
		if(isFnameValid == true){
			customer.setFirstName(fname);
			System.out.print("\tThe name is accepted..\n\n");
		}
		
		System.out.print("\nPlease Enter your MIDDLE NAME : ");
		
		againMname:
			do{
				
				mname = scan.next();
				isMnameValid = service.validateMiddleName(mname);
				if (isMnameValid == true)break;
				else if(isMnameValid == false){
					System.out.print("\tThe name you entered is inValid..\nPlease re-enter : ");
					continue againMname;
				}
			}while(choice != 9);
			
			if(isMnameValid == true){
				customer.setMiddleName(mname);
				System.out.print("\tThe name is accepted..\n\n");
			}
			
			System.out.print("\nPlease Enter your LAST NAME : ");
			
			againLname:
				do{
					
					lname = scan.next();
					isLnameValid = service.validateLastName(mname);
					if (isLnameValid == true)break;
					else if(isLnameValid == false){
						System.out.print("\tThe name you entered is inValid..\nPlease re-enter : ");
						continue againLname;
					}
				}while(choice != 9);
				
				if(isLnameValid == true){
					customer.setLastName(lname);
					System.out.print("\tThe name is accepted..\n\n");
				}
				
				for(int i =0; i <= 5; i++){
					System.out.println("\n");
				}
				
				againAge:
					do{
						
						try{
							System.out.print("Enter your age : ");
							age = scan.nextInt();
							isAgeValid = service.validateAge(age);
							if(isAgeValid == false){
								System.out.println("\nThe acount holder has to be within 16 to 130 years old.");
								System.out.print("\tThe age you entered is inValid..\nPlease re-enter : ");
								continue againAge;
							}
							else if(isAgeValid == true){
								customer.setAge(age);
								System.out.print("\tThe age is accepted..\n\n");
								break;
							}
						}
						catch(InputMismatchException e){
							System.out.println("\nYou have entered a non-Integer Value for age.\n Please re-enter..\n");
							continue againAge;
						}
				}while(choice != 9);
				
				for(int i =0; i <= 5; i++){
					System.out.println("\n");
				}
				
				againGender:
					do{
						try{
							System.out.print("Please select your gender from the following options.\n\n1. Female\t2. Male\t\t3. Others\n\t\tYour choice : ");
							gender = scan.nextInt();			
		
							switch(gender){
							case 1:{
								customer.setGender("Female");
								break;
							}
							
							case 2:{
								customer.setGender("Male");
								break;
							}
							
							case 3:{
								customer.setGender("Others");
								break;
							}
							default:{
								System.out.println("You have entered an incorrect option.. Please retry..\n");
								continue againGender;
							}
							
							}
							System.out.println(customer.getGender() + " has been selected..");
							break;
						}
						
						catch(InputMismatchException e){
							System.out.println("You have entered a non Integer value. Please retry....\n\n");
							continue againGender;
						}
					}while(choice != 9);
				
				for(int i =0; i <= 5; i++){
					System.out.println("\n");
				}
				
				againMobileNumber:
					do{
						
						try{
							System.out.print("Enter your Mobile Number : ");
							mobileNumber = scan.next();
							isMobileNumberValid = service.validateMobileNumber(mobileNumber);
							if(isMobileNumberValid == false){
								System.out.println("\nThe mobile number has to be 10 digit W/O country code.");
								System.out.print("\tThe mobile number you entered is inValid..\nPlease re-enter : ");
								continue againMobileNumber;
							}
							else if(isMobileNumberValid == true){
								customer.setMobileNumber(mobileNumber);
								System.out.print("\tThe mobile number is accepted..\n\n");
								break;
							}
						}
						catch(InputMismatchException e){
							System.out.println("\nYou have entered a non-Integer Value for mobile number.\n Please re-enter..\n");
							continue againMobileNumber;
						}
				}while(choice != 9);
				
				for(int i =0; i <= 5; i++){
					System.out.println("\n");
				}
				
				againAddress:
					do{
						System.out.println("Enter Your address : ");
						 
						address = reader.readLine();
						if(address == null){
							System.out.println("\n\t\tPlease enter your Address...\n");
							continue againAddress;
						}
						else{
							customer.setAddressLine(address);
							System.out.println("\n\t\tThe Address is accepted..");
							break;
						}
					}while(choice != 9);
				
				for(int i =0; i <= 5; i++){
					System.out.println("\n");
				}
				
				againCity:
					do{
						try{
							System.out.print("Enter Your city : ");
							city = scan.next();
							isCityValid = service.validateCity(city);
							if (isCityValid){
								customer.setCity(city);
								System.out.println("\n\t\tThe city name has been accepted..");
								break;
							}
							else{
								System.out.println("\nThe city name you have entered is not valid..\n\t\tPlease re-enter...\n\n");
								continue againCity;
							}
						}
						catch(InputMismatchException e){
							System.out.println("\nThe city should be in propper format. in Camel Case..\n\t\tPlease retry.....");
							continue againCity;
						}
					}while(choice != 9);
				
				for(int i =0; i <= 5; i++){
					System.out.println("\n");
				}
				
				againState:
					do{
						try{
							System.out.print("Enter Your state : ");
							state = scan.next();
							isStateValid = service.validateState(state);
							if (isStateValid){
								customer.setState(state);
								System.out.println("\n\t\tThe state name has been accepted..");
								break;
							}
							else{
								System.out.println("\nThe state name you have entered is not valid..\n\t\tPlease re-enter...\n\n");
								continue againState;
							}
						}
						catch(InputMismatchException e){
							System.out.println("\nThe state should be in propper format. in Camel Case..\n\t\tPlease retry.....");
							continue againState;
						}
					}while(choice != 9);
				
				for(int i =0; i <= 5; i++){
					System.out.println("\n");
				}
				
				againAreaPinCode:
					do{
						
						try{
							System.out.print("Enter your pin code : ");
							areaPinCode = scan.next();
							isAreaPinCodeValid = service.validateAreaPinCode(areaPinCode);
							if(isAreaPinCodeValid == false){
								System.out.println("\nThe area pin code has to be 10 digit W/O country code.");
								System.out.print("\tThe area pin code you entered is inValid..\nPlease re-enter : ");
								continue againAreaPinCode;
							}
							else if(isAreaPinCodeValid == true){
								customer.setAreaPinCode(areaPinCode);
								System.out.print("\tThe area pin code is accepted..\n\n");
								break;
							}
						}
						catch(InputMismatchException e){
							System.out.println("\nYou have entered a non-Integer Value for area pin code.\n Please re-enter..\n");
							continue againAreaPinCode;
						}
				}while(choice != 9);
				
				for(int i =0; i <= 5; i++){
					System.out.println("\n");
				}
				
				againCountry:
					do{
						try{
							System.out.print("Enter Your Country : ");
							country = scan.next();
							isCountryValid = service.validateCountry(country);
							if (isCountryValid){
								customer.setCountry(country);
								System.out.println("\n\t\tThe country name has been accepted..");
								break;
							}
							else{
								System.out.println("\nThe country name you have entered is not valid..\n\t\tPlease re-enter...\n\n");
								continue againCountry;
							}
						}
						catch(InputMismatchException e){
							System.out.println("\nThe country should be in propper format. in Camel Case..\n\t\tPlease retry.....");
							continue againCountry;
						}
					}while(choice != 9);
				
				for(int i =0; i <= 5; i++){
					System.out.println("\n");
				}
				
				againGovtIDProof:
					do{
						try{
							System.out.print("Please select the Government identification proof which you wish to submit from the following options.\n\n1. Aadhar Card\t2. PAN Card\t\t3. Voter ID Card\n\t\tYour choice : ");
							govtIDProofChoice = scan.nextInt();			
		
							switch(govtIDProofChoice){
							case 1:{
								customer.setGovtIDProof("Aadhar Card");
								break;
							}
							
							case 2:{
								customer.setGovtIDProof("PAN Card");
								break;
							}
							
							case 3:{
								customer.setGovtIDProof("Voter ID Card");
								break;
							}
							default:{
								System.out.println("You have entered an incorrect option.. Please retry..\n");
								continue againGovtIDProof;
							}
							
							}
							System.out.println(customer.getGovtIDProof() + " has been selected..");
							break;
						}
						
						catch(InputMismatchException e){
							System.out.println("You have entered a non Integer value. Please retry....\n\n");
							continue againGovtIDProof;
						}
					}while(choice != 9);
				
				for(int i =0; i <= 5; i++){
					System.out.println("\n");
				}
				
				againGovtIDNumber:
					do{
						try{
							System.out.print("Enter the number of " + customer.getGovtIDProof() +" : ");
							govtIDNumber = scan.next();
							if(govtIDProofChoice == 1){
								isGovtIDNumberLongValid = service.validateGovtIDNumberLong(govtIDNumber);
								if(isGovtIDNumberLongValid){
									customer.setGovtIDNumber(govtIDNumber);
									System.out.println("\n\t\tThe Aadhar Card Number has been ACCEPTED..");
									break;
								}
								else{
									System.out.println("\nThe Aadhar Card Number you have entered is invalid..\n\t\tPlease retry..");
									continue againGovtIDNumber;
								}
							}
							else{
								isGovtIDNumberStringValid = service.validateGovtIDNumberString(govtIDNumber);
								if(isGovtIDNumberStringValid){
									customer.setGovtIDNumber(govtIDNumber);
									System.out.println("\n\t\tThe " + customer.getGovtIDNumber() +" number has been ACCEPTED..");
									break;
								}
								else{
									System.out.println("\nThe " + customer.getGovtIDNumber() +" Number you have entered is invalid..\n\t\tPlease retry..");
									continue againGovtIDNumber;
								}
							}
						}
						catch(InputMismatchException e){
							System.out.println("\nThe " + customer.getGovtIDNumber() +" should be valid..\n\t\tPlease retry.....");
							continue againGovtIDNumber;
						}
					}while(choice != 9);
				
				for(int i =0; i <= 5; i++){
					System.out.println("\n");
				}
				
				againPin:
					do{
						try{
							System.out.print("Enter the PinCode which would be required to access your account..\n The pinCode should be of 4 digit : ");
							pinCode = scan.next();
							isPinCodeValid = service.validatePinCode(pinCode);
							if(isPinCodeValid){
								isPinCodeValid = false;
								System.out.print("\n\t\tThe Pin has been accepted.. Please re-enter it to confirm.. : ");
								String temp = scan.next();
								isPinCodeValid = service.validatePinCode(temp);
								if(isPinCodeValid){
									if(temp.equals(pinCode)){
										customer.setPinCode(pinCode);
										System.out.println("\n\t\t The Pin Code is applied to your account. Remember it for future use..\n");
										break;
									}
									else{
										System.out.println("\nThe Pin Code doesn't match..\n\t\tPlease retry.....\n\n");
										continue againPin;
									}
								}
								else{
									System.out.println("\n\nThe PIN you have entered is invalid..\n\t\tPlease retry...\n");
									continue againPin;
								}
							}
							else{
								System.out.println("\n\nThe PIN you have entered is invalid..\n\t\tPlease retry...\n");
								continue againPin;
							}
						}
						catch(InputMismatchException e){
							System.out.println("\n\nThe PIN you have entered is invalid..\n\t\tPlease retry...\n");
							continue againPin;
						}
					}while(choice != 9);
				
				for(int i =0; i <= 5; i++){
					System.out.println("\n");
				}
				
				againAmount:
					do{
						try{
							System.out.print("Enter the Amount you want to deposite : ");
							amount = scan.nextLong();
							isAmountValid = service.validateAmount(amount);
							if(isAmountValid){
								customer.setAmount(amount);
								System.out.println("\n\t\tThe amount has been Accepted..");
								break;
							}
							else{
								System.out.println("\nThe amount to be deposited should range from 100 to 50,000 INR\n\n");
								continue againAmount;
							}
						}
						catch(InputMismatchException e){
							System.out.println("\nThe amount should be in numbers..\n\t\tPlease retry.....");
							continue againAmount;
						}
					}while(choice != 9);
				
				
				for(int i =0; i <= 5; i++){
					System.out.println("\n");
				}
				/*The Following code will return and print the value of the randomly generated customer ID which can be used to access the information.*/
				customerID = service.addCustomerDetails(customer);
				System.out.println("Your account has been succesfully created...\n The Customer ID assigned to you is : " +customerID+ "\n\tUse this ID to access your account.\n\n HP E-Wallet..Working to serve you better.......");
				
				again:
				while(true){
					try{
						System.out.println("\nSending you back to the Main menu...\n\t\t press 9 to continue...");
						int temp = scan.nextInt();
						switch(temp){
						case 9:{
							for(int i =0; i <= 40; i++){
								System.out.println("\n");
							}
							main(null);
							break;
						}
						default:{
							System.out.println("The inout is incorreect..");
							continue again;
						}
						}
					}
					catch(InputMismatchException e){
						System.out.println("\nYou have intered a wrong value..\n\n");
						continue again;
					}
				}
				
	}
/*=========================================================================CREATE ACCOUNT END=============================================================================*/
	
/*=========================================================================WITHDRAW STARTS=============================================================================*/
	private static void withdrawAmount() throws IOException, Exception{
		System.out.println("\n\n\n\n\n\n");
		CustomerAccountClass customer = new CustomerAccountClass();
		GregorianCalendar calender = new GregorianCalendar();
		Scanner scan = new Scanner(System.in);
		CustomerAccountClass temp = new CustomerAccountClass();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int date = calender.get(Calendar.DAY_OF_MONTH);
		int month= calender.get(Calendar.MONTH);
		int year = calender.get(Calendar.YEAR);
		int CustomerID = 0;
		
		long amount = 0;		
		
		String pinCode = null;
		String customerID;
		
		int choice = 0;
		//System.out.println(customerDetailsMap);
		
		again:
		do{
			try{
				System.out.println("************WITHDRAW AMOUNT********" +(month+1)+ "/" +date+ "/" +year+ "*****");
				System.out.print("Enter your Customer ID : ");
				customerID = scan.next();
					try {
						temp = service.isCustomerIDEnteredAvailable(customerID);
						
						System.out.println("Hi, " + temp.getFirstName() + " " + temp.getLastName() + ", customer Id : " + temp.getCustomerID()+".\n\n");
						break;
						
					} catch (EWalletException e) {
						
						System.out.println(e.getMessage());
						System.out.print("\nPlease verify your customer ID or press 9 to exit \n\t\tor press 1 to start again : " );
					String tmp = scan.next();
					if(tmp == "9")Banking();
					else if (tmp == "1"){
						continue;
					}
				}
			}
			catch(InputMismatchException e){
				System.out.println("\n\nYou have entered an invalid value.\n Please retry......\n\n\n\n====================================================\n\n");
				choice = 0;
				continue;
			}
		}while(true);
		
		System.out.print("Enter the PIN code : ");
		pinCode = scan.next();
		if(!service.isEnteredPinCodeIsValid(pinCode, temp)){
			System.out.println("Incorrect PinCode");
			Banking();
		}
		againAmountEntry:
		while (true) {
			try {
				System.out.print("Enter the amount you want to withdraw : ");
				amount = scan.nextLong();
				
				if (service.isAmountValid(amount, temp)) {
					break;
				}
				System.out.println("Please re-enter the amount : ");
				continue;
			} catch (Exception e) {
				System.out.println("Your amount in non integer please retry..");
				continue;
			}
		}
		
		Long temp1 = temp.getAmount() - amount;
		
		temp.setAmount(temp1);
		service.updateSetFile(customerID, temp);
		
		System.out.println("/n/nThank you your transaction was successfull available balance in your account is now : " +temp.getAmount());
		while (true) {
			try {
				System.out.print("Press 9 to exit : ");
				int choiceTemp = scan.nextInt();
				if(choiceTemp==9)Banking();
			} catch (InputMismatchException e) {
				
				System.out.println("\n\nInvalid input please re try.");
				continue;
			}
		}
	}
/*=========================================================================WITHDRAW ends=============================================================================*/	
/*=========================================================================DEPOSIT STARTS=============================================================================*/
	private static void depositAmount() throws Exception {
		System.out.println("\n\n\n\n\n\n");
		CustomerAccountClass customer = new CustomerAccountClass();
		GregorianCalendar calender = new GregorianCalendar();
		Scanner scan = new Scanner(System.in);
		CustomerAccountClass temp = new CustomerAccountClass();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int date = calender.get(Calendar.DAY_OF_MONTH);
		int month= calender.get(Calendar.MONTH);
		int year = calender.get(Calendar.YEAR);
		int CustomerID = 0;
		
		long amount = 0;		
		
		String pinCode = null;
		String customerID;
		
		int choice = 0;
		//System.out.println(customerDetailsMap);
		
		again:
		do{
			try{
				System.out.println("************DEPOSIT AMOUNT********" +(month+1)+ "/" +date+ "/" +year+ "*****");
				System.out.print("Enter your Customer ID : ");
				customerID = scan.next();
				try {
					temp = service.isCustomerIDEnteredAvailable(customerID);
					
					System.out.println("Hi, " + temp.getFirstName() + " " + temp.getLastName() + ", customer Id : " + temp.getCustomerID()+".\n\n");
					break;
				}
				catch(EWalletException e){
					System.out.print("\nThere is no account linked to this customer ID..\nPlease verify your customer ID or press 9 to exit \n\t\tor press 1 to start again : " );
					String tmp = scan.next();
					if(tmp == "9")Banking();
					else if (tmp == "1"){
						continue;
					}
				}
			}
			catch(InputMismatchException e){
				System.out.println("\n\nYou have entered an invalid value.\n Please retry......\n\n\n\n====================================================\n\n");
				choice = 0;
				continue;
			}
		}while(true);
		
		System.out.print("Enter the PIN code : ");
		pinCode = scan.next();
		if(!service.isEnteredPinCodeIsValid(pinCode, temp)){
			System.out.println("Incorrect PinCode");
			Banking();
		}
		againAmountEntry:
		while (true) {
			try {
				System.out.print("Enter the amount you want to deposit : ");
				amount = scan.nextLong();
				
				if (service.isDepositAmountValid(amount, temp)) {
					break;
				}
				System.out.println("Please reenter the amount : ");
				continue;
			} catch (Exception e) {
				System.out.println("Your amount in non integer please retry..");
				continue;
			}
		}
		
		Long temp1 = temp.getAmount() + amount;
		
		temp.setAmount(temp1);
		service.updateSetFile(customerID, temp);
		
		System.out.println("/n/nThank you your transaction was successfull available amount in your account is now : " +temp.getAmount());
		while (true) {
			try {
				System.out.print("Press 9 to exit : ");
				int choiceTemp = scan.nextInt();
				if(choiceTemp==9)Banking();
			} catch (InputMismatchException e) {
				
				System.out.println("\n\nInvalid input please re try.");
				continue;
			}
		
		}
	}
/*=========================================================================DEPOSIT ends=============================================================================*/
/*=========================================================================FUND TRANSFER STARTS=============================================================================*/
	private static void fundsTransfer() throws Exception {
		System.out.println("\n\n\n\n\n\n");
		CustomerAccountClass customer = new CustomerAccountClass();
		GregorianCalendar calender = new GregorianCalendar();
		Scanner scan = new Scanner(System.in);
		CustomerAccountClass temp = new CustomerAccountClass();
		CustomerAccountClass tempRec = new CustomerAccountClass();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int date = calender.get(Calendar.DAY_OF_MONTH);
		int month= calender.get(Calendar.MONTH);
		int year = calender.get(Calendar.YEAR);
		int CustomerID = 0;
		
		long amount = 0;		
		
		String pinCode = null;
		String customerID, customerID2;
		
		int choice = 0;
		
		
		again:
		do{
			try{
				System.out.println("************FUND TRANSFER********" +(month+1)+ "/" +date+ "/" +year+ "*****");
				System.out.print("Enter your Customer ID : ");
				customerID = scan.next();
				try {
					temp = service.isCustomerIDEnteredAvailable(customerID);
					
					System.out.println("Hi, " + temp.getFirstName() + " " + temp.getLastName() + ", customer Id : " + temp.getCustomerID()+".\n\n");
					break;
					
				} catch (EWalletException e) {
					
					System.out.println(e.getMessage());
					System.out.print("\nPlease verify your customer ID or press 9 to exit \n\t\tor press 1 to start again : " );
				String tmp = scan.next();
				if(tmp == "9")Banking();
				else if (tmp == "1"){
					continue;
				}
			}
			}
			catch(InputMismatchException e){
				System.out.println("\n\nYou have entered an invalid value.\n Please retry......\n\n\n\n====================================================\n\n");
				choice = 0;
				continue;
			}
		}while(true);
		
		System.out.print("Enter the PIN : ");
		pinCode = scan.next();
		if(!service.isEnteredPinCodeIsValid(pinCode, temp)){
			System.out.println("Incorrect PinCode");
			Banking();
		}
		againAmountEntry:
		while (true) {
			try {
				System.out.print("Enter the amount you want to transfer : ");
				amount = scan.nextLong();
				
				if (service.isAmountValid(amount, temp)) {
					break;
				}
				System.out.println("Please reenter the amount : ");
				continue;
			} catch (Exception e) {
				System.out.println("Your amount in non integer please retry..");
				continue;
			}
		}
		
		Long temp1 = temp.getAmount() - amount;
		
		temp.setAmount(temp1);
		service.updateSetFile(customerID, temp);
		service.printFileData();
		
			do{
				try{
					System.out.print("Enter the Customer ID of the reciever : ");
					customerID2 = scan.next();
					try {
						tempRec = service.isCustomerIDEnteredAvailable(customerID2);
						
						System.out.println(temp.getFirstName() + " " + temp.getLastName() + ", customer Id : " + temp.getCustomerID()+".\n\n");
						break;
						
					} catch (EWalletException e) {
						
						System.out.println(e.getMessage());
						System.out.print("\nPlease verify the customer ID or press 9 to exit \n\t\tor press 1 to start again : " );
					String tmp = scan.next();
					if(tmp == "9")Banking();
					else if (tmp == "1"){
						continue;
					}
				}
				}
				catch(InputMismatchException e){
					System.out.println("\n\nYou have entered an invalid value.\n Please retry......\n\n\n\n====================================================\n\n");
					choice = 0;
					continue;
				}
			}while(true);
		
			temp1 = tempRec.getAmount() + amount;
			
			tempRec.setAmount(temp1);
			service.updateSetFile(customerID2, tempRec);
			
		System.out.println("\n\nThank you your transaction was successfull available amount in your account is now : " +temp.getAmount()+"\n\tThe amount of Rs. "+amount+" was transferred to customer ID : "+tempRec.getCustomerID()+".\n");
		while (true) {
			try {
				System.out.print("Press 9 to exit : ");
				int choiceTemp = scan.nextInt();
				if(choiceTemp==9)Banking();
			} catch (InputMismatchException e) {
				
				System.out.println("\n\nInvalid input please re try.");
				continue;
			}
		
		}
	}
/*=========================================================================FUND TRANSFER ends=============================================================================*/
	/*=========================================================================CHECK BALANCE STARTS=============================================================================*/
	private static void checkBalance() throws Exception{
		System.out.println("\n\n\n\n\n\n");
		CustomerAccountClass customer = new CustomerAccountClass();
		GregorianCalendar calender = new GregorianCalendar();
		Scanner scan = new Scanner(System.in);
		CustomerAccountClass temp = new CustomerAccountClass();
		CustomerAccountClass tempRec = new CustomerAccountClass();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int date = calender.get(Calendar.DAY_OF_MONTH);
		int month= calender.get(Calendar.MONTH);
		int year = calender.get(Calendar.YEAR);
		int CustomerID = 0;
		
		long amount = 0;		
		
		String pinCode = null;
		String customerID;
		
		int choice = 0;
		
		
		again:
		do{
			try{
				System.out.println("************BALANCE CHECK********" +(month+1)+ "/" +date+ "/" +year+ "*****");
				System.out.print("Enter your Customer ID : ");
				customerID = scan.next();
				try {
					temp = service.isCustomerIDEnteredAvailable(customerID);
					
					System.out.println("Hi, " + temp.getFirstName() + " " + temp.getLastName() + ", customer Id : " + temp.getCustomerID()+".\n\n");
					break;
					
				} catch (EWalletException e) {
					
					System.out.println(e.getMessage());
					System.out.print("\nPlease verify your customer ID or press 9 to exit \n\t\tor press 1 to start again : " );
				String tmp = scan.next();
				if(tmp == "9")Banking();
				else if (tmp == "1"){
					continue;
				}
			}
			}
			catch(InputMismatchException e){
				System.out.println("\n\nYou have entered an invalid value.\n Please retry......\n\n\n\n====================================================\n\n");
				choice = 0;
				continue;
			}
		}while(true);
		
		System.out.print("Enter the PIN : ");
		pinCode = scan.next();
		if(!service.isEnteredPinCodeIsValid(pinCode, temp)){
			System.out.println("Incorrect PinCode");
			Banking();
		}
		
		System.out.println("\n\nThe balance amount in your account is " + temp.getAmount());
		
		while (true) {
			try {
				System.out.print("Press 9 to exit : ");
				int choiceTemp = scan.nextInt();
				if(choiceTemp==9)Banking();
			} catch (InputMismatchException e) {
				
				System.out.println("\n\nInvalid input please re try.");
				continue;
			}
		
		}
	}
	/*=========================================================================FUND TRANSFER ENDS=============================================================================*/
	/*=========================================================================GET STATEMENT STARTS=============================================================================*/
	public static void getStatement() throws Exception{
		
		//service.getTransaction();
		Banking();
	}
	/*=========================================================================GET STATEMENT ENDS=============================================================================*/
}