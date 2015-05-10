package sg.edu.nus.iss.vmcs.customer;

import java.util.Hashtable;

import sg.edu.nus.iss.vmcs.store.StoreController;

public interface ChangeGivingScheme {
	Hashtable<Integer, Integer> calculateChanges(int changeRequired, StoreController storeCtrl, int changeBalance);
}
