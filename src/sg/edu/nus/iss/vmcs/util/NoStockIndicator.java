package sg.edu.nus.iss.vmcs.util;

public class NoStockIndicator extends StockIndicator {
	public NoStockIndicator(int initialQuantity) {
		super(initialQuantity);
	}

	@Override
	protected String getLabelForQuantity(int quantity) {
		if(quantity <= 0) {
			return "Out of Stock";
		}
		
		return "In Stock";
	}
}
