package sg.edu.nus.iss.vmcs.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import sg.edu.nus.iss.vmcs.system.Environment;

public class StockIndicatorFactory {
	public static StockIndicator getStockIndicator(int initialQuantity) {
		String type = Environment.getStockIndicatorType();
		if(type == null)
		{
			//should throw exception;
			return null;
		}
		
		try {
			Constructor c = Class.forName(type).getConstructor(Integer.TYPE);
			return (StockIndicator) c.newInstance(initialQuantity); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		
		return null;
	}
}
