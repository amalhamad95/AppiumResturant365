package ui.InventoryCount;

import java.util.List;

import helpers.Helper;
import io.appium.java_client.MobileElement;
import models.StorageItem;
import models.StorageLocation;
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
		page.searchInput.sendKeys(searchText);
		BaseTest.driver.hideKeyboard();
		return this;
	}

	public InventoryCountActions clickOnInventoryByPosition(int position) {
		BaseTest.waitVisibilityOf(page.inventoryCountsList);
		// Get list of current visible items
		List<MobileElement> inventoryList = page.tvInventoryName;
		System.out.println("inventoryList size: " + inventoryList.size());
		inventoryList.get(position).click();
		return this;
	}

	public StorageLocation clickOnStorageByPosition(int position) {
		StorageLocation storageLocation = new StorageLocation();

		BaseTest.waitVisibilityOf(page.storageList);
//		List<MobileElement> storageList = page.tvStorageName;
//		System.out.println("storageList size: " + storageList.size());

		storageLocation.setStorageName(page.tvStorageName.get(position).getText());
		storageLocation.setItemsCount(Helper.convertStringToInteger(page.tvStorageItemsCount.get(position)));

		page.tvStorageName.get(position).click();

		return storageLocation;
	}

	public StorageItem clickOnStorageItemByPosition(int position) {
		StorageItem storageItem = new StorageItem();

		BaseTest.waitVisibilityOf(page.storageItemsList);

		storageItem.setName(page.tvItemName.get(position).getText());

		String[] UnitAndQty = page.tvItemUnitAndQty.get(position).getText().split(" ");
		storageItem.setQuantity(Integer.parseInt(UnitAndQty[0]));
		storageItem.setUnit(UnitAndQty[1]);

		storageItem.setPrice(Helper.convertStringToDouble(page.tvItemCost.get(position)));

		page.tvItemName.get(position).click();

		return storageItem;
	}

	public InventoryCountActions typeInItemQuantityInput(String quantity) {
		BaseTest.waitVisibilityOf(page.etDialogItemAmount);
		page.etDialogItemAmount.click();
		page.etDialogItemAmount.clear();
		page.etDialogItemAmount.sendKeys(quantity);
		BaseTest.driver.hideKeyboard();
		return this;
	}

	public InventoryCountActions closeItemDetailsDialog() {
		BaseTest.waitVisibilityOf(page.imvCloseDialog);
		page.imvCloseDialog.click();
		return this;
	}
}
