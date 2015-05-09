package sg.edu.nus.iss.vmcs.store;

import sg.edu.nus.iss.vmcs.system.Environment;

public class PersistenceFactory {
	private static Persistence _cashPersistence;
	private static Persistence _drinkPersistence;
	
	public static Persistence getCashPersistence() {
		if(_cashPersistence == null) {			
			_cashPersistence = new FilePersistence(Environment.getCashPropFile());
		}
		
		return _cashPersistence;
	}
	
	public static Persistence getDrinkPersistence() {
		if(_drinkPersistence == null) {			
			_drinkPersistence = new FilePersistence(Environment.getDrinkPropFile());
		}
		
		return _drinkPersistence;
	}
}
