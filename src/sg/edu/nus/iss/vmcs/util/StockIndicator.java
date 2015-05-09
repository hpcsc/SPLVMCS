package sg.edu.nus.iss.vmcs.util;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;

public abstract class StockIndicator extends Panel {
	private Label lb;
	
	public StockIndicator(int initialQuantity) {
		this.setLayout(new FlowLayout());
		lb = new Label(getLabelForQuantity(initialQuantity));
		lb.setForeground(Color.black);
		lb.setBackground(Color.white);
		this.add(lb);
	}
	
	public void changeStockQuantity(int quantity) {
		lb.setText(getLabelForQuantity(quantity));
	}
	
	protected abstract String getLabelForQuantity(int quantity);
}
