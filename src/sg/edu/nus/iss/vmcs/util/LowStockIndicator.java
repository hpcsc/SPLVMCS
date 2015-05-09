package sg.edu.nus.iss.vmcs.util;

public class LowStockIndicator extends StockIndicator {

	public LowStockIndicator(int initialQuantity) {
		super(initialQuantity);
	}

	@Override
	protected String getLabelForQuantity(int quantity) {
		if(quantity < 2) {
			return "Low Stock";
		}
		
		return "In Stock";
	}
}
