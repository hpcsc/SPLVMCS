/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */
package sg.edu.nus.iss.vmcs.system;

import java.io.*;
import java.util.*;

import sg.edu.nus.iss.vmcs.util.*;

/**
 * This entity object holds the environment settings used to configure the system.
 *
 * @version 3.0 5/07/2003
 * @author Olivo Miotto, Pang Ping Li
 */
public class Environment {
	/**This constant attribute identify the drink property filename*/
	public final static String DRINK_PROP_FILE = "drinkFile";
	/**This constant attribute identify the cash property filename*/
	public final static String CASH_PROP_FILE = "cashFile";
	/**This constant attribute denotes the password string*/
	public final static String PASSWORD = "password";
	public final static String STOCK_INDICATOR = "stockIndicator";
	public final static String STORAGE = "storage";
	public final static String CHANGE_GIVING_SCHEME = "givingScheme";
	public final static String RECEIPT_OPERATIONS = "receiptOperations";

	private static Properties prop;

	/**
	 * This method reads-in the environment setting from a properties file and stores them in
	 * a hash table.
	 * @param propFile the property file name.
	 * @throws VMCSException if reading property file fails.
	 */
	public static void initialize(String propFile) throws VMCSException {
		try {
			prop = new Properties();
			FileInputStream stream = new FileInputStream(propFile);
			prop.load(stream);
			stream.close();
		} catch (Exception e) {
			throw new VMCSException(
				"Environment.initialize",
				"Error loading environment properties: " + e);
		}
	}

	/**
	 * This method returns the name/ location of the DrinksStore properties file.
	 * @return the name of the DrinksStore properties file.
	 */
	public static String getDrinkPropFile() {
		return prop.getProperty(DRINK_PROP_FILE);
	}

	/**
	 * This method returns the name/ location of the CashStore properties file.
	 * @return the mane of the CashStore properties file.
	 */
	public static String getCashPropFile() {
		String fn;
		fn = prop.getProperty(CASH_PROP_FILE);
		return fn;
	}

	/**
	 * if you put password in the property file, the password is obtained here.
	 * @return the password
	 */
	public static String getPassword() {
		return prop.getProperty(PASSWORD);
	}
	
	public static String getStockIndicatorType() {
		return prop.getProperty(STOCK_INDICATOR);
	}
	
	public static String getStorageType() {
		return prop.getProperty(STORAGE);
	}
	
	public static String getChangeGivingScheme() {
		return prop.getProperty(CHANGE_GIVING_SCHEME);
	}
	
	public static String getReceiptOperations() {
		return prop.getProperty(RECEIPT_OPERATIONS);
	}
}//End of class Environment