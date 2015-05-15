package sg.edu.nus.iss.vmcs.util;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import java.util.ResourceBundle;

import sg.edu.nus.iss.vmcs.system.Environment;

public class StockIndicatorFactory {
	public static StockIndicator getStockIndicator(int initialQuantity) {
		String type = Environment.getStockIndicatorType();
		if(type == null)
		{
			//should throw exception;
			return null;
		}
		
		switch(type.toLowerCase()) {
			case "actual":
				return new ActualStockIndicator(initialQuantity);
			case "lowstock":
				return new LowStockIndicator(initialQuantity);
			case "nostock":
				return new NoStockIndicator(initialQuantity);
			default:
				//Should throw exception
				return null;
		}
	}
}
