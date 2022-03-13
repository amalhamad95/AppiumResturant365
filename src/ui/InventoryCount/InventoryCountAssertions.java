package ui.InventoryCount;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import io.appium.java_client.MobileElement;
import tests.BaseTest;

public class InventoryCountAssertions {

	InventoryCount page = new InventoryCount();

	@Test
	public InventoryCountAssertions verifyInventoryCountIsOpened() {
		BaseTest.waitVisibilityOf(page.InventoryCountTitle);
		Assert.assertTrue(page.InventoryCountTitle.isDisplayed());
		Assert.assertTrue(page.InventoryCountTitle.getText().contains("Inventory Counts"));
		return this;
	}

	@Test
	public InventoryCountAssertions verifyInProgressTabIsSelected() {
		BaseTest.waitVisibilityOf(page.tabInProgress);
		Assert.assertTrue(page.tabInProgress.getAttribute("selected").equals("true"));
		return this;
	}

	@Test
	public InventoryCountAssertions verifyNoResultsFoundIsDisplayed() {
		BaseTest.waitVisibilityOf(page.tvNoResultsFound);
		Assert.assertTrue(page.tvNoResultsFound.isDisplayed());
		Assert.assertTrue(page.tvNoResultsFound.getText().contains("No results found"));
		return this;
	}

	@Test
	public InventoryCountAssertions verifyInventoryListContainItems(String searchText) {
		BaseTest.waitVisibilityOf(page.inventoryCountsList);
		Assert.assertTrue(page.inventoryCountsList.isDisplayed());

		// Get list of current visible items
		List<MobileElement> inventoryList = page.tvInventoryName;
		System.out.println("inventoryList size: " + inventoryList.size());

		for (int i = 0; i < inventoryList.size(); i++) {
			String item = inventoryList.get(i).getText();
			System.out.println("item: " + item);
			Assert.assertTrue(item.toLowerCase().contains(searchText.toLowerCase()));
		}

		return this;
	}

}
