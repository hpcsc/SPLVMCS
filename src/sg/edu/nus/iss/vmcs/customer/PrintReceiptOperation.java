package sg.edu.nus.iss.vmcs.customer;

public class PrintReceiptOperation extends ReceiptOperation {
	public PrintReceiptOperation(ReceiptOptionsPanel parent) {
		super("Print receipt");
	}

	@Override
	public void performOperation() {
		//Supposed to call external printer to print receipt. Print to console for now for simplicity
		System.out.println("Showing receipt on screen");
	}
}
