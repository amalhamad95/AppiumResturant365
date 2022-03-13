package ui.InventoryCount;

import tests.BaseTest;

public class InventoryCountActions {

	InventoryCount page = new InventoryCount();

	public InventoryCountActions openNavigationMenu() {
		page.openNavigationIcon.click();
		return this;
	}

	public InventoryCountActions navigateToInventoryCount() {
		BaseTest.waitVisibilityOf(page.inventoryCountNavigationButton);
		page.inventoryCountNavigationButton.click();
		return this;
	}
	
	public InventoryCountActions typeInSearchInput(String searchText) {
		BaseTest.waitVisibilityOf(page.searchInput);
		page.searchInput.click();
		page.searchInput.clear();
		page.searchInput.sendKeys("");
		page.searchInput.sendKeys(searchText);
		BaseTest.driver.hideKeyboard();
		return this;
	}
}
