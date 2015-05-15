package sg.edu.nus.iss.vmcs.customer;

import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.iss.vmcs.system.Environment;

public class ReceiptOperationFactory {
	public static ReceiptOperation[] getAvailableReceiptOptions(ReceiptOptionsPanel panel) {
		List<ReceiptOperation> operations = new ArrayList<ReceiptOperation>();
		
		String[] config = Environment.getReceiptOperations().split(",");
		for(String c : config) {
			if(c.equals("skip")) {
				operations.add(new SkipReceiptOperation(panel));
			}
			else if(c.equals("print")) {
				operations.add(new PrintReceiptOperation(panel));
			}
			else if(c.equals("show")) {
				operations.add(new ShowOnScreenReceiptOperation(panel));
			}
		}
		
		return operations.toArray(new ReceiptOperation[operations.size()]);
	}
}
