package sg.edu.nus.iss.vmcs.customer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import sg.edu.nus.iss.vmcs.system.Environment;

public class ChangeGivingSchemeFactory {
	public static ChangeGivingScheme getChangeGivingScheme() {
		return createInstance(Environment.getChangeGivingScheme());
	}
	
	private static ChangeGivingScheme createInstance(String type) {
		try {
			Constructor c = Class.forName(type).getConstructor();
			return (ChangeGivingScheme) c.newInstance(); 
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
