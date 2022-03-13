package tests;

import org.junit.Test;

import ui.InventoryCount.InventoryCountActions;
import ui.InventoryCount.InventoryCountAssertions;

public class InventoryCountTests {

	InventoryCountActions actions = new InventoryCountActions();
	InventoryCountAssertions assertions = new InventoryCountAssertions();

	@Test
	public void verifyManagerCanNavigateToInventoryCount() {
		actions.openNavigationMenu()//
				.navigateToInventoryCount();
	}
}
