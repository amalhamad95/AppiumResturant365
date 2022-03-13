package ui.InventoryCount;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import tests.BaseTest;

public class InventoryCount extends BaseTest{

	@AndroidFindBy(accessibility =  "Open navigation drawer")
	MobileElement openNavigationIcon;

	@AndroidFindBy(id = "take_inventory")
	MobileElement inventoryCountNavigationButton;

}
