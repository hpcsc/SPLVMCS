package sg.edu.nus.iss.vmcs.customer;

public abstract class ReceiptOperation {
	private String name;
	
	public ReceiptOperation(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void performOperation();
}
