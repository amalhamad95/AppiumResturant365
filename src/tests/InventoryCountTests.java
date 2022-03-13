package tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import ui.InventoryCount.InventoryCount;
import ui.InventoryCount.InventoryCountActions;
import ui.InventoryCount.InventoryCountAssertions;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InventoryCountTests {

	InventoryCount page = new InventoryCount();
	InventoryCountActions actions = new InventoryCountActions();
	InventoryCountAssertions assertions = new InventoryCountAssertions();

	@Test
	public void TC01_verifyManagerCanNavigateToInventoryCount() {
		actions.openNavigationMenu()//
				.navigateToInventoryCount();

		assertions.//
				verifyInventoryCountIsOpened()//
				.verifyInProgressTabIsSelected();
	}

	@Test
	public void TC02_verifyErrorMessageAppearsWhenSearchForInvalidInput() {
		actions.typeInSearchInput("abcdefg");
		assertions.verifyNoResultsFoundIsDisplayed();
	}

	@Test
	public void TC03_verifyResultsFoundWhenSearchForValidInput() {
		actions.typeInSearchInput("Testing");
		assertions.verifyInventoryListContainItems("Testing");
	}
}
