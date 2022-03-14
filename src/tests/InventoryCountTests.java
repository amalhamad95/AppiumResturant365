package tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import models.StorageItem;
import models.StorageLocation;
import ui.InventoryCount.InventoryCountActions;
import ui.InventoryCount.InventoryCountAssertions;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InventoryCountTests {

	InventoryCountActions actions = new InventoryCountActions();
	InventoryCountAssertions assertions = new InventoryCountAssertions();
	Random random = new Random();
	int quantity = random.nextInt(99 - 1 + 1) + 1;

//	Random random = new Random();
//	int quantity = random.nextInt(99 - 1 + 1) + 1;

	StorageLocation storageLocation = new StorageLocation();
	StorageItem storageItem = new StorageItem();

	@Test
	public void TC01_verifyManagerCanNavigateToInventoryCount() {
		actions.openNavigationMenu().navigateToInventoryCount();

		assertions//
				.verifyInventoryCountIsOpened()//
				.verifyInProgressTabIsSelected();
	}

	@Test
	public void TC02_verifySearchInputPlacholder() {
		assertions//
				.verifySearchInputPlaceholder()//
				.verifySearchInputPlaceholderDisapperOnFocuse();
	}

	@Test
	public void TC03_verifyErrorMessageAppearsWhenSearchForInvalidInput() {
		actions.typeInSearchInput("abcdef");
		assertions.verifyNoResultsFoundIsDisplayed();
	}

	@Test
	public void TC04_verifyResultsFoundWhenSearchForValidInput() {
		actions.typeInSearchInput("Testing");
		assertions.verifyInventoryListContainItems("Testing");
	}

	@Test
	public void TC05_verifyManagerCanNavigateToStorageItems() {
		actions.clickOnInventoryByPosition(0);

		storageLocation = actions.clickOnStorageByPosition(0);
		System.out.println(storageLocation.toString());

		assertions.verifyStorageItemsCount(storageLocation.getItemsCount());
	}

	@Test
	public void TC06_verifyManagerCanOpenItemDetailsDialog() {
		storageItem = actions.clickOnStorageItemByPosition(0);
		System.out.println(storageItem.toString());

		assertions.verifyItemDetailsInDialog(storageItem);
	}

	@Test
	public void TC07_verifyManagerCanChangeItemQuantity() {
		int quantity = actions.fillQuantityInput();
		storageItem.setQuantity(quantity);
		System.out.println("getQuantity: " + storageItem.getQuantity());

		actions.closeItemDetailsDialog();
//		actions.typeInItemQuantityInput(quantity + "").closeItemDetailsDialog();

	}

	@Test
	public void TC08_verifyItemQuantityChanged() {
		assertions.verifyItemQuantityReflected(storageItem.getQuantity());
	}

	@Test
	public void TC09_verifyTotalCosts() {
		assertions.verifyTotalCostChanges();
	}

}
