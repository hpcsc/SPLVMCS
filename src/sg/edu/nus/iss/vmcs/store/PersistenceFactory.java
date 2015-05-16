package sg.edu.nus.iss.vmcs.store;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import sg.edu.nus.iss.vmcs.system.Environment;

public class PersistenceFactory {
	private static Persistence _cashPersistence;
	private static Persistence _drinkPersistence;
	
	public static Persistence getCashPersistence() {
		if(_cashPersistence == null) {	
			_cashPersistence = createInstance(Environment.getStorageType(),
					Environment.getCashPropFile());
		}
		
		return _cashPersistence;
	}
	
	public static Persistence getDrinkPersistence() {
		if(_drinkPersistence == null) {	
			_drinkPersistence = createInstance(Environment.getStorageType(),
					Environment.getDrinkPropFile());
		}
		
		return _drinkPersistence;
	}
	
	private static Persistence createInstance(String type, String param) {
		try {
			Constructor c = Class.forName(type).getConstructor(String.class);
			return (Persistence) c.newInstance(param); 
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
