package sg.edu.nus.iss.vmcs.store;

import java.awt.Label;

import junit.framework.TestCase;

import org.junit.Test;

import sg.edu.nus.iss.vmcs.util.NoStockIndicator;
import sg.edu.nus.iss.vmcs.util.StockIndicator;

public class NoStockIndicatorTest extends TestCase {

	@Test
	public void testNoStockIndicatorReturnOutOfStockForQuantityOfZero() {
		StockIndicator indicator = new NoStockIndicator(0);
		assertEquals(((Label)indicator.getComponent(0)).getText(), "Out of Stock");
	}

	@Test
	public void testNoStockIndicatorReturnInStockForQuantityOfOne() {
		StockIndicator indicator = new NoStockIndicator(1);
		assertEquals(((Label)indicator.getComponent(0)).getText(), "In Stock");
	}
}
