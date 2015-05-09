package sg.edu.nus.iss.vmcs.util;

public class ActualStockIndicator extends StockIndicator {
	public ActualStockIndicator(int initialQuantity) {
		super(initialQuantity);
	}

	@Override
	protected String getLabelForQuantity(int quantity) {
		return String.format("%d left", quantity);
	}
}
