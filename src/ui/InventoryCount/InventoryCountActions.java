package ui.InventoryCount;

import java.util.List;
import java.util.Random;

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
		page.btnDialogEnter.click();
		return this;
	}

	public int fillQuantityInput() {
		page.btn_clear.click();
		Random random = new Random();
		int firstNum = random.nextInt(9 - 0 + 1) + 0;
		int secondNum = random.nextInt(9 - 0 + 1) + 0;
		MobileElement[] calculatorNumberElements = { page.btn_num_0, page.btn_num_1, page.btn_num_2, page.btn_num_3,
				page.btn_num_4, page.btn_num_5, page.btn_num_6, page.btn_num_7, page.btn_num_8, page.btn_num_9 };
		calculatorNumberElements[firstNum].click();
		calculatorNumberElements[secondNum].click();
		int quantity = Integer.parseInt(firstNum + "" + secondNum);
		return quantity;
	}

	public InventoryCountActions closeItemDetailsDialog() {
		BaseTest.waitVisibilityOf(page.imvCloseDialog);
		page.imvCloseDialog.click();
		return this;
	}
}
