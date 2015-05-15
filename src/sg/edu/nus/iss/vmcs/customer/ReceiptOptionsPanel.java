package sg.edu.nus.iss.vmcs.customer;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingUtilities;

public class ReceiptOptionsPanel extends Dialog {
	private ReceiptOperation[] availableOperations;
	private Panel panel;
	
	public ReceiptOptionsPanel(Dialog parent, final TransactionController transactionController) {
		super(parent, "Select an option", true);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		panel = new Panel(new GridLayout());
		this.add(panel);

		availableOperations = ReceiptOperationFactory.getAvailableReceiptOptions(this);
	
		for(final ReceiptOperation operation : availableOperations) {
			Button button = new Button();
			button.setLabel(operation.getName());
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					transactionController.closeReceiptOptionsPanel();
					
					operation.performOperation();
					
					transactionController.refreshAfterTransaction();
				}
			});
			panel.add(button);
		}
		
		this.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                transactionController.closeReceiptOptionsPanel();
            }
        });
	}
}
