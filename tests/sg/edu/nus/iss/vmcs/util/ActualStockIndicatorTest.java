package sg.edu.nus.iss.vmcs.util;

import java.awt.Label;

import junit.framework.TestCase;

import org.junit.Test;

import sg.edu.nus.iss.vmcs.util.ActualStockIndicator;
import sg.edu.nus.iss.vmcs.util.StockIndicator;

public class ActualStockIndicatorTest extends TestCase {

	@Test
	public void testActualStockIndicatorReturnNumberOfItemsLeft() {
		StockIndicator indicator = new ActualStockIndicator(2);
		assertEquals(((Label)indicator.getComponent(0)).getText(), "2 left");
	}
}
