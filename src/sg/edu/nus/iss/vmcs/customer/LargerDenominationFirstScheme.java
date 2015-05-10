package sg.edu.nus.iss.vmcs.customer;

import java.util.Hashtable;

import sg.edu.nus.iss.vmcs.store.Coin;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.store.StoreController;
import sg.edu.nus.iss.vmcs.store.StoreItem;

public class LargerDenominationFirstScheme implements ChangeGivingScheme {

	@Override
	public Hashtable<Integer, Integer> calculateChanges(int changeRequired, 
			StoreController storeCtrl,
			int changeBalance) {
		
		Hashtable<Integer, Integer> changes = new Hashtable<Integer, Integer>();
		
		int changeBal=changeRequired;
		
		int cashStoreSize=storeCtrl.getStoreSize(Store.CASH); 
		
		for(int i=cashStoreSize-1;i>=0;i--){
			StoreItem cashStoreItem=storeCtrl.getStore(Store.CASH).getStoreItem(i);
			int quantity=cashStoreItem.getQuantity();
			Coin coin=(Coin)cashStoreItem.getContent();
			int value=coin.getValue();
			int quantityRequired=0;
			while(changeBal>0&&changeBal>=value&&quantity>0){
				changeBal-=value;
				quantityRequired++;
				quantity--;
			}
			
			changes.put(i, quantityRequired);			
		}
		
		changeBalance = changeBal;
		
		return changes;
	}

}
