package sg.edu.nus.iss.vmcs.customer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.iss.vmcs.system.Environment;

public class ReceiptOperationFactory {
	public static ReceiptOperation[] getAvailableReceiptOptions(ReceiptOptionsPanel panel) {
		List<ReceiptOperation> operations = new ArrayList<ReceiptOperation>();
		
		String[] config = Environment.getReceiptOperations().split(",");
		for(String c : config) {
			operations.add(createInstance(c, panel));
		}
		
		return operations.toArray(new ReceiptOperation[operations.size()]);
	}
	
	private static ReceiptOperation createInstance(String type, ReceiptOptionsPanel panel) {
		try {
			Constructor c = Class.forName(type).getConstructor(panel.getClass());
			return (ReceiptOperation) c.newInstance(panel); 
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
