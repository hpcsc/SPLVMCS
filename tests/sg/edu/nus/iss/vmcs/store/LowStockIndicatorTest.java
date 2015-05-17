package sg.edu.nus.iss.vmcs.store;

import java.awt.Label;

import junit.framework.TestCase;

import org.junit.Test;

import sg.edu.nus.iss.vmcs.util.LowStockIndicator;
import sg.edu.nus.iss.vmcs.util.StockIndicator;

public class LowStockIndicatorTest extends TestCase {

	@Test
	public void testLowStockIndicatorReturnLowStockForQuantityOfOne() {
		StockIndicator indicator = new LowStockIndicator(1);
		assertEquals(((Label)indicator.getComponent(0)).getText(), "Low Stock");
	}

	@Test
	public void testLowStockIndicatorReturnInStockForQuantityOfThree() {
		StockIndicator indicator = new LowStockIndicator(3);
		assertEquals(((Label)indicator.getComponent(0)).getText(), "In Stock");
	}
}
