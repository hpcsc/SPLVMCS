package sg.edu.nus.iss.vmcs.customer;

import java.awt.Dialog;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ShowOnScreenReceiptOperation extends ReceiptOperation {
	private ReceiptOptionsPanel parent;
	
	public ShowOnScreenReceiptOperation(ReceiptOptionsPanel parent) {
		super("Show on screen");
		this.parent = parent;
	}

	@Override
	public void performOperation() {
		//Supposed to open dialog that display receipt. Print to console for now for simplicity
		System.out.println("Showing receipt on screen");
		
		/*
		final Dialog dialog = new Dialog(parent, "Receipt", true);
		dialog.setSize(300, 400);
		dialog.setLocationRelativeTo(null);
		dialog.add(new Label("Some receipt content"));
		dialog.setVisible(true);
		*/
	}
}
