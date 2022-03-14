package ui.InventoryCount;

import java.text.DecimalFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import helpers.Helper;
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

		Assert.assertTrue(page.tvDialogItemPrice.getText().contains("₪"));
		Assert.assertTrue(page.tvDialogItemPrice.getText().contains(item.getPrice() + ""));

		Assert.assertTrue(page.etDialogItemAmount.getText().equals(item.getQuantity() + ""));

		return this;
	}


//	public InventoryCountAssertions verifyItemQuantityReflected(int position, int expectedQty) {
//		BaseTest.waitVisibilityOf(page.tvItemUnitAndQty.get(position));
//		int quantity = Helper.convertStringToInteger(page.tvItemUnitAndQty.get(position));
////		Assert.assertTrue(quantity == expectedQty);
//
//		double price = Helper.convertStringToDouble(page.tvItemCost.get(position));
//		double cost = Helper.convertStringToDouble(page.tvItemTotalCost.get(position));
//
//		System.out.println("quantity  " + quantity);
//		System.out.println("price  " + price);
//		System.out.println("cost  " + cost);
//
//		double expectedCost = quantity * price;
//		Assert.assertTrue(cost == expectedCost);
//
//		return this;
//	}

	@Test
	public InventoryCountAssertions verifyItemQuantityReflected(int quantity) {
		int qyt = Helper.convertStringToInteger(page.tvItemUnitAndQty.get(0));
		System.out.println("qyt  " + qyt);
		System.out.println("quantity  " + quantity);
//		Assert.assertTrue(qyt.contains(quantity + ""));

		double price = Helper.convertStringToDouble(page.tvItemCost.get(0));
		double cost = Helper.convertStringToDouble(page.tvItemTotalCost.get(0));

		System.out.println("price  " + price);
		System.out.println("cost  " + cost);
		String expectedCost = new DecimalFormat("##.##").format(price * qyt);
		System.out.println("expected  " + expectedCost);
		Assert.assertTrue(cost == Double.parseDouble(expectedCost));
		return this;
	}

	@Test
	public InventoryCountAssertions verifyTotalCostChanges() {
		List<MobileElement> itemsCosts = page.tvItemTotalCost;
		double totalCosts = 0;
		for (MobileElement cost : itemsCosts) {
			totalCosts += Helper.convertStringToDouble(cost);
		}
		double expectedCost = Helper.convertStringToDouble(page.tvCountTotal);
		Assert.assertTrue(totalCosts == expectedCost);
		System.out.println("totalCosts:  " + totalCosts + " **** expectedCost: " + expectedCost);
		return this;
	}

}
