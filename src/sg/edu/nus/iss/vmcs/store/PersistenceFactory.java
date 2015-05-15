package sg.edu.nus.iss.vmcs.store;

import sg.edu.nus.iss.vmcs.system.Environment;

public class PersistenceFactory {
	private static Persistence _cashPersistence;
	private static Persistence _drinkPersistence;
	
	public static Persistence getCashPersistence() {
		if(_cashPersistence == null) {	
			if(Environment.getStorageType().toLowerCase().equals("file")) {
				_cashPersistence = new FilePersistence(Environment.getCashPropFile());
			}
			else {
				_cashPersistence = new DatabasePersistence();
			}
		}
		
		return _cashPersistence;
	}
	
	public static Persistence getDrinkPersistence() {
		if(_drinkPersistence == null) {	
			if(Environment.getStorageType().toLowerCase().equals("file")) {
				_drinkPersistence = new FilePersistence(Environment.getDrinkPropFile());
			}
			else {
				_drinkPersistence = new DatabasePersistence();
			}
		}
		
		return _drinkPersistence;
	}
}
