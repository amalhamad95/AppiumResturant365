package ui.InventoryCount;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import io.appium.java_client.MobileElement;
import models.StorageItem;
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
	public InventoryCountAssertions verifySearchInputPlaceholder() {
		BaseTest.waitVisibilityOf(page.searchInput);
		Assert.assertTrue(page.searchInput.getText().contains("Search by template or location"));
		return this;
	}

	@Test
	public InventoryCountAssertions verifySearchInputPlaceholderDisapperOnFocuse() {
		page.searchInput.click();
		Assert.assertTrue(page.searchInput.getText().contains(""));
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

	@Test
	public InventoryCountAssertions verifyStorageItemsCount(int expectedCount) {
		BaseTest.waitVisibilityOf(page.storageItemsList);
		Assert.assertTrue(page.storageItemsList.isDisplayed());

		// Get list of current visible items
		Assert.assertEquals(page.tvItemName.size(), expectedCount);
		System.out.println("ItemName size: " + page.tvItemName.size());
		return this;
	}

	@Test
	public InventoryCountAssertions verifyItemDetailsInDialog(StorageItem item) {
		BaseTest.waitVisibilityOf(page.itemDialog);
		Assert.assertTrue(page.itemDialog.isDisplayed());

		Assert.assertTrue(page.tvDialogItemName.getText().equals(item.getName()));
		Assert.assertTrue(page.tvDialogItemUnit.getText().equals(item.getUnit()));

//		Assert.assertTrue(page.tvDialogItemPrice.getText().contains("₪"));
		Assert.assertTrue(page.tvDialogItemPrice.getText().contains(item.getPrice() + ""));

		Assert.assertTrue(page.etDialogItemAmount.getText().equals(item.getQuantity() + ""));

		return this;
	}

	@SuppressWarnings("deprecation")
	@Test
	public InventoryCountAssertions verifyItemQuantityReflected(String quantity) {
		String qyt = page.tvItemUnitAndQty.get(0).getText();
		System.out.print("qyt  " + qyt);
		System.out.print("quantity  " + quantity);
		Assert.assertTrue(qyt.contains(quantity));

		double price = Double.parseDouble(page.tvItemCost.get(0).getText().split("[$/]")[1]);
		double cost = Double.parseDouble(page.tvItemTotalCost.get(0).getText().split("[$]")[1]);

		System.out.print("price  " + price);
		System.out.print("cost  " + cost);
		Assert.assertEquals(cost, price * Double.parseDouble(qyt));
		return this;
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public InventoryCountAssertions verifyTotalCostChanges() {
		List<MobileElement> costs = page.tvItemTotalCost;
		double totalCosts = 0;
		for(MobileElement cost: costs) {
			totalCosts = totalCosts + Double.parseDouble(cost.getText().split("[$]")[1]);
		}
		double countDouble = Double.parseDouble(page.tvCountTotal.getText().split("[$]")[1]);
		Assert.assertEquals(countDouble, totalCosts);
		return this;
	} 

}
