package sg.edu.nus.iss.vmcs.customer;

import java.util.Hashtable;

import sg.edu.nus.iss.vmcs.store.Coin;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.store.StoreController;
import sg.edu.nus.iss.vmcs.store.StoreItem;

public class BalancedNoOfDenominationScheme implements ChangeGivingScheme {

	@Override
	public Hashtable<Integer, Integer> calculateChanges(int changeRequired,
			StoreController storeCtrl, int changeBalance) {		
		Hashtable<Integer, Integer> changes = new Hashtable<Integer, Integer>();
		
		int changeBal=changeRequired;
		
		int cashStoreSize=storeCtrl.getStoreSize(Store.CASH); 
		
		boolean hasCoinLeft = false;
		do {	
			hasCoinLeft = false;
			for(int i=cashStoreSize-1;i>=0;i--){
				StoreItem cashStoreItem=storeCtrl.getStore(Store.CASH).getStoreItem(i);
				int quantity=cashStoreItem.getQuantity();				
				if(quantity > 0) {					
					Coin coin=(Coin)cashStoreItem.getContent();					
					
					if(changeBal > coin.getValue()) {
						changeBal-=coin.getValue();					
											
						if(changes.containsKey(i)) {							
							changes.put(i, changes.get(i) + 1);						
						}
						else {							
							changes.put(i, 1);						
						}					
						
						cashStoreItem.setQuantity(quantity - 1);					
						hasCoinLeft = true;
					}
				}						
			}
		}
		while(hasCoinLeft && changeBal > 0);
		
		changeBalance = changeBal;
		
		return changes;	
	}
}
