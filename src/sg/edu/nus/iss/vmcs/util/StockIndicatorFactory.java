package sg.edu.nus.iss.vmcs.util;

public class StockIndicatorFactory {
	public static StockIndicator getStockIndicator(StockIndicatorType type, int initialQuantity) {
		switch(type) {
			case Actual:
				return new ActualStockIndicator(initialQuantity);
			case LowStock:
				return new LowStockIndicator(initialQuantity);
			case NoStock:
				return new NoStockIndicator(initialQuantity);
			default:
				//Should throw exception
				return null;
		}
	}
}
